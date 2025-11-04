package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {

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
                "personalBonusPercent=" + personalBonusPercent +
                ", personalBonusPercent=" + profitFromSales +
                "} " + super.toString();
    }

    @Override
    public String getFormattedInfo(String x, int y){
        String result = String.format(
                   "\n"+ x.repeat(y) + "[Manager]" +
                   "\n"+ x.repeat(y+1) + "personalBonusPercent = " + personalBonusPercent +
                   "\n"+ x.repeat(y+1) + "personalBonusPercent = " + profitFromSales +
                   '\n' + super.getFormattedInfo(x, y)
                );


        return result;
    }
}
