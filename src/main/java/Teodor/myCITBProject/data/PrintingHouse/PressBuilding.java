package Teodor.myCITBProject.data.PrintingHouse;



import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Employee;

import java.util.ArrayList;



public class PressBuilding {

    private final String name;
    private final ArrayList<Employee> employees;
    private final ArrayList<PressMachine> machines;
    private final double goalForProfits;

    private int editionQuantityOfCopiesLimit;   // sets with a setter (default is 10)
    private double editionDiscount;             // sets with a setter



    // fix ~79.80000000...01 to 79.80
    private static double fixDouble(double x){ // the copy lives here
        // double originalNumber = x; // instead of here. (copy of copy) unnecessary.
        return Math.round(x * 100.0) / 100.0;
    }

    public PressBuilding(
            String name,
            ArrayList<Employee> employees,
            ArrayList<PressMachine> machines,
            double goalForProfits
    ){
        this.name = name;
        this.employees = employees;
        this.machines = machines;
        this.goalForProfits = goalForProfits;
        this.editionQuantityOfCopiesLimit = 10; // default value; provided external setter for member-variable.
    }
    public String getName() {
        return name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<PressMachine> getMachines() {
        return machines;
    }

    public int getEditionQuantityOfCopiesLimit() {
        return editionQuantityOfCopiesLimit;
    }

    public void setEditionQuantityOfCopiesLimit(int editionQuantityOfCopiesLimit) {
        this.editionQuantityOfCopiesLimit = editionQuantityOfCopiesLimit;
    }

    public double getEditionDiscount() {
        return editionDiscount;
    }

    public void setEditionDiscount(double editionDiscount) {
        this.editionDiscount = editionDiscount;
    }

    public double getGoalForProfits() {
        return goalForProfits;
    }

    /*
            Приходите на печатницата са от отпечатаните издания,
            като се определя цена за отпечатване на 1 бр. от съответното издание,
            което клиентът на печатницата заплаща .
         */
    public double getPaperProfits(){
        double totalPaperProfitsFromPrintedEditionsWithVAT=0.; // VAT === ДДС

        for(PressMachine pressMachine : machines){
            for(Edition edition : pressMachine.getPrintedEditions().keySet()){


                /*
                    Ако отпечатваните издания надхвърлят предварително зададен брой,
                    на клиентите се прави отстъпка с определен
                    % от цената за отпечатване на 1 бр.
                 */
                int printedEditionsCount = pressMachine.getPrintedEditions().get(edition); // <K, _V_>
                double editionPriceAllCopies = edition.getEditionCustomerPriceForACopy() * printedEditionsCount;

                if(getEditionQuantityOfCopiesLimit() > 0 && editionDiscount > 0.){

                    // ако има превишен брой издания има custom зададена отстъпка през сетъра на обекта
                    if(printedEditionsCount >= getEditionQuantityOfCopiesLimit())
                        totalPaperProfitsFromPrintedEditionsWithVAT += (editionPriceAllCopies) - (editionPriceAllCopies * getEditionDiscount() / 100);
                    else
                        totalPaperProfitsFromPrintedEditionsWithVAT += editionPriceAllCopies;

                } else {

                    totalPaperProfitsFromPrintedEditionsWithVAT += editionPriceAllCopies;
                }
            }
        }

        



        return fixDouble(totalPaperProfitsFromPrintedEditionsWithVAT);
    }


    public double getEmployeeExpenses(){
        double totalEmployeeExpenses=0.;

        for(Employee employee : employees)
            totalEmployeeExpenses += employee.calculateSalary(goalForProfits);
        return fixDouble(totalEmployeeExpenses);
    }


    public double getPaperExpenses(){
        double totalPaperExpenses=0.;
        for(PressMachine pressMachine : machines){
            for(Edition edition : pressMachine.getPrintedEditions().keySet()){

                totalPaperExpenses +=
                        edition.getPriceForACopy()        // разходи САМО ЗА ЕДНО копие от множеството на принтираните типове издания
                        * pressMachine.getPrintedEditions().get(edition);   // умножено по броя копия от множеството на принтираните типове чрез ~
                                                                            // ~ съответната стойност (броя на копията за конкретното издание за обработка)
            }
        }
        return fixDouble(totalPaperExpenses);
    }


    @Override
    public String toString() {
        return "PressBuilding{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                ", machines=" + machines +
                ", goalForProfits=" + goalForProfits +
                ", editionQuantityOfCopiesLimit=" + editionQuantityOfCopiesLimit +
                ", editionDiscount=" + editionDiscount +
                '}';
    }
}


