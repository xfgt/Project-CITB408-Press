package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Book;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Newspaper;
import Teodor.myCITBProject.data.PrintingHouse.Editions.Placard;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperSize;
import Teodor.myCITBProject.data.PrintingHouse.Enums.PaperType;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Employee;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Manager;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Operator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PressBuildingTest {

    @Test
    void getEmployeeExpenses() {



        Employee manager = new Manager(1000, 5, 10);
        Employee operator = new Operator(900);

        Employee manager2 = new Manager(1600, 7, 13);
        Employee operator2 = new Operator(900);




        Edition newspaper = new Newspaper("", 12, PaperSize.A2, PaperType.NEWSPAPER, false);
        Edition book = new Book("", 80, PaperSize.A5, PaperType.STANDARD, false);

        Edition placard = new Placard("", 2, PaperSize.A1, PaperType.GLOSSY, true);
        Edition book2 = new Book("", 150, PaperSize.A4, PaperType.STANDARD, true);

        PressMachine pm1 = new PressMachine(200, false);
        pm1.loadPaper(200);
        PressMachine pm2 = new PressMachine(200, true);
        pm2.loadPaper(200);

        double x = pm1.getLoadedSheetsAmount() + pm2.getLoadedSheetsAmount();
        System.out.println();










    }

    @Test
    void getPaperExpences() {
    }
}