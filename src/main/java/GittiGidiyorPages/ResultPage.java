package GittiGidiyorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResultPage {
    WebDriver driver;
    By pageNumber = By.xpath("//a[@title='2. sayfa']");
    By secondProduct = By.xpath("(//h2[@class='sc-1ku3a4v-0 sc-7u3xly-0 clhtrN jytHfD sc-1n49x8z-16 khXIrI'])[2]");
    String secondPageURL = "https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2";


    public  ResultPage (WebDriver driver){
        this.driver = driver;
    }
    public void scrollToPageNumbers() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(pageNumber).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(pageNumber).click();
    }

    public void checkUrlAccuracy(){
        String getCurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(getCurrentUrl,secondPageURL);
    }

    public ProductDetailPage goToProductDetail() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(secondProduct).click();
        return new ProductDetailPage(driver);
    }
}
