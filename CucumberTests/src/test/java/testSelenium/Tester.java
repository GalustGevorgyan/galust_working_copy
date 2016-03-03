package testSelenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.linkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author seryozha
 */
public class Tester {

//    WebDriver driver = new FirefoxDriver();
//    WebDriverWait wait = new WebDriverWait(driver, 60);

    @Given("^Open \".*http://.*\" page$")
    public void openPage() {
       // driver.get("http://www.starwars.com/");
    }

    @When("^Login into the account$")
    public void loginTheAccount() {
//        WebElement id = driver.findElement(By.id("email"));
//        WebElement pass = driver.findElement(By.id("pass"));
//        id.sendKeys("79166490410");
//        pass.sendKeys("17fev2008");
//        WebElement login = driver.findElement(By.id("loginbutton"));
//        login.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("^Click \"(.*?)\" in web page$")
    public void clickAllButtons(String button) throws InterruptedException {
//        WebElement clickButon = driver.findElement(By.linkText(button));
//        if (clickButon.isEnabled()) {
//            clickButon.click();
//        }
//        Thread.sleep(20000);

    }

    @Then("^Close the web page after the click$")
    public void closeWebPageAfterClick() {
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       // driver.close();

    }
}
