package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By loginInput = By.name("user[login]");
    private By passwordInput = By.name("user[password]");
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public List<String> enterLogin(String login, String password) {
        List<String> result = new ArrayList<>();
        WebElement loginElement = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(loginInput));
        WebElement passwordElement = driver.findElement(passwordInput);
        loginElement.sendKeys(login);
        passwordElement.sendKeys(password);
        
        result.add(loginElement.getAttribute("value"));
        result.add(passwordElement.getAttribute("value"));

        return result;
    }
}