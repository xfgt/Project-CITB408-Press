package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;

public class Placard extends Edition{

    PaperType paperType;
    public Placard(String title, int pages, PaperSize paperSize) {
        super(title, pages, paperSize);
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }

    @Override
    public String toString() {
        return "Placard{" +
                "paperType=" + paperType +
                "} " + super.toString();
    }

    @Override
    public double getPaperPrice() {
        // typeBasePrice * sizeMultiplier
        return paperType.getBasePrice() * super.getPaperSize().getPriceMultiplier();
    }
}