package Teodor.myCITBProject.data.PrintingHouse.Enums;



public enum PaperType {
    /*



        При отпечатването на всяко издание може да се използва обикновена хартия, гланцирана
        хартия или хартия за отпечатване на вестници. Трябва да се пазят базови цени за всеки тип хартия, които са валидни за най-малкия
        размер хартия (A5).
     */
    STANDARD(0),
    GLOSSY(1),
    NEWSPAPER(2);


    public final int typeId;

    PaperType(int i) {
        this.typeId = i;
    }

    public final int getTypeId(){ return this.typeId; }


}
