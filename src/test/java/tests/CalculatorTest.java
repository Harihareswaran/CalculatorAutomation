package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class CalculatorTest extends BaseTest {

    /**
     * Test addition: 5 + 3 = 8
     */
    @Test
    public void additionTest() {
        CalculatorPage calc = new CalculatorPage(driver);

        // Enter first number
        calc.enterNumber("5");
        // Click addition
        calc.clickAdd();
        // Enter second number
        calc.enterNumber("3");
        // Click equal to get result
        calc.clickEqual();

        // Verify result is 8
        Assert.assertEquals(calc.getResult(), "8", "Addition result is incorrect");
    }

    /**
     * Test subtraction: 9 - 4 = 5
     */
    @Test
    public void subtractionTest() {
        CalculatorPage calc = new CalculatorPage(driver);

        calc.enterNumber("9");
        calc.clickSub();
        calc.enterNumber("4");
        calc.clickEqual();

        Assert.assertEquals(calc.getResult(), "5", "Subtraction result is incorrect");
    }

    /**
     * Test multiplication: 6 * 2 = 12
     */
    @Test
    public void multiplicationTest() {
        CalculatorPage calc = new CalculatorPage(driver);

        calc.enterNumber("6");
        calc.clickMul();
        calc.enterNumber("2");
        calc.clickEqual();

        Assert.assertEquals(calc.getResult(), "12", "Multiplication result is incorrect");
    }

    /**
     * Test division: 8 / 2 = 4
     */
    @Test
    public void divisionTest() {
        CalculatorPage calc = new CalculatorPage(driver);

        calc.enterNumber("8");
        calc.clickDiv();
        calc.enterNumber("2");
        calc.clickEqual();

        Assert.assertEquals(calc.getResult(), "4", "Division result is incorrect");
    }

    /**
     * Test clear functionality
     */
    @Test
    public void clearTest() {
        CalculatorPage calc = new CalculatorPage(driver);

        calc.enterNumber("7");
        calc.clickAdd();
        calc.enterNumber("2");
        calc.clickEqual();

        // Click clear to reset calculator
        calc.clickClear();

        // Verify result is 0 after clear
        Assert.assertEquals(calc.getResult(), "0", "Clear functionality failed");
    }
}