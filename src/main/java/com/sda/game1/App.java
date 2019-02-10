package com.sda.game1;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        Number number = new Number();
        Scanner sc = new Scanner(System.in);

        //get the wildNum
        int wildNum = number.randomIntWithRange(0, 100);
        //user input number
        int userNum = -1;
        //number of tries
        int numOfTry = 0;

        out.println("Give me a number in range of 0-100");
        //while userNum is not a wildNum...
        while (userNum != wildNum) {
            //...ask for another number
            String userInput = sc.nextLine();
            //if userNum is not a valid integer, ask for different input
            if (!number.isInteger(userInput)) {
                out.println("This is not a correct number in range 0-100. Please try again.");
            } else {
                //otherwise assign to userNum
                userNum = Integer.parseInt(userInput);
                //if userNum is less than wildNum
                if (userNum < wildNum) {
                    out.println("Input number is less than WildNumber");
                    //if userNum is more than wildNum
                } else if (userNum > wildNum) {
                    out.println("Input number is more than WildNumber");
                }
            }
            //increment number numOfTry each time loop is executed
            numOfTry++;
        }
        //close the scanner
        sc.close();
        //final output
        out.println("Congratulations! You've tried " + numOfTry + " time(s)");
    }
}
