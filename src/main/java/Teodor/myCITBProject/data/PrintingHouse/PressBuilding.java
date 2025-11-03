package Teodor.myCITBProject.data.PrintingHouse;



import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Employee;

import java.util.ArrayList;



public class PressBuilding {

    private final String name;
    private final ArrayList<Employee> employees;
    private final ArrayList<PressMachine> machines;
    private final double goalForProfits;


    PressBuilding(
            String name,
            ArrayList<Employee> employees,
            ArrayList<PressMachine> machines,
            double goalForProfits
            ){
        this.name = name;
        this.employees = employees;
        this.machines = machines;
        this.goalForProfits = goalForProfits;
    }


    // fix ~79.80000000...01 to 79.80
    private static double fixDouble(double x){ // the copy lives here
        // double originalNumber = x; // instead of here. (copy of copy) unnecessary.
        return Math.round(x * 100.0) / 100.0;
    }




    /*
        Приходите на печатницата са от отпечатаните издания,
        като се определя цена за отпечатване на 1 бр. от съответното издание,
        което клиентът на печатницата заплаща .
     */
    public double getPaperProfits(){
        double totalPaperProfitsFromPrintedEditionsWithVAT=0.; // VAT === ДДС

        // getCustomerPricing()
        
        for(PressMachine pressMachine : machines){
            for(Edition edition : pressMachine.getPrintedEditions().keySet()){
                totalPaperProfitsFromPrintedEditionsWithVAT +=
                        edition.getEditionCustomerPriceForACopy() // цена за 1 копие с ддс
                        * pressMachine.getPrintedEditions().get(edition); // .. по всички копия от съответното издание
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


}


