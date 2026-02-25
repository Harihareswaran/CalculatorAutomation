package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    private AndroidDriver driver; // Appium Android driver
    private WebDriverWait wait;   // Explicit wait for elements

    // Constructor
    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds for elements
    }

    // Method to get locator for a digit button on Samsung calculator
    private By digit(String number) {
        switch(number) {
            case "0": return By.id("com.sec.android.app.popupcalculator:id/bt_00");
            case "1": return By.id("com.sec.android.app.popupcalculator:id/bt_01");
            case "2": return By.id("com.sec.android.app.popupcalculator:id/bt_02");
            case "3": return By.id("com.sec.android.app.popupcalculator:id/bt_03");
            case "4": return By.id("com.sec.android.app.popupcalculator:id/bt_04");
            case "5": return By.id("com.sec.android.app.popupcalculator:id/bt_05");
            case "6": return By.id("com.sec.android.app.popupcalculator:id/bt_06");
            case "7": return By.id("com.sec.android.app.popupcalculator:id/bt_07");
            case "8": return By.id("com.sec.android.app.popupcalculator:id/bt_08");
            case "9": return By.id("com.sec.android.app.popupcalculator:id/bt_09");
            default: throw new IllegalArgumentException("Invalid digit: " + number);
        }
    }

    // Operation buttons
    private By add = By.id("com.sec.android.app.popupcalculator:id/bt_add");
    private By sub = By.id("com.sec.android.app.popupcalculator:id/bt_sub");
    private By mul = By.id("com.sec.android.app.popupcalculator:id/bt_mul");
    private By div = By.id("com.sec.android.app.popupcalculator:id/bt_div");
    private By equal = By.id("com.sec.android.app.popupcalculator:id/bt_equal");
    private By clear = By.id("com.sec.android.app.popupcalculator:id/bt_clear");

    // Result display
    private By result = By.id("com.sec.android.app.popupcalculator:id/txtCalc_RealTimeResult");

    // Enter a number (supports multi-digit numbers)
    public void enterNumber(String num) {
        for (char c : num.toCharArray()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(digit(String.valueOf(c)))); // wait for button visible
            driver.findElement(digit(String.valueOf(c))).click(); // click digit
        }
    }

    // Click addition button
    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(add));
        driver.findElement(add).click();
    }

    // Click subtraction button
    public void clickSub() {
        wait.until(ExpectedConditions.elementToBeClickable(sub));
        driver.findElement(sub).click();
    }

    // Click multiplication button
    public void clickMul() {
        wait.until(ExpectedConditions.elementToBeClickable(mul));
        driver.findElement(mul).click();
    }

    // Click division button
    public void clickDiv() {
        wait.until(ExpectedConditions.elementToBeClickable(div));
        driver.findElement(div).click();
    }

    // Click equal button
    public void clickEqual() {
        wait.until(ExpectedConditions.elementToBeClickable(equal));
        driver.findElement(equal).click();
    }

    // Click clear button
    public void clickClear() {
        wait.until(ExpectedConditions.elementToBeClickable(clear));
        driver.findElement(clear).click();
    }

    // Get result from calculator
    public String getResult() {
        // Wait for result element to be visible
        MobileElement resultElement = (MobileElement) wait.until(
                ExpectedConditions.visibilityOf(driver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc"))
        );
        // Get text and trim spaces
        String text = resultElement.getText().trim();
        // If empty (like after pressing Clear), return "0"
        return text.isEmpty() ? "0" : text;
    }
}