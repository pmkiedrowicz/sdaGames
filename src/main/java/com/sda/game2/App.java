package com.sda.game2;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        Number number = new Number();
        Scanner sc = new Scanner(System.in);
        //userInput to store user value
        String userInput;
        //userNum to store user number, after validation
        int userNum = -1;
        //wild num1
        int num1;
        //wild num2
        int num2;
        //table to store answer time
        Long[] tableOfTime = new Long[5];

        //5 rounds of game
        for (int i = 0; i < 5; i++) {
            //randomize two numbers
            num1 = number.randomIntWithRange(0, 50);
            num2 = number.randomIntWithRange(0, 50);
            //ask a user for sum
            out.println("Round " + (i + 1) + ". Add two numbers: " + num1 + " + " + num2);
            //get the start time of round
            Long startTime = System.currentTimeMillis();
            //get the userInput
            userInput = sc.nextLine();
            //while userNum is not a sum of wilds
            while (userNum != num1 + num2) {
                //if userInput is not a vali umber, ask for valid one
                if (number.isInteger(userInput) == false) {
                    out.println("This is not a valid number. Please try again.");
                    userInput = sc.nextLine();
                    //otherwise parse the number to Integer value
                } else {
                    userNum = Integer.parseInt(userInput);
                    //if the userNum is a sum of two numbers
                    if (userNum == num1 + num2) {
                        //substract time of start of round and answer time
                        tableOfTime[i] = System.currentTimeMillis() - startTime;
                    } else {
                        //otherwise ask for different sum
                        out.println("This is not a correct sum.");
                        userInput = sc.nextLine();
                    }
                }
            }
            //reset userNum value for another round
            userNum = -1;
        }
        //close scanner
        sc.close();

        int i = 1;
        //iterate through elements to show answer time
        for (Long time : tableOfTime) {
            out.println("Round " + i + " time: " + time / 1000d + "s");
            i++;
        }
    }
}