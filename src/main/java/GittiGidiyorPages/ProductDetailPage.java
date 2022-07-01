package GittiGidiyorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ProductDetailPage {
    WebDriver driver;

    By addToCartButton = By.id("add-to-basket");
    By cartItemCounter = By.xpath("//span[@class='notify-user basket-item-count']");
    By productPrice = By.id("sp-price-highPrice");
    By productName = By.id("sp-title");
    By myCartButton = By.xpath("//span[@class='basket-title']");
    By goToMyCartButton = By.xpath("//a[@class='gg-ui-btn-default padding-none']");


    public  ProductDetailPage (WebDriver driver){
        this.driver = driver;
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(addToCartButton).click();
        Thread.sleep(1000);
        driver.findElement(cartItemCounter).isDisplayed();
    }

    public void printToTxtFile() throws IOException {

        String ProductName = driver.findElement(productName).getText();
        String ProductPrice = driver.findElement(productPrice).getText();

        List<String> lines = Arrays.asList("Ürün Detayları :"+"\n"+ProductName+"\n"+ProductPrice);
        Path file = Paths.get("C:\\Projeler\\TestinumUiTest\\src\\test\\java\\testinium\\gittiGidiyor\\TxtFile.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
        System.out.println("Ürün Detayları :"+"\n"+ProductName+"\n"+ProductPrice);
   }

    public CartPage goToMyCart() throws InterruptedException {
        Thread.sleep(1000);
        Actions hover = new Actions(driver);
        WebElement cartButton = driver.findElement(myCartButton);
        hover.moveToElement(cartButton).perform();
        Thread.sleep(1000);
        driver.findElement(goToMyCartButton).click();
        return new CartPage(driver);
    }
}
