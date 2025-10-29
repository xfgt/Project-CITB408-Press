package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.service.PrintingHouse.Editions.IPaperPrice;


/*
В печатница се отпечатват различни издания – книги, плакати, вестници и др. Всяко от
изданията се определя от заглавие, брой и размер на страниците (А1, А2, А3, А4, А5).
 */
public abstract class Edition implements IPaperPrice {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(PaperSize paperSize) {
        this.paperSize = paperSize;
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
