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

    @Override
    public String getFormattedInfo(String x, int y){
        String result = String.format(
                "[Operator]\n" + super.getFormattedInfo(x, y) + '\n'
        );
        return result;
    }
}
