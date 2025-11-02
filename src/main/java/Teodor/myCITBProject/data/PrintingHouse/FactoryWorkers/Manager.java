package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

public class Manager extends Employee{

    /*
        определен процент върху основното заплащане, ако приходите на печатницата са повече от
        определена стойност, която се задава в печатницата.
     */
    private double percentBonus;
    private double profit; // определената стойност

    public Manager(double baseSalary, double percentBonus, double profit) {
        super(baseSalary);
        this.percentBonus = percentBonus;
        this.profit = profit;
    }

    @Override
    public double calculateSalary(double printingHouseProfits) { // external -> PressBuilding profit
        if(profit > printingHouseProfits)
            return getBaseSalary() + (getBaseSalary() * percentBonus / 100);
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "percentBonus=" + percentBonus +
                ", profitCeiling=" + profit +
                "} " + super.toString();
    }
}
