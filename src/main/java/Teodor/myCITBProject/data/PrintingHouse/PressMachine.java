package Teodor.myCITBProject.data.PrintingHouse;

import Teodor.myCITBProject.data.PrintingHouse.Editions.Edition;
import Teodor.myCITBProject.data.PrintingHouse.Exception.IncompatibleEditionException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.MachineOverloadException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.MachineException;
import Teodor.myCITBProject.data.PrintingHouse.Exception.PrintingException;
import Teodor.myCITBProject.service.PrintingHouse.IPrintInfo;

import java.util.HashMap;
import java.util.Map;

public class PressMachine implements IPrintInfo {
    private String name;
    private int machineSheetsCapacity;
    private int loadedSheetsAmount;
    private int accumulatedSheets; // колко хартия е минала през машината

    private boolean printsInColor;
    private Map<Edition, Integer> printedEditions = new HashMap<>();


    public PressMachine(String name, int machineSheetsCapacity, boolean color) throws IllegalArgumentException {
        if(machineSheetsCapacity <= 0)
            throw new IllegalArgumentException("Capacity must be above zero!");

        this.name = name;
        this.machineSheetsCapacity = machineSheetsCapacity;
        this.printsInColor = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMachineSheetsCapacity() {
        return machineSheetsCapacity;
    }
    public int getAvailablePaper() {
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


        if(getAvailablePaper() <= 0)
            throw new PrintingException("No paper.");


        if(copies <= 0)
            throw new IllegalArgumentException("Cannot print zero or negative copies for an existing Edition!");


        int totalPages = edition.getPages() * copies;
        if (totalPages > loadedSheetsAmount)
            throw new PrintingException("Not enough paper");

        accumulatedSheets += totalPages;
        loadedSheetsAmount -= totalPages; // 1 copy

        printedEditions.put(edition, printedEditions.getOrDefault(edition, 0) + copies);
    }

    @Override
    public String toString() {
        return "PressMachine{" +
                "name='" + name + '\'' +
                ", machineSheetsCapacity=" + machineSheetsCapacity +
                ", loadedSheetsAmount=" + loadedSheetsAmount +
                ", accumulatedSheets=" + accumulatedSheets +
                ", printsInColor=" + printsInColor +
                ", printedEditions=" + printedEditions +
                '}';
    }

    @Override
    public String getFormattedInfo(String x, int y){
        String result = String.format(
                "[Press machine] " + name +
                 "\n" + x.repeat(y) + "capacity: " + machineSheetsCapacity +
                 "\n" + x.repeat(y) + "amount of loaded paper: " + loadedSheetsAmount +
                 "\n" + x.repeat(y) + "amount of accumulated sheets: " + accumulatedSheets +
                 "\n" + x.repeat(y) + "prints in color: " + ((printsInColor) ? "yes" : "no") +
                 "\n" + x.repeat(y) + "printed editions: "
        );
        for(Map.Entry<Edition, Integer> map : printedEditions.entrySet()){
            result += String.format(
                    "\n" + x.repeat(y+1) + map.getValue().toString() + " copies of: \n" +
                     x.repeat(y+1) + map.getKey().getFormattedInfo(x, y+2)
            );
        }



        return result;
    }
}
