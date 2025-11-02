package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;

public class Newspaper extends Edition{

    public Newspaper(String title, int pages, PaperSize paperSize, PaperType paperType, boolean color) {
        super(title, pages, paperSize, paperType, color);
    }

    @Override
    public String toString() {
        return "Newspaper{" + super.toString() +
                '}';
    }
}
