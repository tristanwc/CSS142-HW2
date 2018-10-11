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

        double totalWithTax = applyTax(totalWithDiscount, tax);
        System.out.println("The total with tax is " + totalWithTax);

        double totalWithTip = computeAndApplyTip(input, totalWithTax);
        System.out.println("The total with tip is " + totalWithTip);

        double share = Math.round((totalWithTip / 4.0) * 100.0) / 100.0;
        System.out.println("Everyone's share is " + share);
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

        int val = (int) phrase.charAt(0);//Gets 1st Character ASCII Value
        val += (int) phrase.charAt(1);   //Gets 2nd Character ASCII Value
        val += (int) phrase.charAt(2);   //Gets 3rd Character ASCII Value
        val += (int) phrase.charAt(3);   //Gets 4th Character ASCII Value
        val += (int) phrase.charAt(4);   //Gets 5th Character ASCII Value
        val += (int) phrase.charAt(5);   //Gets 6th Character ASCII Value
        discount = Math.round(val / 6.0); //Divides by average and rounds to nearest whole number
        discount = (discount % 10) / 100;
        return discount;
    }

    public static double applyDiscount(double total, double percentage) {
        total = total * (1 - percentage); //Returns total by discount multiplier
        return Math.round(total * 100.00) / 100.00;
    }

    public static double computeTax(Scanner input) {
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
       switch (taxRate) {
           case 1: state = "AL";
           taxRate = 9.10;
           break;
           case 2: 
       }
>>>>>>> parent of d8afd38... Added a switch case. Added gitignore
    }

    public static double applyTax(double discountTotal, double tax) {
        discountTotal = discountTotal * (1.00 + (tax / 100.00)); //Calculates state tax to current amount
        return Math.round(discountTotal * 100.0) / 100.0;
    }

    public static double computeAndApplyTip(Scanner input, double totalDiscountTax) {
        System.out.println("Type 'p' to add a percentage tip or 'a' for an absolute num tip: ");
        char c = input.next().charAt(0);
        double tip;
        if (c == 'p' || c == 'P') {
            tip = computeTip(input, totalDiscountTax); //Calls overload a method
            totalDiscountTax = totalDiscountTax * (1.00 + tip);
            totalDiscountTax = Math.round(totalDiscountTax * 100.00) / 100.00; //calculates total with tip
            return totalDiscountTax;
        } else if (c == 'a' || c == 'A') {
            tip = computeTip(input); //Gets absolute tip amount
            return (totalDiscountTax + tip); //adds real number tip into total
        } else { //Invalid input
            System.out.println("You entered an invalid char, the tip is set to 18%");
            return 0.18;
        }
    }

    public static double computeTip(Scanner a, double currAmount) {
        System.out.println("Enter tip percentage: ");
        double val = a.nextDouble();
        if (val < 0 || val > 100) {
            val = 0.25;
            System.out.println("Invalid tip percent, it is set to 25%");
            return val;
        } else {
            val /= 100;
            val = Math.round(val * 100.00) / 100.00;
            System.out.println(val);
            return val;
        }

    }

    public static double computeTip(Scanner b) {
        System.out.println("Enter tip amount (abs val): ");
        double val = b.nextDouble();
        val = Math.round(val * 100.00) / 100;
        return val;
    }
}
