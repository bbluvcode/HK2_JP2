/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import data.*;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Demo test = new Demo();
        test.menu();

    }

    Locale locale;
    NumberFormat Formatter;
    String strFormated;

    double percent = 25.0 / 100.0;
    float number = 1000000;

    void NumFormat(Locale locale) {

        System.out.println("--- Chưa định dạng:");
        System.out.println("Percent: " + percent);
        System.out.println("Number: " + number);

        System.out.println("--- Sau khi định dạng");

        Formatter = NumberFormat.getPercentInstance(locale);//
        strFormated = Formatter.format(percent);
        System.out.println("Percent: " + strFormated);

        Formatter = NumberFormat.getInstance(locale);
        strFormated = Formatter.format(number);
        System.out.println("Number: " + strFormated);

        Formatter = NumberFormat.getCurrencyInstance(locale);
        strFormated = Formatter.format(number);
        System.out.println("Number: " + strFormated);
    }

    void NumberFormatDefault() {
        System.out.println("--- Chưa định dạng:");
        System.out.println("Percent: " + percent);
        System.out.println("Number: " + number);

        System.out.println("--- Sau khi định dạng");
        Formatter = NumberFormat.getPercentInstance();//
        strFormated = Formatter.format(percent);
        System.out.println("Percent: " + strFormated);

        Formatter = NumberFormat.getInstance();
        strFormated = Formatter.format(number);
        System.out.println("Number: " + strFormated);

        Formatter = NumberFormat.getCurrencyInstance();
        strFormated = Formatter.format(number);
        System.out.println("Number: " + strFormated);
    }

    void menuNumber() {
        Scanner sc = new Scanner(System.in);

        int choice = 1998;
        do {
            System.out.println("\n===================================");
            System.out.println("***--Chọn ngôn ngữ--***");
            System.out.println("1. Mặc định");
            System.out.println("2. English");
            System.out.println("3. Việt Nam");
            System.out.println("4. Chinese");
            System.out.println("0. Return");
            System.out.println("------------------");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Mặc định");
                    NumberFormatDefault();
                    break;
                case 2:
                    System.out.println("2. English");
                    locale = new Locale("en", "US");
                    NumFormat(locale);

                    break;
                case 3:
                    System.out.println("3. Việt Nam");
                    locale = new Locale("vn", "VN");
                    NumFormat(locale);

                    break;
                case 4:
                    System.out.println("4. Chinese");
                    locale = new Locale("zh", "CN");
                    NumFormat(locale);
                    break;
                case 0:
                    System.out.println("--Thoát chương trình");
                    break;
                default:
                    System.out.println("Chọn sai. Hãy thử lại!");
                    break;
            }

        } while (choice != 0);
    }

    ResourceBundle messages, numbers, dates;
    String todayPattern, formattedToday, formattedMessage;

    void resrcBun(Locale locale, String patternDate) {
        // Tải bundle nguồn phù hợp
        messages = ResourceBundle.getBundle("resources.messages", locale);
        numbers = ResourceBundle.getBundle("resources.messages", locale);
        dates = ResourceBundle.getBundle("resources.messages", locale);

        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("farewell"));
        System.out.println(numbers.getString("one"));
        System.out.println(numbers.getString("two"));
        System.out.println(numbers.getString("three"));

        todayPattern = dates.getString("today");
        formattedToday = LocalDate.now().format(DateTimeFormatter.ofPattern(patternDate));
        formattedMessage = MessageFormat.format(dates.getString("today"), formattedToday);
        System.out.println(formattedMessage);
    }

    void resrcBunDefault() {
        messages = ResourceBundle.getBundle("resources.messages", locale);
        numbers = ResourceBundle.getBundle("resources.messages", locale);
        dates = ResourceBundle.getBundle("resources.messages", locale);
        // In ra các chuỗi bằng ngôn ngữ và định dạng mặc định của máy
        System.out.println("\n-----Default");
        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("farewell"));

        System.out.println(numbers.getString("one"));
        System.out.println(numbers.getString("two"));
        System.out.println(numbers.getString("three"));

        // In ra ngày hôm nay
        // Lấy ngày hiện tại theo định dạng của Locale mặc định
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());
        formattedToday = LocalDate.now().format(dateFormatter);

        // Sử dụng ngày định dạng để tạo chuỗi thông điệp
        formattedMessage = MessageFormat.format(dates.getString("today"), formattedToday);
        System.out.println(formattedMessage);
    }

    void menuResourceBundleDemo() {

        Scanner sc = new Scanner(System.in);

        int choice = 1998;
        do {
            System.out.println("\n===================================");
            System.out.println("***--Chọn ngôn ngữ--***");
            System.out.println("1. Mặc định");
            System.out.println("2. English");
            System.out.println("3. Việt Nam");
            System.out.println("4. Chinese");
            System.out.println("0. Return");
            System.out.println("------------------");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Mặc định");
                    locale = Locale.getDefault();
                    resrcBunDefault();
                    break;
                case 2:
                    System.out.println("2. English");
                    locale = new Locale("en", "US");
                    resrcBun(locale, "MM-dd-yyyy");

                    break;
                case 3:
                    System.out.println("3. Việt Nam");
                    locale = new Locale("vi", "VN");
                    resrcBun(locale, "dd/MM/yyyy");

                    break;
                case 4:
                    System.out.println("4. Chinese");
                    locale = new Locale("zh", "CN");
                    resrcBun(locale, "yyyy年MM月dd日");
                    break;
                case 0:
                    System.out.println("--Thoát chương trình");
                    break;
                default:
                    System.out.println("Chọn sai. Hãy thử lại!");
                    break;
            }

        } while (choice != 0);

    }

    void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 1998;
        do {
            System.out.println("-------------MENU-----------");
            System.out.println("1. ResourceBundle");
            System.out.println("2. NumberFormat");
            System.out.println("0. Exit");
            System.out.println("------------------");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. ResourceBundle Demo");
                    menuResourceBundleDemo();
                    break;
                case 2:
                    System.out.println("2. NumberFormat Demo");
                    menuNumber();
                    break;
                case 0:
                    System.out.println("--Thoát chương trình");
                    break;
                default:
                    System.out.println("Chọn sai. Hãy thử lại!");
                    break;
            }
        } while (choice != 0);
    }
}
