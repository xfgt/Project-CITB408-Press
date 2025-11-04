package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;

public class Placard extends Edition{

    public Placard(String title, int pages, PaperSize paperSize, PaperType paperType, boolean color) {
        super(title, pages, paperSize, paperType, color);
    }

    @Override
    public String toString() {
        return "Placard{" + super.toString() +
                '}';
    }

    @Override
    public String getFormattedInfo(String x, int y){
        String result = String.format(
                "[Placard]->" + super.getFormattedInfo(x, y)
        );


        return result;
    };

}