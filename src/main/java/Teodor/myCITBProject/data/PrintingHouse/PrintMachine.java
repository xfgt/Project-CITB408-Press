package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;

import java.util.HashMap;
import java.util.Map;

public class PrintMachine {
    private int machineSheetsCapacity;
    private boolean printsInColor;


    private int sheetsLoad;
    private Map<Edition, Integer> printedEditions = new HashMap<>();


    public PrintMachine(int machineSheetsCapacity) { // TODO: test negatives
        this.machineSheetsCapacity = machineSheetsCapacity;
    }

    public void loadPaper(int amountOfSheets) throws IllegalArgumentException{
        if(sheetsLoad + amountOfSheets > machineSheetsCapacity) // must not exceed machineSheetsCapacity!
            throw new IllegalArgumentException("Machine overloaded with sheets (above capacity)");

        sheetsLoad += amountOfSheets;
    }

    // При печат на всяко издание, трябва да се определя дали ще се използва цветен или черно-бял печат.
    public int printEdition(Edition edition, int copies, boolean color) throws Exception {

        printsInColor = color;


        // Ако печатната машина не е от подходящия тип, трябва да се хвърля изключение.
        if (edition.isColor() && !printsInColor)
            throw new Exception("Machine does not print with that type of edition: " + edition.getPaperType());



        int totalPages = edition.getPages() * copies;
        if (totalPages > sheetsLoad)
            throw new Exception("Not enough paper");


        sheetsLoad -= totalPages;
        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + copies);

        return totalPages; // Необходимо е да се реализира метод, който да връща колко страници са отпечатани на машината
    }
}
