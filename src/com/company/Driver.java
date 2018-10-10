package com.company;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = computeTotal(input);
        System.out.println("The total is cost for the 4 meals is " + total);

        double discountPercentage = computeDiscount(input);
        System.out.println("The discount percentage is " + discountPercentage);

        double totalWithDiscount = applyDiscount(total, discountPercentage);
        System.out.println("The total with discount is " + totalWithDiscount);

        double tax = computeTax(input);
        System.out.println("The tax rate is " + tax);
    }
    public static double computeTotal(Scanner input) {
        System.out.println("What is the total cost for the 4 meals?");
        double total = input.nextDouble();
        return total;
    }
    public static double computeDiscount(Scanner input) {
        System.out.println("Enter the pass phrase: ");
        double discount;
        String phrase = input.next();

        //If phrase is not 6 characters exactly, returns 3%
        if (phrase.length() < 6 || phrase.length() > 6)
            return 0.03;

        int val = (int)phrase.charAt(0);//Gets 1st Character ASCII Value
        val += (int)phrase.charAt(1);   //Gets 2nd Character ASCII Value
        val += (int)phrase.charAt(2);   //Gets 3rd Character ASCII Value
        val += (int)phrase.charAt(3);   //Gets 4th Character ASCII Value
        val += (int)phrase.charAt(4);   //Gets 5th Character ASCII Value
        val += (int)phrase.charAt(5);   //Gets 6th Character ASCII Value
        discount = Math.round(val / 6.0); //Divides by average and rounds to nearest whole number
        discount = (discount % 10) / 100;
        return discount;
    }
    public static double applyDiscount(double total, double percentage) {
        return total * (1 - percentage); //Returns total by discount multiplier
    }
    public static double computeTax(Scanner input) {
       String state = input.next();
       double taxRate = 15;
       switch (taxRate) {
           case 1: state = "AL";
           taxRate = 9.10;
           break;
           case 2: 
       }
    }

}
