package com.prototest.appdriver.tests;

import com.prototest.appdriver.BrowserManager;
import com.prototest.appdriver.WebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Brian on 7/16/2014.
 */
public class BrowserTests {

    @Test
    public void TestFirefox(){
        WebDriver driver = new BrowserManager().launchBrowser(BrowserManager.Browser.Firefox);
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.quit();

    }

    @Test
    public void TestIE() throws InterruptedException {
        WebDriver driver = new BrowserManager().launchBrowser(BrowserManager.Browser.IE);
        driver.navigate().to("http://www.google.com");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.quit();

    }

    @Test
    public void TestChrome(){
        WebDriver driver = new BrowserManager().launchBrowser(BrowserManager.Browser.Chrome);
        driver.navigate().to("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.quit();

    }
}
