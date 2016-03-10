/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSelenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.security.auth.login.Configuration;
import net.lightbody.bmp.core.har.Har;
import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.java_bandwidthlimiter.BandwidthLimiter;
import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author seryozha
 */
public class BIWebSiteTestEngine {

    private static ProxyServer server = null;
    private WebDriver firefoxDriver = null; //new FirefoxDriver();

    public BIWebSiteTestEngine() {
        int port = 0;
        firefoxServer();
        try {
            ServerSocket socket = new ServerSocket(0);
            port = socket.getLocalPort();
            socket.close();
            server = new ProxyServer(port);
            server.start();
            server.getStreamManager().setMaxBitsPerSecondThreshold(
                    200 * BandwidthLimiter.OneMbps);
            org.openqa.selenium.Proxy proxy = server.seleniumProxy();
            DesiredCapabilities capabilities = new DesiredCapabilities();//.firefox();
            capabilities.setCapability(CapabilityType.PROXY, proxy);
            firefoxDriver = new FirefoxDriver(capabilities);
        } catch (IOException e) {
            System.out.println("Can not bind socket using " + port + " port.");
        } catch (WebDriverException e) {
            System.out.println("Can not create Firefox driver with proxy server.");
        } catch (Exception e) {
            System.out.println("Something went wrong during creating Firefox driver "
                    + "(with proxy server): " + e.toString());
        }
    }

    @Given("^Open \"(.*?)\" web page$")
    public void openMyPage(String url) {
        Har har = server.newHar(url);
        firefoxDriver.get(url);
        firefoxDriver.manage().window().maximize();
    }

    @Then("^Search \"(.*?)\" from a web page with \"(.*?)\" id name$")
    public void searchNameWebPAge(String names, String id) throws InterruptedException {
        WebElement searchBox = firefoxDriver.findElement(By.id(id));
        Thread.sleep(20000);
        searchBox.sendKeys(names);
        searchBox.submit();
        Thread.sleep(20000);
        firefoxDriver.close();
    }

    @Then("^Get har and check CTO events with \"(.*?)\" page$")
    public void getHar(String url) {

        Har har_1  = server.getHar();
    }

    private void firefoxServer() {
        File firefoxServer = new File("etc/browsers/LinuxFirefox/firefox");
        if (!firefoxServer.exists() || firefoxServer.isDirectory()) {
            System.out.println("Can not find Firefox driver on "
                    + "etc/browsers/LinuxFirefox path.");
        }
        System.setProperty("webdriver.firefox.bin", firefoxServer.getAbsolutePath());
    }

}
