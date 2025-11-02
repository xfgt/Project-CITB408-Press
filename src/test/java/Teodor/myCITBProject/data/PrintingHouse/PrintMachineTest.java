package Teodor.myCITBProject.data.PrintingHouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintMachineTest {


    PrintMachine pm;
    @Test
    void loadPaper_sheetsAboveCapacity_ThrowIllegalArgumentException(){
        pm = new PrintMachine(100);
        assertThrows(IllegalArgumentException.class, () -> {pm.loadPaper(101);});
    }

    @Test
    void loadPaper_sheetsAboveCapacityWhenSomeAmountAlreadyLoaded_ThrowIllegalArgumentException(){
        pm = new PrintMachine(100);
        pm.loadPaper(50);
        assertThrows(IllegalArgumentException.class, () -> {pm.loadPaper(51);});
    }

}