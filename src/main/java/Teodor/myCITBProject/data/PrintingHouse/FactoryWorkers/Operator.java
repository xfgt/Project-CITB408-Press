package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

public class Operator extends Employee{
    public Operator(double baseSalary) {
        super(baseSalary);
    }

    @Override
    public double calculateSalary(double profit) {
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Operator salary=" + getBaseSalary() + "\n";
    }
}
