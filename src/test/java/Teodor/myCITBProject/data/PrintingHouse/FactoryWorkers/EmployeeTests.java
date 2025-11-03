package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTests {

    Manager m;
    Operator o;



    @Nested
    class OperatorTests{
        // Operator
        @Test
        void calculateSalary_profitIsN_OnCalculateSalary_returnBaseSalary(){
            o = new Operator(200);
            assertEquals(200, o.calculateSalary(200));
        }
    }




    @Nested
    class ManagerTests{
        // Manager
        @Test
        void calculateSalary_profitIsInLimitOfPrintingHouseProfits_returnBaseSalary() {
            m = new Manager(1500, 2, 5);
            assertEquals(1500, m.calculateSalary(5));
        }
        @Test
        void calculateSalary_profitIsUnderLimitOfPrintingHouseProfits_returnBaseSalary() {
            m = new Manager(1500, 2, 5);
            assertEquals(1500, m.calculateSalary(6));
        }

        @Test
        void calculateSalary_printingHouseProfitsIsZeroOrNegative_returnBaseSalary() {
            m = new Manager(1500, 2, 5);
            assertEquals(1500, m.calculateSalary(0));
            assertEquals(1500, m.calculateSalary(-1));
        }

        @Test
        void calculateSalary_managerProfitsIsZeroOrNegative_printingHouseProfitsIsNegativeOrZeroOrPositive_returnBaseSalary() {
            m = new Manager(1500, 2, 0);
            assertEquals(1500, m.calculateSalary(0));
            assertEquals(1500, m.calculateSalary(1));

            m = new Manager(1500, 2, -1);
            assertEquals(1500, m.calculateSalary(-1));
            assertEquals(1500, m.calculateSalary(0));
            assertEquals(1500, m.calculateSalary(1));

        }

    }

}