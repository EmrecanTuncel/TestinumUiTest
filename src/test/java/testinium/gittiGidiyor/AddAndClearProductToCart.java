package testinium.gittiGidiyor;

import GittiGidiyorPages.CartPage;
import GittiGidiyorPages.HomePage;
import GittiGidiyorPages.ProductDetailPage;
import GittiGidiyorPages.ResultPage;
import org.junit.Test;

import java.io.IOException;

public class AddAndClearProductToCart extends BaseTest{
    @Test
    public void Test() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);

        ResultPage resultPage = homePage.searchItem();
        resultPage.scrollToPageNumbers();
        resultPage.checkUrlAccuracy();

        ProductDetailPage productDetailPage = resultPage.goToProductDetail();
        productDetailPage.printToTxtFile();
        productDetailPage.addToCart();
        //productDetailPage.checkDetailForProduct();

        CartPage cartPage = productDetailPage.goToMyCart();
        cartPage.increaseAndCheckQuantityProduct();
        cartPage.deleteProductsInCart();



    }


}
