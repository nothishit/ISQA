package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModPage extends BasePage {
  public ModPage(WebDriver driver){
    super(driver);
  }

  public void showRequirements() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement reqButton = wait.until(ExpectedConditions.elementToBeClickable(
      By.cssSelector("dt.clearfix[data-tracking*='Mod Page'][data-tracking*='View Requirements']")
    ));
    reqButton.click();
  }

  public String downloadMod() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement filesButton = wait.until(ExpectedConditions.elementToBeClickable(
      By.xpath("//span[text()='Files']")
    ));
    filesButton.click();
    WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[text()='Manual download']")
    ));
    downloadButton.click();
    WebElement downloadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//th[text()='Choose download type']")
    ));
    return downloadElement.getText();
  }

  public void showImages() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // 1. Клик по кнопке "Images"
    WebElement imagesButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("li#mod-page-tab-images"))
    );
    imagesButton.click();

    // 2. Клик по первой картинке (с явным ожиданием загрузки)
    List<WebElement> images = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        By.cssSelector("li.image-tile")
    ));
    if (!images.isEmpty()) {
        images.get(0).click();
    } else {
        throw new RuntimeException("Не найдено ни одного изображения");
    }

    // 3. Получение общего количества изображений
    WebElement counter = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("span#lg-counter-all")
    ));
    int countImages = Integer.parseInt(counter.getText().trim());

    // 4. Перебор всех изображений
    for (int i = 0; i < countImages - 1; i++) {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button.lg-next")
        ));
        nextButton.click();
        
        // Ожидание между переключениями (лучше использовать ExpectedConditions)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.cssSelector(".lg-loading")
        ));
    }
  }
}