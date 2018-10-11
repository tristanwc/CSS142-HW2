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
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("Enter state abbrv.: ");
        String state = input.next().toUpperCase(); //Changes user input to uppercase to match case
        double taxRate = 15.0;
        switch (state) {    //Any state with 0 tax rate has no sales tax
            case "AL":
                return 9.10;
            case "AK":
                return 1.76;
            case "AZ":
                return 8.33;
            case "AR":
                return 9.41;
            case "CA":       //5th state
                return 8.54;
            case "CO":
                return 7.52;
            case "CT":
                return 6.35;
            case "DE":
                return 0.00;
            case "DC":
                return 5.75;
            case "FL":       //10th state
                return 6.80;
            case "GA":
                return 7.15;
            case "HI":
                return 4.35;
            case "ID":
                return 6.03;
            case "IL":
                return 8.70;
            case "IN":       //15th state
                return 7.00;
            case "IA":
                return 6.80;
            case "KS":
                return 8.68;
            case "KY":
                return 6.00;
            case "LA":
                return 10.02;
            case "ME":       //20th state
                return 5.50;
            case "MD":
                return 6.00;
            case "MA":
                return 6.25;
            case "MI":
                return 6.00;
            case "MN":
                return 7.42;
            case "MS":       //25th state
                return 7.07;
            case "MO":
                return 8.03;
            case "MT":
                return 0.00;
            case "NE":
                return 6.89;
            case "NV":
                return 8.14;
            case "NH":       //30th state
                return 0.00;
            case "NJ":
                return 6.60;
            case "NM":
                return 7.66;
            case "NY":
                return 8.49;
            case "NC":
                return 6.95;
            case "ND":       //35th state
                return 6.80;
            case "OH":
                return 7.15;
            case "OK":
                return 8.91;
            case "OR":
                return 0.00;
            case "PA":
                return 6.34;
            case "RI":       //40th state
                return 7.00;
            case "SC":
                return 7.37;
            case "SD":
                return 6.40;
            case "TN":
                return 9.46;
            case "TX":
                return 8.17;
            case "UT":       //45th state
                return 6.77;
            case "VT":
                return 6.18;
            case "WA":
                return 9.18;
            case "WV":
                return 6.37;
            case "WI":
                return 5.42;
            case "WY":       //50th state
                return 5.46;
            default:
                System.out.println("You entered an invalid state.");
                return 15.00;
        }
=======
       String state = input.next();
       double taxRate = 15;
=======
       String state = input.next();
       double taxRate = 15.0;
>>>>>>> parent of 524b7c8... Finished [Check it]
       switch (taxRate) {
           case 1: state = "AL";
           taxRate = 9.10;
           break;
<<<<<<< HEAD
           case 2: 
       }
>>>>>>> parent of d8afd38... Added a switch case. Added gitignore
=======
           case 2: state = "AK";
           taxRate = 1.76;
       }
>>>>>>> parent of 524b7c8... Finished [Check it]
    }

}
