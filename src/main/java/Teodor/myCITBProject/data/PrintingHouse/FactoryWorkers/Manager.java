package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

public class Manager extends Employee{


    /*
        определен процент върху основното заплащане, ако приходите на печатницата са повече от
        определена стойност, която се задава в печатницата.
     */
    private double percentBonus;
    private double profitCeiling; // определената стойност

    public Manager(double baseSalary, double percentBonus, double profitCeiling) {
        super(baseSalary);
        this.percentBonus = percentBonus;
        this.profitCeiling = profitCeiling;

        // TODO: negative values?
    }

    @Override
    public double calculateSalary(double printingHouseProfits) {
        if(printingHouseProfits > profitCeiling)
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
