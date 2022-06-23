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

    @Given("User clicks on {string} link on home page")
    public void user_clicks_on_link_on_home_page(String page) {
        WebDriverManager.click(By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, page)));

    }

    @Then("Verify user sees correct date on calendar page")
    public void verifyDateOnCalendarPage() {
        Assert.assertEquals(SeleniumUtils.getTodaysDate(), WebDriverManager.getText(calendarPage.dateDisplay));

    }

    @And("User picks {string}")
    public void userPicks(String data) {
        switch (data) {
            case "Start date:":
                WebDriverManager.click(calendarPage.startDate);
                WebDriverManager.click(calendarPage.nextDayStartDay);
                break;
            case "End date:":
                WebDriverManager.click(calendarPage.endDatee);
                try {
                    WebDriverManager.click(calendarPage.threeDayAheadEndDate);
                    break;

                } catch (Exception e) {
                    WebDriverManager.click(calendarPage.nextMothBtn);
                    WebDriverManager.click(calendarPage.threeDayAheadEndDate);
                    break;
                }
        }

    }


    @When("User clicks on {string} button")
    public void user_clicks_on_button(String btn) {
        WebDriverManager.click(By.xpath(String.format(XPATH_TEMPLATE_BUTTON, btn)));
    }

    @Then("Verify message is correct")
    public void verify_message_is() throws ParseException {
        String dates[] = calendarPage.getStartEndDates();//call method
        String expectedRes = "There are 2 days between "+ dates[0] +" and " + dates[1];

        Assert.assertEquals(expectedRes,WebDriverManager.getText(calendarPage.datePcikerMessage));

    }
}
