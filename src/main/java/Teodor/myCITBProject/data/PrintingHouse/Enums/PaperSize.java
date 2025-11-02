package Teodor.myCITBProject.data.PrintingHouse.Enums;

public enum PaperSize {



    A1(3.0),
    A2(2.5),
    A3(2.0),
    A4(1.5),
    A5(1.0);

    private double priceMultiplier;

    PaperSize(double m) { priceMultiplier = m; }

    public double getPriceMultiplier() { return priceMultiplier; }
    public void setPriceMultiplier(double _pm) {
        this.priceMultiplier = _pm;
    }
    /*
        За всеки следващ размер, цената на хартията трябва да се увеличава с
        определен процент. Освен това цените на хартията не трябва да бъдат едни и същи за всички
        печатници в приложението.
     */

}





