package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

public class Manager extends Employee{

    private final double personalBonusPercent;
    private double personalProfitFromSales; // определената стойност

    public Manager(double baseSalary, double personalBonusPercent, double personalProfitFromSales) {
        super(baseSalary);
        this.personalBonusPercent = personalBonusPercent;
        this.personalProfitFromSales = personalProfitFromSales;
    }

    /*
        Мениджърите получават
        определен процент върху основното заплащане, ...
     */


    // ако приходите на печатницата са повече от определена стойност, която се задава в печатницата.
    @Override
    public double calculateSalary(double printingHouseProfits) { // external -> PressBuilding profit

        if(personalProfitFromSales <= 0 || printingHouseProfits <= 0)
            return getBaseSalary();


        if((personalProfitFromSales > printingHouseProfits))
            return getBaseSalary() + (getBaseSalary() * personalBonusPercent / 100);
        return getBaseSalary();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "percentBonus=" + personalBonusPercent +
                ", profitCeiling=" + personalProfitFromSales +
                "} " + super.toString();
    }
}
