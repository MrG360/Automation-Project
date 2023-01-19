package org.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("js-link-box-en")).click();

        out.println(driver.findElement(By.id("Welcome_to_Wikipedia")).getText());
        driver.quit();
    }
}