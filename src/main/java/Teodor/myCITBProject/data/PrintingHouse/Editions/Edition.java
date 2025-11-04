package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.*;
import Teodor.myCITBProject.service.PrintingHouse.Editions.ICustomerPricing;
import Teodor.myCITBProject.service.PrintingHouse.Editions.IPaperPricing;
import Teodor.myCITBProject.service.PrintingHouse.IPrintInfo;


/*
В печатница се отпечатват различни издания – книги, плакати, вестници и др. Всяко от
изданията се определя от заглавие, брой и размер на страниците (А1, А2, А3, А4, А5).
 */
public abstract class Edition implements IPaperPricing, ICustomerPricing, IPrintInfo {
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
    public double getPaperPrice() { // цена за 1 лист хартия с конкретния тип и размер
        return (this.getPaperType().getBasePrice() * this.getPaperSize().getPriceMultiplier()) ;
    }

    @Override
    public double getPriceForACopy() { // цена за 1 копие на издание със съответния тип и размер на хартия, заедно с броя страници
        return (getPaperPrice() * getPages());
    }


    @Override
    public double getEditionCustomerPriceForACopy(){ // продажна цена
        return (getPriceForACopy()) + (getPriceForACopy() * 20 /100); // 5.1 -> 6.12; Имитираме цена продажба: цена за производство + ДДС 20% (VAT)
    }


    @Override
    public String getFormattedInfo(String x, int y){
        String result = String.format(
                "[Edition] " + title +
                "\n" + x.repeat(y) + "pages " + pages +
                "\n" + x.repeat(y) + "paperSize " + paperSize + " (" + paperSize.getPriceMultiplier() + ")" +
                "\n" + x.repeat(y) + "paperType " + paperType + " (" + paperType.getBasePrice() + ")" +
                "\n" + x.repeat(y) + "color " + ((color) ? "yes" : "no") + '\n'
        );


        return result;
    };


}
