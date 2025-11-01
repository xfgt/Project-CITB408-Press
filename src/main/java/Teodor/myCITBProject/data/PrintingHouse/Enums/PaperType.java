package Teodor.myCITBProject.data.PrintingHouse.Enums;



public enum PaperType {
    /*

        При отпечатването на всяко издание може да се използва обикновена хартия, гланцирана
        хартия или хартия за отпечатване на вестници. Трябва да се пазят базови цени за всеки тип хартия, които са валидни за най-малкия
        размер хартия (A5).
     */
    NEWSPAPER(0.17),
    STANDARD(0.36),
    GLOSSY(1.58);


    private final double basePrice;

    PaperType(double x) {
        this.basePrice = x;
    }

    public final double getBasePrice(){ return this.basePrice; }


}
