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

public class Main {
    public static void main(String[] args){
        System.out.println("=======================================");
        System.out.println("PROJECT FROM COURSE CITB408 - \"PRESS\"");
        System.out.println("=======================================\n\n\n\n\n\n");
        System.out.println("Teodor.myCITBProject.Main");

        Newspaper newspaper = new Newspaper("Telegraf", 12, PaperSize.A3, PaperType.NEWSPAPER, false);
        System.out.println(newspaper);
        System.out.println(newspaper.getPaperPrice());
        System.out.println(newspaper.getPaperType().getBasePrice());

        Book book = new Book("Pod igoto", 500, PaperSize.A5, PaperType.STANDARD, true);
        System.out.println(book);
        System.out.println(book.getPaperPrice());


        try{

        }catch (Exception e){

            System.out.println("Found exception: " + e.getLocalizedMessage());
        }

    }
}
