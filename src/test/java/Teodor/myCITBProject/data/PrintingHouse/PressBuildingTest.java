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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PressBuildingTest {


    Employee manager, operator, manager2, operator2;

    Edition
            noColor_newspaper_12p,
            noColor_book_80p,
            color_placard_2p,
            color_book_150p;

    PressMachine
            pm1_noColor,
            pm2_Color;

    ArrayList<Employee>
            local_employees,
            local_employees2;

    ArrayList<PressMachine>
            local_machines,
            local_machines2;



    PressBuilding
            localPB,
            localPB2;

    @BeforeEach
    void setup(){
        manager = new Manager(1000, 5, 10);
        operator = new Operator(900);

        manager2 = new Manager(1600, 5, 14);
        operator2 = new Operator(900);




        noColor_newspaper_12p = new Newspaper("", 12, PaperSize.A2, PaperType.NEWSPAPER, false);
        /*
            0.17 (NEWSPAPER)
            2.5 (A2)
            =0.425.. FOR A SINGLE PAGE

            (PAGES * PRICE_PER_SHEET)
            12*0.425 = 5.1 FOR ONE COPY

         */



        noColor_book_80p = new Book("", 80, PaperSize.A5, PaperType.STANDARD, false);
        /*
            0.36 (STANDARD)
            1.0 (A5)
            =0.36 FOR A SINGLE PAGE


            (PAGES * PRICE_PER_SHEET)
            80*0.36 = 28.8 FOR ONE COPY
         */

        color_placard_2p = new Placard("", 2, PaperSize.A1, PaperType.GLOSSY, true);
        /*
            1.58 (GLOSSY)
            3.0 (A1)
            =4.74 FOR A SINGLE PAGE

            (PAGES * PRICE_PER_SHEET)
            2*4.74 = 9.48 FOR ONE COPY


         */
        color_book_150p = new Book("", 150, PaperSize.A4, PaperType.STANDARD, true);
        /*
            0.36 (STANDARD)
            1.5 (A4)
            =0.54 FOR A SINGLE PAGE

            (PAGES * PRICE_PER_SHEET)
            150 * 0.54 = 81 FOR ONE COPY

         */

        {
            pm1_noColor = new PressMachine(200, false);
            pm1_noColor.loadPaper(200);

            pm1_noColor.printEdition(noColor_newspaper_12p, 10); // 10 * 5.1 = 51.000..1
            pm1_noColor.printEdition(noColor_book_80p, 1);       // 1 * 28.8 = 28.799..9
                                                                        // total cost = 79.80000000...01

            local_employees = new ArrayList<>();
            local_employees.add(manager); // 1000.0
            local_employees.add(operator); // 900.0

            local_machines = new ArrayList<>();
            local_machines.add(pm1_noColor);

            localPB = new PressBuilding("", local_employees, local_machines, 1000);
        }



        {
            pm2_Color = new PressMachine(1000, true);
            pm2_Color.loadPaper(1000);
            pm2_Color.printEdition(color_placard_2p, 100);   // 100 * 9.48 = 948
            pm2_Color.printEdition(color_book_150p, 3);      // 3 * 81 = 243
                                                                    // ~= 1191

            local_employees2 = new ArrayList<>();
            local_employees2.add(manager2); // 1600
            local_employees2.add(operator2); // 900.0

            local_machines2 = new ArrayList<>();
            local_machines2.add(pm2_Color);

            localPB2 = new PressBuilding("", local_employees2, local_machines2, 1000);
        }
    }




    @Test
    void getEmployeeExpenses_whereManagerPersonalProfitFromSalesIsBelowTarget_returnSumOfBaseSalaries() {

        assertEquals(1900, localPB.getEmployeeExpenses()); // 1000 + 900 = 1900
        assertEquals(2500, localPB2.getEmployeeExpenses()); // 1600 + 900 = 2500



    }

    @Test
    void getEmployeeExpenses_whereManagerPersonalProfitFromSalesAboveTarget_returnSumOfBaseSalariesWithManagerPersonalBonusPercent() {

        //localPB_goalForProfits = 1000
        //localPB2_goalForProfits = 1000

        manager = new Manager(1000, 5, 1500); // 1000 + (1000*5/100) = 1050 + operator(900) = 1950
        manager2 = new Manager(1600, 5, 1500); // 1600 + (1600 * 5 /100) = 1680 + operator(900) = 2580

        ArrayList<Employee> new_employees = new ArrayList<>();
        new_employees.add(manager);
        new_employees.add(operator);

        ArrayList<Employee> new_employees2 = new ArrayList<>();
        new_employees2.add(manager2);
        new_employees2.add(operator2);



        localPB = new PressBuilding("", new_employees, local_machines, 1000);
        assertEquals(1950, localPB.getEmployeeExpenses());


        localPB2 = new PressBuilding("", new_employees2, local_machines2, 1000);
        assertEquals(2580, localPB2.getEmployeeExpenses());



    }

    @Test
    void getPaperExpences() {


        assertEquals(79.80, localPB.getPaperExpences());
        assertEquals(1191, localPB2.getPaperExpences());



    }
}