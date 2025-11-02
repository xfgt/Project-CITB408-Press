package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;

import java.util.HashMap;
import java.util.Map;

public class PressMachine {
    private int machineSheetsCapacity;
    private int loadedSheetsAmount;
    private int accumulatedSheets; // колко страници е отпечатала машината

    private boolean printsInColor;


    private Map<Edition, Integer> printedEditions = new HashMap<>();


    public PressMachine(int machineSheetsCapacity, boolean color) {
        this.machineSheetsCapacity = machineSheetsCapacity;
        this.printsInColor = color;
    }

    public void loadPaper(int amountOfSheets) throws IllegalArgumentException{
        if(loadedSheetsAmount + amountOfSheets > machineSheetsCapacity) // must not exceed machineSheetsCapacity!
            throw new IllegalArgumentException("Machine overloaded with sheets (above capacity)");

        loadedSheetsAmount += amountOfSheets;
    }

    // При печат на всяко издание, трябва да се определя дали ще се използва цветен или черно-бял печат.
    public void printEdition(Edition edition, int copies) throws Exception {

        // Ако печатната машина не е от подходящия тип, трябва да се хвърля изключение.
        if (edition.isColor() || printsInColor)
            throw new Exception("Machine does not print with that type of edition: " + edition.getPaperType());


        int totalPages = edition.getPages() * copies;
        if (totalPages > loadedSheetsAmount)
            throw new Exception("Not enough paper");

        accumulatedSheets += totalPages;
        loadedSheetsAmount -= totalPages;

        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + copies);

    }

    public int getAccumulatedSheetsOfPaper(){ // Необходимо е да се реализира метод, който да връща колко страници са отпечатани на машината.
        return accumulatedSheets;
    }

    public Map<Edition, Integer> getPrintedEditions(){
        return printedEditions;
    }
}
