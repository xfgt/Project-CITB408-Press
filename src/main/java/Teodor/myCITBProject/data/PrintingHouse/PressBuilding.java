package Teodor.myCITBProject.data.PrintingHouse;



import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.Exception.PrintingException;
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
                totalPaperExpences += edition.getPaperPrice() * edition.getPages();
            }
            totalPaperExpences *= pressMachine.getLoadedSheetsAmount();
        }








        return totalPaperExpences;
    }


}


