package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers.ISalaries;

import java.io.Serializable; // Да се сериализират и десериализират данните за служител в печатницата.

public abstract class Employee implements ISalaries, Serializable {
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

}
