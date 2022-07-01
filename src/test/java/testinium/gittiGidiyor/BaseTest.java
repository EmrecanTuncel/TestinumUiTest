package testinium.gittiGidiyor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    WebDriver driver;
    By closePopUp = By.xpath("//div[@class='wis_clsbtn']");
    By cookieClose = By.xpath("//a[@class='tyj39b-5 lfsBU']");

    @Before
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.gittigidiyor.com");
        Thread.sleep(2000);
        driver.findElement(closePopUp).click();
        Thread.sleep(2000);
        driver.findElement(cookieClose).click();
        Thread.sleep(2000);
    }
}
