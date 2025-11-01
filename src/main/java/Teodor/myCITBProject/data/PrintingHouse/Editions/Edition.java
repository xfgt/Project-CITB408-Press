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



    public Edition(String title, int pages, PaperSize paperSize) {
        this.title = title;
        this.pages = pages;
        this.paperSize = paperSize;


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




    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", paperSize=" + paperSize +
                '}';
    }
}
