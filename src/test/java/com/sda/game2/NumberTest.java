package com.sda.game2;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {
    Number number = new Number();

    @Test
    public void randomIntWithRange() {
        //given
        int min = -50;
        int max = 50;
        int num;
        //when
        for (int i = 0; i < 1000; i++) { //1000 tries assume num is different
            num = number.randomIntWithRange(min, max);

            //then
            assertTrue("num should be less or equal max value", num <= max);
            assertTrue("num should be more or equal min value", num >= min);
        }
    }

    @Test
    public void isInteger() {
        //given
        String num1 = null;
        String num2 = "";
        String num3 = "-123";
        String num4 = "123";
        String num5 = "-2147483648";
        String num6 = "-2147483649";
        String num7 = "2147483647";
        String num8 = "2147483648";
        //when

        //then
        assertFalse(number.isInteger(num1));
        assertFalse(number.isInteger(num2));
        assertTrue(number.isInteger(num3));
        assertTrue(number.isInteger(num4));
        assertTrue(number.isInteger(num5));
        assertFalse("Value is one less Integer minimum value", number.isInteger(num6));
        assertTrue(number.isInteger(num7));
        assertFalse("Value is one over Integer maximum value", number.isInteger(num8));
    }
}