package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

public class Manager extends Employee{

    private final double personalBonusPercent;
    private double profitFromSales; // определената стойност

    public Manager(double baseSalary, double personalBonusPercent, double profitFromSales) {
        super(baseSalary);
        this.personalBonusPercent = personalBonusPercent;
        this.profitFromSales = profitFromSales;
    }

    /*
        Мениджърите получават
        определен процент върху основното заплащане, ...
     */


    // ако приходите на печатницата са повече от определена стойност, която се задава в печатницата.
    @Override
    public double calculateSalary(double printingHouseProfits) { // external -> PressBuilding profit

        if(profitFromSales <= 0 || printingHouseProfits <= 0)
            return getBaseSalary();


        if((profitFromSales > printingHouseProfits))
            return getBaseSalary() + (getBaseSalary() * personalBonusPercent / 100);
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "percentBonus=" + personalBonusPercent +
                ", profitCeiling=" + profitFromSales +
                "} " + super.toString();
    }
}
