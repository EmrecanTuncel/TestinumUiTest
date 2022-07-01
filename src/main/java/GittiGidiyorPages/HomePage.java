package GittiGidiyorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    By searchBox = By.xpath("//div[@class='sc-1yew439-3 bxSoKG']");
    By searchBoxInputArea = By.xpath("//input[@type='text']");

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage searchItem() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(searchBox).click();
        Thread.sleep(2000);
        driver.findElement(searchBoxInputArea).sendKeys("bilgisayar", Keys.ENTER);
        return new ResultPage(driver);
    }
}
