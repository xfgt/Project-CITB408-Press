package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.Exception.IncompatibleEditionException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.MachineOverloadException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.MachineException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.PrintingException;

import java.util.HashMap;
import java.util.Map;

public class PressMachine {
    private int machineSheetsCapacity;
    private int loadedSheetsAmount;
    private int accumulatedSheets; // колко страници е отпечатала машината

    private boolean printsInColor;
    private Map<Edition, Integer> printedEditions = new HashMap<>();


    public PressMachine(int machineSheetsCapacity, boolean color) throws IllegalArgumentException {
        if(machineSheetsCapacity <= 0)
            throw new IllegalArgumentException("Capacity must be above zero!");

        this.machineSheetsCapacity = machineSheetsCapacity;
        this.printsInColor = color;
    }

    public int getMachineSheetsCapacity() {
        return machineSheetsCapacity;
    }

    public int getLoadedSheetsAmount() {
        return loadedSheetsAmount;
    }
    public int getAccumulatedSheetsOfPaper(){ // Необходимо е да се реализира метод, който да връща колко страници са отпечатани на машината.
        return accumulatedSheets;
    }
    public Map<Edition, Integer> getPrintedEditions(){
        return printedEditions;
    }



    public void loadPaper(int amountOfSheets) throws MachineException, IllegalArgumentException {

        if(amountOfSheets <= 0)
            throw new IllegalArgumentException("Argument must be positive value!");

        if(loadedSheetsAmount + amountOfSheets > machineSheetsCapacity) // must not exceed machineSheetsCapacity!
            throw new MachineOverloadException("Machine overloaded with sheets (above capacity)");

        loadedSheetsAmount += amountOfSheets;
    }

    // При печат на всяко издание, трябва да се определя дали ще се използва цветен или черно-бял печат.
    public void printEdition(Edition edition, int copies) throws PrintingException, IllegalArgumentException  {

        // Ако печатната машина не е от подходящия тип, трябва да се хвърля изключение.
        if (edition.isColor() != this.printsInColor)
            throw new IncompatibleEditionException("Machine does not print with that type of edition: " + edition.getPaperType());


        if(loadedSheetsAmount <= 0)
            throw new PrintingException("No paper.");


        if(copies <= 0)
            throw new IllegalArgumentException("Cannot print zero or negative copies for an existing Edition!");


        int totalPages = edition.getPages() * copies;
        if (totalPages > loadedSheetsAmount)
            throw new PrintingException("Not enough paper");

        accumulatedSheets += totalPages;
        loadedSheetsAmount -= totalPages;

        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + copies);
    }


}
