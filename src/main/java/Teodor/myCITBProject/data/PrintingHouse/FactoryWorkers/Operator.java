package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import java.io.Serializable;

public class Operator extends Employee implements Serializable {
    public Operator(double baseSalary) {
        super(baseSalary);
    }

    @Override
    public double calculateSalary(double printingHouseProfits) {
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Operator salary=" + getBaseSalary() + "\n";
    }
}
