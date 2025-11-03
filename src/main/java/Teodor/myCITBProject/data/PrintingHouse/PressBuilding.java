package Teodor.myCITBProject.data.PrintingHouse;



import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Employee;

import java.util.ArrayList;



public class PressBuilding {

    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<PressMachine> machines;
    private double goalForProfits;


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
        // continue
    }



    public double getEmployeeExpenses(){
        double totalExpenses=0.;

        for(Employee employee : employees){
            totalExpenses += employee.calculateSalary(goalForProfits);
        }

        return totalExpenses;
    }

    public double getPaperExpences(){
        double totalPaperExpences=0.;


        for(PressMachine pressMachine : machines){
            for(Edition edition : pressMachine.getPrintedEditions().keySet()){

                totalPaperExpences +=
                        edition.getPaperPrice() * edition.getPages() // разходи САМО ЗА ЕДНО копие от множеството на принтираните типове издания

                        * pressMachine.getPrintedEditions().get(edition); // умножено по броя копия от множеството на принтираните типове чрез ~
                                                                         // ~ съответната стойност (броя на копията за конкретното издание за обработка)
            }
        }


        double originalNumber = totalPaperExpences;
        double roundedNumber = Math.round(originalNumber * 100.0) / 100.0; // fix 79.80 being 79.80000000...01


        return roundedNumber;
    }


}


