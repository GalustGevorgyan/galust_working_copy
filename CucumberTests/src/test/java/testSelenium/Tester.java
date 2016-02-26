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
import java.util.concurrent.TimeUnit;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
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
public class Tester {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    @Given("^Open \"https://www.facebook.com/\" page$")
    public void openPage() {
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^Login into the account$")
    public void loginTheAccount() {
        WebElement id = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        id.sendKeys("79166490410");
        pass.sendKeys("17fev2008");
        WebElement login = driver.findElement(By.id("loginbutton"));
        login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("^Click find freands button$")
    public void clickFindFreandButon() {
        //driver.findElement(By.id("findFriendsNav")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("findFriendsNav"))).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.findElement(By.id("userNavigationLabel")).click();
    }

    @Then("^Logut from the account$")
    public void logutAcaunt() {
        //driver.findElement(By.id("userNavigationLabel")).click();   
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavigationLabel"))).click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[12]/a/span/span"))).click();
        //driver.findElement(By.xpath("//li[12]/a/span/span")).click();
        driver.close();

    }

}
