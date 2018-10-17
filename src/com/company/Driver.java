package com.company;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Gets input

        //Asks user for total cost of meals
        double total = computeTotal(input);
        System.out.println("The total is cost for the 4 meals is " + total);

        //Uses a phrase key to get discount percent
        double discountPercentage = computeDiscount(input);
        System.out.println("The discount percentage is " + discountPercentage);

        //Uses the discount percent and calculates new total
        double totalWithDiscount = applyDiscount(total, discountPercentage);
        System.out.println("The total with discount is " + totalWithDiscount);

        //Computes tax percent with state abbreviation
        double tax = computeTax(input);
        System.out.println("The tax rate is " + tax);

        //Computes total with tax percent
        double totalWithTax = applyTax(totalWithDiscount, tax);
        System.out.println("The total with tax is " + totalWithTax);

        //Get's users tip type and value/percent
        double totalWithTip = computeAndApplyTip(input, totalWithTax);
        System.out.println("The total with tip is " + totalWithTip);

        //Divides final total by four
        double share = Math.round((totalWithTip / 4.0) * 100.0) / 100.0;
        System.out.println("Everyone's share is " + share);
    }

    public static double computeTotal(Scanner input) {
        double val = 0;
        double tempVal = 0;
        for (int i = 1; i <= 4; i++) {
            System.out.println("What is the cost for Meal #" + i); //Asks user to input meal cost
            tempVal = input.nextDouble();
            val = val + tempVal;
        }
        return val;
    }
    /* Computes a discount percentage using the ASCII table character value */
    public static double computeDiscount(Scanner input) {
        System.out.println("Enter the pass phrase: ");
        double discount; //Variables declared and initialized
        int val = 0;
        String phrase = input.next(); //Gets phrasekey

        //If phrase is not 6 characters exactly, returns 3%
        if (phrase.length() < 6 || phrase.length() > 6) {
            System.out.println("Passphrase is not 6 characters long. [Defaulting to 3%]");
            return 0.03;
        }
        for (int i = 0; i < 6; i++) { //Gets all indexes for Character ASCII Value
            val += (int) phrase.charAt(i);
        }
        discount = Math.round(val / 6.0); //Divides by average and rounds to nearest whole number
        discount = (discount % 10) / 100; //Formula to get discount from documentation
        return discount;
    }
    /* Applies discount from the value given in computeDiscount */
    public static double applyDiscount(double total, double percentage) {
        total = total * (1 - percentage); //Returns total by discount multiplier
        return Math.round(total * 100.00) / 100.00;
    }

    /* Get's user to input a state abbreviation and get's the state tax. If invalid, there is an error code and
       default error value and message. */
    public static double computeTax(Scanner input) {
        System.out.println("Enter state abbrv.: ");
        String state = input.next().toUpperCase(); //Changes user input to uppercase to match case
        //Any state with 0 tax rate has no sales tax, tax rate is whole number, but the calculations are the same
        switch (state) {
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
                //Conditional to print a different error is the state character length exceeds or is too small
                if (state.length() > 2 || state.length() < 2)
                    System.out.println("Invalid state code. State code should only be 2 characters long. [Defaulting to 15%]");
                else
                    System.out.println("Invalid state code. [Defaulting to 15%]");
                return 15.00;
        }
    }
    /* Applies state tax value from computeTax method with current total */
    public static double applyTax(double discountTotal, double tax) {
        //Calculates state tax to current amount
        discountTotal = discountTotal * (1.00 + (tax / 100.00));
        return Math.round(discountTotal * 100.0) / 100.0;
    }
    /* Computes a tip absolute num or percentage and calls an overload method to get a specific number */
    public static double computeAndApplyTip(Scanner input, double totalDiscountTax) {
        //Asks user to type p or a for type of tip
        System.out.println("Type 'p' or 'percentage' to add a percentage tip or 'a' or 'absolute' for an absolute num tip: ");
        //Gets type of input user specifies
        String c = input.next();
        double tip;
        //Uses equalsIgnoreCase to count for both upper/lower cases
        if (c.equalsIgnoreCase("p") || c.equalsIgnoreCase("percentage")) {
            //Calls Overload a Method
            tip = computeTip(input, totalDiscountTax);
            //Get's total by multiplying current total with a tip
            totalDiscountTax = totalDiscountTax * (1.00 + tip);
            totalDiscountTax = Math.round(totalDiscountTax * 100.00) / 100.00;
            return totalDiscountTax;
        } else if (c.equalsIgnoreCase("A") || c.equalsIgnoreCase("absolute")) {
            tip = computeTip(input); //Gets absolute tip amount
            System.out.println("The tip amount is " + tip);
            //Adds real (abs) number tip into total
            return (totalDiscountTax + tip);
        } else { //Invalid input, sets to 18%
            System.out.println("Invalid choice. Defaulting to total tip of 18%");
            System.out.println("The tip amount is " + Math.round((totalDiscountTax * 0.18) * 100.00) / 100.00);
            totalDiscountTax = totalDiscountTax * (1.00 + 0.18);
            totalDiscountTax = Math.round(totalDiscountTax * 100.00) / 100.00;
            return totalDiscountTax;

        }
    }
    /* First overloaded method that user specifies for a percentage tip */
    public static double computeTip(Scanner a, double currAmount) {
        System.out.println("Enter tip percentage: "); //Asks for a percentage
        double val = a.nextDouble();
        if (val < 0 || val > 100) { //If tip is greater than 100% or less than 0%
            val = 0.25; //Sets to 25%
            System.out.println("Invalid tip percent, it is set to 25%");
            System.out.println("The tip amount is " + (currAmount * 0.25));
            return val;
        } else {
            val /= 100;
            val = Math.round(val * 100.00) / 100.00;
            currAmount *= val;
            currAmount = Math.round(currAmount * 100.00) / 100.00;
            System.out.println("The tip amount is " + (currAmount));
            return val;
        }
    }
    /* Second overloaded method that user specifies for a absolute num. tip */
    public static double computeTip(Scanner b) {
        //Asks for real number absolute tip
        System.out.println("Enter tip amount (abs val): ");
        double val = b.nextDouble();
        //If input is less than 0 or greater than 100, defaults to $25
        if (val < 0 || val > 100) {
            System.out.println("Invalid absolute tip. Defaulting tip to $25");
            return 25; //Returns 25
        }
        val = Math.round(val * 100.00) / 100.00;
        return val;
    }
}
