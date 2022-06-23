package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.CucumberLogUtils;
import utils.WebDriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        WebDriverManager.getDriver().get(ConfigReader.readProperty("url"));
        CucumberLogUtils.initScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            CucumberLogUtils.logFail(scenario.getName(), true);
        }
        WebDriverManager.quitDriver();
    }

}
