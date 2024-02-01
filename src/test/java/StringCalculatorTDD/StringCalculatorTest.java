package test.java.StringCalculatorTDD;

 import org.junit.Test;

import main.java.StringCalculatorTDD.StringCalculator;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void testAddEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAddSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testAddUnknownAmountOfNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    public void testAddWithNewLines() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testAddWithCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNegativeNumber() {
        StringCalculator calculator = new StringCalculator();
        calculator.add("1,-2,3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithMultipleNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        calculator.add("1,-2,-3");
    }
}
