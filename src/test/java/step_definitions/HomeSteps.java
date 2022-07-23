package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.CucumberLogUtils;
import utils.SeleniumUtils;
import utils.WebDriverManager;

public class HomeSteps implements CommonPage {
    HomePage homePage;

    public HomeSteps(){
        homePage = new HomePage();
    }


    @Then("Verify {string} is displayed")
    public void verify_is_displyed(String link) {
        Assert.assertTrue(WebDriverManager.isDisplayed(By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT,link))));

    }


    @Then("Verifies title of the page is {string}")
    public void verifies_title_of_the_page_is(String title) {
        Assert.assertEquals(title, WebDriverManager.getDriver().getTitle());
    }

    @And("User switches to the next window")
    public void userSwitchesToTheNextWindow() {
        SeleniumUtils.switchToNextWindow();
    }


    @Then("Verify {string} header is displayed")
    public void verifyHeaderIsDisplayed(String header) {
        Assert.assertEquals(header, WebDriverManager.getText(By.xpath(String.format(XPATH_TEMPLATE_TEXT_H1,header))));
    }
}
