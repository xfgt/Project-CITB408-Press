package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;

public class Book extends Edition{

    public Book(String title, int pages, PaperSize paperSize, PaperType paperType, boolean color) {
        super(title, pages, paperSize, paperType, color);
    }

    @Override
    public double getPaperPrice() {
        return this.getPaperType().getBasePrice() * this.getPaperSize().getPriceMultiplier();
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                '}';
    }
}
