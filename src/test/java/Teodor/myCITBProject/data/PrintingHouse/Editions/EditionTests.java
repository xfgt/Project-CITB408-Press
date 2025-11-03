package Teodor.myCITBProject.data.PrintingHouse.Editions;

import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditionTests {

    @Test
    void getPaperPrice() {

        PaperType paperType = PaperType.STANDARD;
        PaperSize paperSize = PaperSize.A4;
        System.out.println(paperType.getBasePrice());
        System.out.println(paperSize.getPriceMultiplier());

        Edition mybook = new Book("",10, paperSize, paperType, true);
        System.out.println(mybook);


        assertEquals(paperType.getBasePrice() * paperSize.getPriceMultiplier(), mybook.getPaperPrice());


    }
}