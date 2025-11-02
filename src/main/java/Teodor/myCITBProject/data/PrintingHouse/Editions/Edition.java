package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.*;
import Teodor.myCITBProject.service.PrintingHouse.Editions.IPaperPricing;


/*
В печатница се отпечатват различни издания – книги, плакати, вестници и др. Всяко от
изданията се определя от заглавие, брой и размер на страниците (А1, А2, А3, А4, А5).
 */
public abstract class Edition implements IPaperPricing {
    private String title;
    private int pages;
    private PaperSize paperSize;
    private PaperType paperType;
    private boolean color;

    public Edition(String title, int pages, PaperSize paperSize, PaperType paperType, boolean color) {
        this.title = title;
        this.pages = pages;
        this.paperSize = paperSize;
        this.paperType = paperType;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public boolean isColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", paperSize=" + paperSize +
                ", paperType=" + paperType +
                ", color=" + color +
                '}';
    }

    @Override
    public double getPaperPrice() {
        return this.getPaperType().getBasePrice()
                + (this.getPaperType().getBasePrice() * this.getPaperSize().getPriceMultiplier()) ;
        // За всеки следващ размер, цената на хартията трябва да се увеличава с определен процент.
    }

}
