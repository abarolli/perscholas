package main;

import java.text.NumberFormat;
import utils.HomeworkAssignment;

public class Variables extends HomeworkAssignment {
    public static void main(String[] args) {

        new Variables().run();
    }

    public void run() {
        initQuestionsList(8);
        
        runAllQuestions();
    }

    public static void question1() {
        int x;
        int y;

        x = 1;
        y = 2;

        int z = x + y;
        System.out.println(z);
    }

    public static void question2() {
        double x;
        double y;

        x = 3.2;
        y = 4.1;

        double z = x + y;
        System.out.println(z);
    }

    public static void question3() {
        double x;
        int y;

        x = 1.2;
        y = 4;

        double z = x + y;
        System.out.println(z);
    }

    public static void question4() {
        int x;
        int y;

        x = 50;
        y = 20;

        float z = x / y;
        System.out.println(z);

        z = (float) x / y;
        System.out.println(z);

        System.out.println("This exercise shows us to be wary of integer division");
    }

    public static void question5() {
        double x;
        double y;

        x = 3.2;
        y = 1.3;

        double z = x / y;
        System.out.println(z);

        int a = (int) z;
        System.out.println(a);
        System.out.println("The precision was lost");
    }

    public static void question6() {
        int x, y;

        x = 5;
        y = 6;

        double q = y / x;
        System.out.println(q);

        q = (double) y / x;
        System.out.println(q);
        System.out.println("The precision was gained");
    }

    public static void question7() {
        final double PI = 3.14;
        final double radius = 5.0;

        final double area = PI * radius * radius;
        System.out.println(area);
    }

    public static void question8() {
        var tea = new CoffeeShopItem("tea", 2.34);
        var coffee = new CoffeeShopItem("coffee", 5.21);
        var muffin = new CoffeeShopItem("muffin", 3.81);

        final double SALES_TAX = 0.09;

        var order = new CoffeeShopOrder(SALES_TAX, tea, coffee, muffin);

        order.printTotalSale();
    }
}

class CoffeeShopItem {

    private String name;
    private double price;

    public CoffeeShopItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class CoffeeShopOrder {

    private CoffeeShopItem[] items;
    private double salesTax;

    public CoffeeShopOrder(double salesTax, CoffeeShopItem ...items) {
        this.salesTax = salesTax;
        this.items = items;
    }

    public void printTotalSale() {

        double totalSale = 0.0;
        for (int i = 0; i < items.length; ++i) {
            totalSale += items[i].getPrice();
        }

        totalSale *= (1 + salesTax);

        String result = NumberFormat.getCurrencyInstance().format(totalSale);

        System.out.println("Total Sale: " + result);
    }
}