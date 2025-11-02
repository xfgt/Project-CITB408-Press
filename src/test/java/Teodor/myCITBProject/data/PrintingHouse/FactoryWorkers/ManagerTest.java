package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager m;

    @BeforeEach
    void setUp(){

    }

    @Test
    void calculateSalary_profitIsInLimit_returnBaseSalary() {
        m = new Manager(1500, 2, 5);
        assertEquals(1500, m.calculateSalary(5));
    }
    @Test
    void calculateSalary_profitIsOutOfLimit_returnBaseSalaryAndPercentage() {
        m = new Manager(1500, 2, 5);
        assertEquals(1500+(1500*2/100), m.calculateSalary(6));
    }

    @Test
    void calculateSalary_profitIsZero_returnBaseSalary() {
        m = new Manager(1500, 2, 5);
        assertEquals(1500, m.calculateSalary(0));
    }
    @Test
    void calculateSalary_profitIsNegative_returnBaseSalary() {
        m = new Manager(1600, 15, 10);
        assertEquals(1600, m.calculateSalary(-1));
    }

    // TODO: add tests for negative values of
    //  Manager::percentBonus and Manager::profitCeiling;
}