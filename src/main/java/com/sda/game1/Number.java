package com.sda.game1;

public class Number {
    //basic randomizer with range(min, max) ability
    public int randomIntWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) ((Math.random() * range) + min);
    }

    //basic validator for Integer
    public boolean isInteger(String temp) {
        if (temp == null) {
            return false;
        }
        try {
            //Determine if given number is an Integer. If not return false.
            Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
