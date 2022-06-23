package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class SeleniumUtils {

    public static void sleep(Long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void moveIntoView(WebElement element) {
        ((JavascriptExecutor) WebDriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();

        for (int i = 0; i < 4; i++) {
            try {
                if (i % 2 == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                } else {
                    sleep(500L);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Method will switch to the next window
     * NOTE: Method works only with 2 windows at a time
     */
    public static void switchToNextWindow() {
        String currentWindowID = WebDriverManager.getDriver().getWindowHandle();
        Set<String> allWindowIDs = WebDriverManager.getDriver().getWindowHandles();

        for (String each : allWindowIDs) {
            if (!each.equals(currentWindowID))
                WebDriverManager.getDriver().switchTo().window(each);
        }
    }

    public static String getTodaysDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
        Date date = new Date();
        return formatter.format(date);

    }
}
