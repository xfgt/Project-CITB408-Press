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
import Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers.EmployeeSerializationAndDeserializationService;

import java.io.*;

public class Main {
    public static void main(String[] args){
        System.out.println("=======================================");
        System.out.println("PROJECT FROM COURSE CITB408 - \"PRESS\"");
        System.out.println("=======================================\n\n\n\n\n\n");
        System.out.println("Teodor.myCITBProject.Main");

        Newspaper newspaper = new Newspaper("Telegraf", 12, PaperSize.A3, PaperType.NEWSPAPER, false);
        /*System.out.println(newspaper);
        System.out.println(newspaper.getPaperPrice());
        System.out.println(newspaper.getPriceForACopy());
        System.out.println(newspaper.getEditionCustomerPriceForACopy());
*/

        Book book = new Book("Pod igoto", 500, PaperSize.A5, PaperType.STANDARD, true);
        /*System.out.println(book);
        System.out.println(book.getPaperPrice());
        System.out.println(book.getPriceForACopy());
        System.out.println(book.getEditionCustomerPriceForACopy());
*/

        Employee manager = new Manager(1000, 5, 10);
        Employee operator = new Operator(950);


        EmployeeSerializationAndDeserializationService service = new EmployeeSerializationAndDeserializationServiceImplementation();
        String fileName = "java_binary_file_with_employees.ser";



        try{
//                (FileWriter writer = new FileWriter("asdf.txt")) {
//                writer.append(book.toString() + '\n');
//                writer.append(newspaper.toString());

//                (BufferedReader br = new BufferedReader(new FileReader(("asdf.txt")))) {
//                String line;
//                while((line = br.readLine()) != null){
//                    System.out.println(line);
//                }

        // writing an object in a binary file format
//            {
//            FileOutputStream fout = new FileOutputStream("java_binary_file_with_employees.ser");
//            ObjectOutputStream oout = new ObjectOutputStream(fout);
//            oout.writeObject(manager);
//            oout.close();
//            fout.close();

//            {
//                FileInputStream fin = new FileInputStream("java_binary_file_with_employees.ser");
//                ObjectInputStream oi = new ObjectInputStream(fin);
//
//                Employee rmanager = (Manager) oi.readObject();
//                Employee roperator = (Operator) oi.readObject();
//                oi.close();
//                fin.close();
//
//
//                System.out.println(rmanager.toString());
//                System.out.println(roperator.toString());

            //service.serializeEmployee(fileName, manager);
            Employee employee =  service.deSerializeEmployee(fileName);
            System.out.println(employee);




        } catch (FileNotFoundException e){
            System.out.println("File was not found: " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        } catch (IOException e){
            System.out.println("File error: " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println("Caught other exception: " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

    }
}
