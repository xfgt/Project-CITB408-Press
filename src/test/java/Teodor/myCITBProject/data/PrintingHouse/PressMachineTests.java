package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Book;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Newspaper;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Placard;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;
import Teodor.myCITBProject.data.PrintingHouse.Exception.IncompatibleEditionException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.MachineOverloadException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.PrintingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PressMachineTests {


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



    // Constructor
    @Test
    void constructor_machineSheetsCapacityIsZeroOrNegative_throwIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () ->{
           pm = new PressMachine(0, false);
        });
        assertThrows(IllegalArgumentException.class, () ->{
            pm = new PressMachine(-1, false);
        });
    }


    // loadPaper

    @Test
    void loadPaper_negativeOrZeroSheetsValue_throwIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            pm.loadPaper(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            pm.loadPaper(0);
        });
    }

    @Test
    void loadPaper_sheetsEqualsCapacity_doesNotThrow(){
        assertDoesNotThrow(() -> {
            pm.loadPaper(100);
        });

    }
    @Test
    void loadPaper_sheetsAboveCapacity_ThrowMachineOverloadException(){
        assertThrows(MachineOverloadException.class, () -> {pm.loadPaper(101);});
    }




    // printEdition

    @Test
    void printEdition_printWithoutLoadedPaper_throwPrintingException(){
        Edition book = new Book("", 100, PaperSize.A4, PaperType.STANDARD, false);
        assertThrows(PrintingException.class, () -> {
            pm.printEdition(book, 1);
        });
    }

    @Test
    void printEdition_badArgumentForCopies_throwIllegalArgumentException(){
        pm.loadPaper(100);
        Edition book = new Book("", 100, PaperSize.A4, PaperType.STANDARD, false);
        assertThrows(IllegalArgumentException.class, () -> {
            pm.printEdition(book, 0);
        });
    }

    @Test
    void printEdition_machineHasNotEnoughPaper_thenThrowPrintingException() {
        pm.loadPaper(100);
        Edition book = new Book("", 101, PaperSize.A4, PaperType.STANDARD, false);


        assertThrows(PrintingException.class, () -> {
            pm.printEdition(book, 1);
        });
    }
    @Test
    void loadPaper_loadedSheetsAboveCapacityWhenSomeAmountAlreadyLoaded_ThrowMachineOverloadException(){
        pm.loadPaper(50);
        assertThrows(MachineOverloadException.class, () -> {pm.loadPaper(51);});
    }


    @Test
    void printEdition_machineWithColorPrintAndEditionNoColorMismatch_thenThrowIncompatibleEditionException() {
        pm = new PressMachine(100, true); // TRUE!
        pm.loadPaper(100);
        Edition book = new Book("", 100, PaperSize.A4, PaperType.STANDARD, false);
        assertThrows(IncompatibleEditionException.class, () -> {
            pm.printEdition(book, 1);
        });
    }

    @Test
    void printEdition_machineNoColorPrintAndEditionWithColorMissmatch_thenThrowIncompatibleEditionException() {
        pm.loadPaper(100);
        Edition book = new Book("", 100, PaperSize.A4, PaperType.STANDARD, true);

        assertThrows(IncompatibleEditionException.class, () -> {
            pm.printEdition(book, 1);
        });
    }

    // @Test
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