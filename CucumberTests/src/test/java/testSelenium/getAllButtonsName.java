/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSelenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author seryozha
 */
public class getAllButtonsName {
//    WebDriver driver = new FirefoxDriver();
//    WebDriverWait wait = new WebDriverWait(driver, 60);

    
    
    @Then("^Get butons name from a web page$")
    public void getButonsNameWebPage() throws InterruptedException {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
//        List<WebElement> elements = driver.findElements(By.tagName("a"));
//
//        System.out.println("List size = " + elements.size());
//
//        for (WebElement obj : elements) {
//            //System.out.println("obj -> " + obj.getText());
//            if (!obj.getText().isEmpty()) {
//                WebElement aa = driver.findElement(By.linkText(obj.getText()));
//                System.out.println("Text name " +aa);
//            }
//        }
    }
    
    
}
