package com.lab5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TASK 2 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vital\\Desktop\\okis lab 5\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\vital\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.nexusmods.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("header.bg-surface-base")
        ));
        
        List<WebElement> navItems = driver.findElements(
            By.cssSelector("div.bg-surface-base span")
        );
        
        System.out.println("=== Основные разделы ===");
        for (WebElement item : navItems) {
            System.out.println(item.getText());
        }
        
        driver.quit();

        // TASK 2
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\vital\\Desktop\\okis lab 5\\chromedriver-win64\\chromedriver.exe");

        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("C:\\Users\\vital\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        
        // WebDriver driver = new ChromeDriver(options);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // driver.get("https://stackoverflow.com/questions");

        // wait.until(ExpectedConditions.visibilityOfElementLocated(
        //     By.cssSelector("div#questions")
        // ));
        
        // List<WebElement> firstPageQuestions = driver.findElements(
        //     By.cssSelector("h3.s-post-summary--content-title a")
        // );
        
        // System.out.println("=== Вопросы на первой странице ===");
        // for (WebElement title : firstPageQuestions) {
        //     System.out.println(title.getText() + "\n");
        // }
        
        // driver.quit();

        // TASK 1
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\vital\\Desktop\\okis lab 5\\chromedriver\\chromedriver.exe");

        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("C:\\Users\\vital\\Desktop\\okis lab 5\\chrome-win64\\chrome.exe");
        
        // WebDriver driver = new ChromeDriver();
        
        // driver.get("https://testng.org/");
        
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.titleContains("TestNG"));
        
        // System.out.println("Заголовок: " + driver.getTitle());
        
        
        // List<WebElement> allTocItems = driver.findElements(
        //     By.cssSelector("div#toc li a")  // Ищем все <a> внутри <li>
        // );

        // System.out.println("Содержание:");
        // for (WebElement item : allTocItems) {
        //     if (item.getText() != "")
        //     {
        //         // System.out.println(item.getText());
        //         String indent = item.findElement(By.xpath("./ancestor::ul")) != null ? "  " : "";
        //         System.out.println(indent + item.getText());
        //     }
        // }

        // WebElement cssItem = driver.findElement(
        //     By.cssSelector("div#toc a[href*='documentation']")
        // );
        // cssItem.click();

        // driver.navigate().back();

        // WebElement xpathItem = driver.findElement(
        //     By.xpath("//div[@id='toc']//a[contains(@href, 'documentation')]")
        // );
        // xpathItem.click();

        // driver.quit();


    }
}
