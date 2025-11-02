package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

public class Manager extends Employee{
    private double percentBonus;
    private double profitCeiling;

    public Manager(double baseSalary, double percentBonus, double profitCeiling) {
        super(baseSalary);
        this.percentBonus = percentBonus;
        this.profitCeiling = profitCeiling;
    }

    @Override
    public double calculateSalary(double profit) {
        if(profit > profitCeiling)
            return getBaseSalary() + (getBaseSalary() * percentBonus / 100);
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "percentBonus=" + percentBonus +
                ", profitCeiling=" + profitCeiling +
                "} " + super.toString();
    }
}
