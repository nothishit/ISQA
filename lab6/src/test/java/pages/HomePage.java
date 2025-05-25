package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver){
    super(driver);
  }

  public String getTitleText() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.titleIs("Nexus Mods"));
    return driver.getTitle();
  }

  public String findMod(String modName) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // 1. Клик по кнопке поиска (с явным ожиданием)
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
      By.xpath("//span[text()='Search']")
    ));
    searchButton.click();

    // 2. Ввод текста в поле поиска
    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("input")
    ));
    searchInput.clear(); // Очистка поля перед вводом
    searchInput.sendKeys(modName);
    searchInput.sendKeys(Keys.ENTER);

    // 3. Ожидание результатов поиска
    WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//span[starts-with(text(), 'Search results for')]")
    ));
    
    return searchResults.getText();
  }
}