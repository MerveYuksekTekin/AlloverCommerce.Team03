package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ActionsUtils;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US08_Register_WishList {

    Pages allPages = new Pages();
    @BeforeMethod
    public void setUp() {
    //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
    //Sing In linkine tıkla
        allPages.homePage().signInButton.click();
    //Username or email adress kutusuna geçerli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("kourosh.lavell@floodouts.com");
    //Password kutusuna geçerli bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("Mm123456.");
    //SING IN butonuna tıkla
        allPages.userVendorLoginPage().signInButton.click();
    }

    @Test
    public void tc01() {
        //Search kutusuna tıkla
        allPages.vendorProductDashboardPage().searchBox.submit();

        //Databasede tanımlı olan bir ürün ismi yaz
        allPages.vendorProductDashboardPage().searchBox.sendKeys("macbook", Keys.ENTER);

        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(allPages.productPage().macbook).perform();
        ReusableMethods.click(allPages.wishlistPage().wishListSymbol);

        //Search kutusuna tıkla
        allPages.vendorProductDashboardPage().searchBox.submit();

        //Databasede tanımlı olan bir ürün ismi yaz
        allPages.vendorProductDashboardPage().searchBox.sendKeys("iphone", Keys.ENTER);
    }

    @Test
    public void tc02() {
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        allPages.wishlistPage().wishListIcon.submit();

        //Eklenen ürünlerin Wishlist listesinde olduğunu doğrula
        Assert.assertTrue(allPages.productPage().iphone.isDisplayed(), "gorunur değil");
        Assert.assertTrue(allPages.productPage().macbook.isDisplayed(), "gorunur degil");

    }

    @Test
    public void tc03() {
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        allPages.wishlistPage().wishListIcon.click();

        //Macbook V20.1 isimli ürünün sağındaki QUICK VIEW butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().quickViewButton1);

        //Ürünün özelliklerinin görüntülendiğini doğrula

        //Açılan özellikler sayfasını close(x) butonundan kapat
        allPages.wishlistPage().closeButton.click();

        //Iphone 15 Pro Max isimli ürünün  sırasındaki QUICK VIEW butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().quickViewButton2);

        //Ürünün özelliklerinin görüntülendiğini doğrula

    }

    @Test
    public void tc04() {
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        allPages.wishlistPage().wishListIcon.click();

        //Macbook V20.1 isimli ürünün sırasındaki ADD TO CART butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().addToCartButton1);

        //Cart iconuna tıkla
        allPages.vendorCouponsPage().cartIcon.click();

        //Açılan sekmeden VIEW CART butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().addToCartButton2);

        //Ürünlerin sepete eklendiğini doğrula

    }

    @Test
    public void tc05() {
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        allPages.wishlistPage().wishListIcon.click();
    }
}
