/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSelenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.security.auth.login.Configuration;
import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author seryozha
 */
public class searchName {

    WebDriver firefoxDriver = new FirefoxDriver();
    //WebDriver chromeDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(firefoxDriver, 60);
    //private Object logger;

    @Given("^Open \"(.*?)\" web page$")
    public void openMyPage(String url) {
        firefoxDriver.get(url);

    }

    @Then("^Search \"(.*?)\" from a web page with \"(.*?)\" id name$")
    public void searchNameWebPAge(String names, String id) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        WebElement searchBox = firefoxDriver.findElement(By.id(id));
        //WebElement inputElement = firefoxDriver.findElement(By.id("nav-search-input"));
        Thread.sleep(20000);
        searchBox.sendKeys(names);
        searchBox.submit();
        Thread.sleep(20000);
        firefoxDriver.close();
    }

}
