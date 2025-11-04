package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers.ISalaries;
import Teodor.myCITBProject.service.PrintingHouse.IPrintInfo;

import java.io.Serializable; // Да се сериализират и десериализират данните за служител в печатницата.

public abstract class Employee implements ISalaries, Serializable, IPrintInfo {
    private double baseSalary;

    public Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public String getFormattedInfo(String x, int y){
        String result = String.format(
                x.repeat(y) + "[Employee]" +
                "\n"+ x.repeat(y+1) + "baseSalary = " + baseSalary + '\n');


        return result;
    };

}
