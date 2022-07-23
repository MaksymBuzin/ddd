package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CalendarPage;
import pages.CommonPage;
import pages.HomePage;
import utils.SeleniumUtils;
import utils.WebDriverManager;

import java.text.ParseException;
import java.util.Arrays;

public class CalendarSteps implements CommonPage {
    HomePage homePage;
    CalendarPage calendarPage;

    public CalendarSteps() {
        homePage = new HomePage();
        calendarPage = new CalendarPage();
    }

    @Given("User clicks on {string}")
    public void user_clicks_on_link_on_home_page(String page) {
        WebDriverManager.click(By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, page)));

    }

    @Then("Verify user sees correct date on calendar page")
    public void verifyDateOnCalendarPage() {
        Assert.assertEquals(SeleniumUtils.getTodaysDate(), WebDriverManager.getText(calendarPage.dateDisplay));

    }

    @Then("Verify drop down calendar is present")
    public void verify_drop_down_calendar_is_present() {
        Assert.assertTrue(WebDriverManager.isDisplayed(calendarPage.monthContainer));
    }

    @Then("Verify {string} button is displayed")
    public void verify_button_is_displayed(String btn) {
        Assert.assertTrue(WebDriverManager.isDisplayed(By.xpath(String.format(XPATH_TEMPLATE_BUTTON, btn))));
    }


    @When("User picks Start date and End date")
    public void userPicksStartDateAndEndDate() {
        WebDriverManager.click(calendarPage.startDate);
        WebDriverManager.click(calendarPage.nextDayStartDay);

        WebDriverManager.click(calendarPage.endDatee);
        try {
            WebDriverManager.click(calendarPage.threeDayAheadEndDate);

        } catch (Exception e) {
            WebDriverManager.click(calendarPage.nextMothBtn);
            WebDriverManager.click(calendarPage.threeDayAheadEndDate);
        }
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String btn) {
        WebDriverManager.click(By.xpath(String.format(XPATH_TEMPLATE_BUTTON, btn)));
    }

    @Then("Verify message is correct")
    public void verify_message_is() throws ParseException {
        String dates[] = calendarPage.getStartEndDates();//call method
        String expectedRes = "There are 2 days between " + dates[0] + " and " + dates[1];

        Assert.assertEquals(expectedRes, WebDriverManager.getText(calendarPage.datePcikerMessage));

    }

    @When("User clicks {string} option")
    public void userClicksOption(String btn) {
        switch (btn) {
            case "Start date:":
                WebDriverManager.click(calendarPage.startDate);
                break;
            case "End date:":
                WebDriverManager.click(calendarPage.endDatee);
                break;
            default:
                System.out.println("the button doesn't exist");

        }
    }

    @Then("Verify title of the page is {string}")
    public void verifyTitleOfThePageIs(String title) {
        Assert.assertEquals(title,WebDriverManager.getDriver().getTitle());
    }
}
