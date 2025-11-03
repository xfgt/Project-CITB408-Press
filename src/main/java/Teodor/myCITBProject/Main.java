/*

    === ПРОЕКТ НА ТЕОДОР МАНГЪРОВ ===

    ФАКУЛТЕТЕН НОМЕР: F113621
    ИМЕЙЛ АДРЕС: f113621@students.nbu.bg
    КУРС: CITB408
    ОПИСАНИЕ НА ЗАДАНИЕ: "CITB4082025Project2_Press.pdf"
    ВАРИАНТ: 2-РИ
    JDK: 21


    ВСЯКАКВО КОПИРАНЕ, ИЗПОЛЗВАНЕ И ПРЕДСТАВЯНЕ НА ПРОЕКТА ЗА СВОЙ ВЪРХУ КОНКРЕТНО ИЗПИТНО ИЛИ ПОДОБНО НА ТАКОВА ОЦЕНЯВАЩО ЗАДАНИЕ Е ЗАБРАНЕНО!!!
    ВСИЧКИ ПРАВА СА ЗАПАЗЕНИ.
    xfgt@github.com


 */


package Teodor.myCITBProject;

import Teodor.myCITBProject.data.PrintingHouse.Editions.*;
import Teodor.myCITBProject.data.PrintingHouse.Enums.*;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Employee;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.EmployeeSerializationAndDeserializationServiceImplementation;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Manager;
import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Operator;
import Teodor.myCITBProject.data.PrintingHouse.PressBuilding;
import Teodor.myCITBProject.data.PrintingHouse.PressMachine;
import Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers.EmployeeSerializationAndDeserializationService;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("=======================================");
        System.out.println("PROJECT FROM COURSE CITB408 - \"PRESS\"");
        System.out.println("=======================================\n\n\n\n\n\n");
        System.out.println("Teodor.myCITBProject.Main");

        Employee manager = new Manager(1600, 5, 10);
        Employee operator1 = new Operator(950);
        Employee operator2 = new Operator(1000);
        Employee operator3 = new Operator(1010);

        ArrayList<Employee> employees1 = new ArrayList<>();
        employees1.add(manager);
        employees1.add(operator1);
        employees1.add(operator2);
        employees1.add(operator3);

        Edition newspaper = new Newspaper("Telegraf", 12, PaperSize.A3, PaperType.NEWSPAPER, false);
        Edition book = new Book("Pod igoto", 500, PaperSize.A5, PaperType.STANDARD, false);
        Edition book2 = new Book("Mecho Gruh", 120, PaperSize.A4, PaperType.GLOSSY, true);
        Edition placard = new Placard("Placard1", 20, PaperSize.A2, PaperType.GLOSSY, true);
        Edition placard2 = new Placard("Placard2", 3, PaperSize.A1, PaperType.NEWSPAPER, true);

        ArrayList<Edition> editions1 = new ArrayList<>();
        editions1.add(newspaper);
        editions1.add(book);
        editions1.add(book2);
        editions1.add(placard);
        editions1.add(placard2);




        Employee manager2 = new Manager(2600, 7, 3);
        Employee operator4 = new Operator(1500);
        Employee operator5 = new Operator(1260);
        Employee operator6 = new Operator(1450);

        ArrayList<Employee> employees2 = new ArrayList<>();
        employees2.add(manager2);
        employees2.add(operator4);
        employees2.add(operator5);
        employees2.add(operator6);

        Edition newspaper2 = new Newspaper("Kaldata", 18, PaperSize.A4, PaperType.STANDARD, true);
        Edition newspaper3 = new Newspaper("Svoboda", 10, PaperSize.A3, PaperType.NEWSPAPER, false);
        Edition book3 = new Book("Ego is Enemy", 180, PaperSize.A5, PaperType.STANDARD, true);
        Edition book4 = new Book("Shekspir", 700, PaperSize.A5, PaperType.NEWSPAPER, false);
        Edition placard3 = new Placard("Reklama efbet", 80, PaperSize.A1, PaperType.GLOSSY, true);


        ArrayList<Edition> editions2 = new ArrayList<>();
        editions2.add(newspaper2);
        editions2.add(newspaper3);
        editions2.add(book3);
        editions2.add(book4);
        editions2.add(placard3);

        PressMachine pressMachine1 = new PressMachine("Mashina 1", 200000, false);
        PressMachine pressMachine2 = new PressMachine("Mashina 2", 300000, true);
        ArrayList<PressMachine> machines1 = new ArrayList<>();

        machines1.add(pressMachine1);
        machines1.add(pressMachine2);


        PressMachine pressMachine3 = new PressMachine("Mashina 3", 12000, false);
        PressMachine pressMachine4 = new PressMachine("Mashina 4", 50000, true);
        ArrayList<PressMachine> machines2 = new ArrayList<>();

        machines2.add(pressMachine3);
        machines2.add(pressMachine4);








        EmployeeSerializationAndDeserializationService service = new EmployeeSerializationAndDeserializationServiceImplementation();
        String fileName = "java_binary_file_with_employees.ser";



        try{

            PressBuilding pb1 = new PressBuilding("Pechatnica NDK", employees1, machines1, 1500);
            PressBuilding pb2 = new PressBuilding("Pechatnica Serdika", employees2, machines2, 2000);



//            for(Employee e : pb1.getEmployees()){
//                System.out.println(e);
//                service.serializeEmployee(fileName, e);;
//            }

//            service.serializeEmployee(fileName, manager);
//            Employee employee =  service.deSerializeEmployee(fileName);
//            System.out.println(employee);




            Employee x = service.deSerializeEmployee(fileName);
            System.out.println(x);

            Employee y = service.deSerializeEmployee(fileName);
            System.out.println(y);

            Employee z = service.deSerializeEmployee(fileName);
            System.out.println(z);









//        } catch (FileNotFoundException e){
//            System.out.println("File was not found: " + e.getLocalizedMessage());
//            throw new RuntimeException(e);
//        } catch (IOException e){
//            System.out.println("File error: " + e.getLocalizedMessage());
//            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println("Caught other exception: " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

    }
}
