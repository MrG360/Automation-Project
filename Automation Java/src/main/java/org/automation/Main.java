package org.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;


import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.id("js-link-box-en")).click();

        String text = driver.findElement(By.id("Welcome_to_Wikipedia")).getText();

        new LogRecord(Level.INFO, "title: " + driver.getTitle());
        if(text.equalsIgnoreCase("Welcome to Wikipedia")) {
            new LogRecord(Level.INFO, "Click operation has passed");
        } else {
            driver.close();
        }

        if(driver.getTitle().equals("Wikipedia, the free encyclopedia")) {
            new LogRecord(Level.INFO, "Reached English wikipedia page");
        } else {
            driver.close();
            throw new Exception("Not passed");
        }

        driver.findElement(By.cssSelector("input[placeholder=\"Search Wikipedia\"]")).sendKeys("Selenium Webdriver");
        driver.findElement(By.cssSelector("#searchform .cdx-button")).click();

        new LogRecord(Level.INFO, driver.getTitle());



        // print all headers
        List<WebElement> lst = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[2]/ul/li/table/tbody/tr[1]/td[2]/div[1]"));

        for(WebElement x : lst) {
            out.println("Header of searched title: " + x.getText());
        }
        driver.quit();

    }
}