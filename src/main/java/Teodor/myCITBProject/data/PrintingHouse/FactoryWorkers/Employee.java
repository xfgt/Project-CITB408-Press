package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers.ISalaries;

public abstract class Employee implements ISalaries {
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
