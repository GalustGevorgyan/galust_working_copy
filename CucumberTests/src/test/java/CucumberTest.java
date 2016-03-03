/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//features="src/test/resources/com/di/bi/maymekh/fill",
@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
    //features = "com/di/bi/maymekh/content_and_structure",
    //tags = { "@hadoop", "@structure" },
    plugin = {
        "json:target_json/cucumber.json",
        "pretty"
    }
)

public class CucumberTest {
    WebDriver driver = new FirefoxDriver();

    @AfterClass
    public static void tearDown() {
    }
}
