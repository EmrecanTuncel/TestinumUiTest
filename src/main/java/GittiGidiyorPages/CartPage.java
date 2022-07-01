package GittiGidiyorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    WebDriver driver;
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);

    By ProductPriceInCart = By.xpath("//div[@class='gg-d-8 gg-m-10 detail-price']");
    By productQuantityBox = By.xpath("//select[@class='amount']");
    By selectProductQuantity2 = By.xpath("//select[@class='amount']/option[@value='2']");
    By newProductQuantityBox = By.xpath("//select[@data-value='2']");
    By deleteProductButton = By.xpath("(//i[@class='gg-icon gg-icon-bin-medium'])[1]");
    By cartMessage = By.xpath("//div[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']/h2");
    String message = "Sepetinizde ürün bulunmamaktadır.";


    public CartPage(WebDriver driver) {
        this.driver = driver;

    }

    public void increaseAndCheckQuantityProduct() throws InterruptedException {
        driver.findElement(productQuantityBox).click();
        driver.findElement(selectProductQuantity2).click();
        Thread.sleep(2000);
        driver.findElement(newProductQuantityBox).isDisplayed();
    }

    public void deleteProductsInCart() throws InterruptedException {
        driver.findElement(deleteProductButton).click();
        Thread.sleep(2000);
        String CartMessage = driver.findElement(cartMessage).getText();
        Assert.assertEquals(CartMessage,message);

    }
}
