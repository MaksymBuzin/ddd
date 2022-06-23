package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    //private constructor to implement Singleton Design Class
    private WebDriverManager() {

    }

    private static WebDriver driver;
    private static String sauceUser = ConfigReader.readProperty("sauce_userName");
    private static String sauceKey = ConfigReader.readProperty("sauce_key");
    private static String URL = "https://" + sauceUser + ":" + sauceKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    private static void initializeDriver(String browser){
        driver = null;

        if (ConfigReader.readProperty("runInSaucelabs").equals("true")){
            driver = getRemoteDriver();
        }else{
            switch (browser.toLowerCase()){
                case "chrome":
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("Wrong browser name was entered");
            }
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public static WebDriver getRemoteDriver(){
        WebDriver driver = null;
        try{
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("browser", ConfigReader.readProperty("browser"));
            capabilities.setCapability("version", ConfigReader.readProperty("browser_version"));
            capabilities.setCapability("platform", ConfigReader.readProperty("os"));
            driver = new RemoteWebDriver(new URL(URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver(ConfigReader.readProperty("browser"));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void click(WebElement element) {
        SeleniumUtils.moveIntoView(element);
        SeleniumUtils.highlightElement(element);
        SeleniumUtils.waitForElementClickability(element);
        element.click();
    }

    public static void click(By by) {
        SeleniumUtils.moveIntoView(getDriver().findElement(by));
        SeleniumUtils.highlightElement(getDriver().findElement(by));
        SeleniumUtils.waitForElementClickability(getDriver().findElement(by));
        getDriver().findElement(by).click();
    }

    public static String getText(WebElement element) {
        SeleniumUtils.moveIntoView(element);
        SeleniumUtils.highlightElement(element);
        SeleniumUtils.waitForElementVisibility(element);
        return element.getText();
    }

    public static String getText(By by) {
        SeleniumUtils.moveIntoView(getDriver().findElement(by));
        SeleniumUtils.highlightElement(getDriver().findElement(by));
        SeleniumUtils.waitForElementVisibility(getDriver().findElement(by));
        return getDriver().findElement(by).getText();
    }

    public static void sendKeys(WebElement element, String txt) {
        SeleniumUtils.moveIntoView(element);
        SeleniumUtils.highlightElement(element);
        SeleniumUtils.waitForElementVisibility(element);
        element.sendKeys(txt);
    }

    public static void sendKeys(By by, String txt) {
        SeleniumUtils.moveIntoView(getDriver().findElement(by));
        SeleniumUtils.highlightElement(getDriver().findElement(by));
        SeleniumUtils.waitForElementVisibility(getDriver().findElement(by));
        getDriver().findElement(by).sendKeys(txt);
    }

    public static boolean isDisplayed(WebElement element) {
        SeleniumUtils.moveIntoView(element);
        SeleniumUtils.highlightElement(element);
        SeleniumUtils.waitForElementVisibility(element);
        return element.isDisplayed();
    }

    public static boolean isDisplayed(By by) {
        SeleniumUtils.moveIntoView(getDriver().findElement(by));
        SeleniumUtils.highlightElement(getDriver().findElement(by));
        SeleniumUtils.waitForElementVisibility(getDriver().findElement(by));
        return getDriver().findElement(by).isDisplayed();
    }

    public static boolean isEnabled(WebElement element) {
        SeleniumUtils.moveIntoView(element);
        SeleniumUtils.highlightElement(element);
        SeleniumUtils.waitForElementClickability(element);
        return element.isEnabled();
    }

    public static boolean isEnabled(By by) {
        SeleniumUtils.moveIntoView(getDriver().findElement(by));
        SeleniumUtils.highlightElement(getDriver().findElement(by));
        SeleniumUtils.waitForElementClickability(getDriver().findElement(by));
        return getDriver().findElement(by).isEnabled();
    }

    public static String getAtribute(By by, String attribute) {
        SeleniumUtils.moveIntoView(getDriver().findElement(by));
        SeleniumUtils.highlightElement(getDriver().findElement(by));
        SeleniumUtils.waitForElementVisibility(getDriver().findElement(by));
        return getDriver().findElement(by).getAttribute(attribute);
    }

}
