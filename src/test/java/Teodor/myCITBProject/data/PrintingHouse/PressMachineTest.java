package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Book;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Newspaper;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Placard;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PressMachineTest {


    PressMachine pm;

    Newspaper newspaper_A2_NEWSPAPER_noColored;
    Newspaper newspaper_A3_GLOSSY_colored;

    Book book_A5_STANDARD_noColored;
    Book book_A3_STANDARD_colored;

    Placard placard_A1_GLOSSY_colored;
    Placard placard_A4_NEWSPAPER_noColored;

    @BeforeEach
    void setup(){

        pm = new PressMachine(100, false);

        newspaper_A2_NEWSPAPER_noColored = new Newspaper("Telegraf", 36, PaperSize.A2, PaperType.NEWSPAPER, false);
        newspaper_A3_GLOSSY_colored = new Newspaper("Kapital", 24, PaperSize.A3, PaperType.GLOSSY, true);

        book_A5_STANDARD_noColored = new Book("Pod igoto", 500, PaperSize.A5, PaperType.STANDARD, false);
        book_A3_STANDARD_colored = new Book("Programming in C++ - Examples and solutions", 189, PaperSize.A3, PaperType.STANDARD, true);

        placard_A4_NEWSPAPER_noColored = new Placard("COWBOY WANTED - $100,000 price!", 1, PaperSize.A4, PaperType.NEWSPAPER, false);
        placard_A1_GLOSSY_colored = new Placard("Casino advertisement", 1, PaperSize.A1, PaperType.GLOSSY, true);

    }





    @Test
    void loadPaper_sheetsEqualsCapacity(){
        assertDoesNotThrow(() -> {
            pm.loadPaper(100);
        });

    }
    @Test
    void loadPaper_sheetsAboveCapacity_ThrowIllegalArgumentException(){

        assertThrows(IllegalArgumentException.class, () -> {pm.loadPaper(101);});
    }

    @Test
    void loadPaper_sheetsAboveCapacityWhenSomeAmountAlreadyLoaded_ThrowIllegalArgumentException(){

        pm.loadPaper(50);
        assertThrows(IllegalArgumentException.class, () -> {pm.loadPaper(51);});
    }

    @Test
    void printEdition_machineAndEditionColorMismatch_thenThrowException() {
        pm = new PressMachine(1000, true);
        Book bookWithColor = new Book("testColoredBook1", 100, PaperSize.A4, PaperType.STANDARD, true);
        Book bookNoColor = new Book("testUncoloredBook1", 100, PaperSize.A4, PaperType.STANDARD, false);
        pm.loadPaper(100);

        assertThrows(Exception.class, () -> {
            pm.printEdition(bookWithColor, 3);
        });
    }

    @Test
    void printEdition() {
        PressMachine pm = new PressMachine(5000, true);

            pm.loadPaper(4000); //TODO fix to custom exceptions
            assertThrows(Exception.class, () -> {
                pm.printEdition(newspaper_A2_NEWSPAPER_noColored, 3);
            }); // 12*3 pages




            assertThrows(Exception.class, ()->{
                pm.printEdition(book_A5_STANDARD_noColored, 6); // 500*6 pages
            });


    }
}