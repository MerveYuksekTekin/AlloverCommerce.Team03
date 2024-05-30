package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team03_AlloverCommerceTestNG.pages.P20_VendorCouponsPage;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ActionsUtils;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.time.Duration;

public class US08_Register_WishList {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void setUp() {
    //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
    //Sing In linkine tıkla
        allPages.homePage().signInButton.click();
    //Username or email adress kutusuna geçerli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys(ConfigReader.getProperty("email"));
    //Password kutusuna geçerli bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(ConfigReader.getProperty("password"));
    //SING IN butonuna tıkla
        allPages.userVendorLoginPage().signInButton.click();
    }

    @Test
    public void TC01_addProductToWishList() {

        //Search kutusuna tıkla
        ReusableMethods.waitForSecond(2);
        allPages.vendorCouponsPage().search.click();

        //Databasede tanımlı olan bir ürün ismi yaz
        allPages.vendorCouponsPage().search.sendKeys(ConfigReader.getProperty("macbook"));
        allPages.vendorCouponsPage().search.submit();

        ReusableMethods.waitForSecond(2);
        ActionsUtils.hoverOver(allPages.productPage().macBookV20);
        allPages.wishlistPage().wishListSymbol.click();

        allPages.vendorCouponsPage().search.sendKeys(ConfigReader.getProperty("iphone"),Keys.ENTER);
        ReusableMethods.waitForSecond(2);
        ActionsUtils.hoverOver(allPages.productPage().iphone);
        allPages.wishlistPage().wishListSymbol.click();

        Assert.assertTrue(allPages.wishlistPage().wishListSymbol.isEnabled());


    }

    @Test
    public void TC02_viewProductInWishList() {
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        ReusableMethods.click(allPages.wishlistPage().wishListIcon);

        ActionsUtils.scrollDown();
        //Eklenen ürünlerin Wishlist listesinde olduğunu doğrula
        Assert.assertTrue(allPages.productPage().products.getText().contains("Macbook V20.1"));
        Assert.assertTrue(allPages.productPage().products.getText().contains("Iphone 15 Pro Max"));
    }

    @Test
    public void TC03_viewProductsProperty() {
        ReusableMethods.waitForSecond(2);
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        allPages.wishlistPage().wishListIcon.click();

        //Macbook V20.1 isimli ürünün sağındaki QUICK VIEW butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().quickViewButton1);
        ReusableMethods.waitForSecond(2);


        //Açılan özellikler sayfasını close(x) butonundan kapat
        ReusableMethods.click(allPages.wishlistPage().closeButton);

        //Iphone 15 Pro Max isimli ürünün  sırasındaki QUICK VIEW butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().quickViewButton2);
        ReusableMethods.waitForSecond(2);
        System.out.println(allPages.productPage().urunQuickView.getText());

        //Ürünün özelliklerinin görüntülendiğini doğrula
        Assert.assertTrue(allPages.productPage().urunQuickView.getText().contains("iphone 15 pro max"));

    }

    @Test
    public void TC04_addProductToCart(){
        ReusableMethods.waitForSecond(3);
        //Search kutusunun yanındaki Wishlist iconuna tıkla
        allPages.wishlistPage().wishListIcon.click();

        //Macbook V20.1 isimli ürünün sırasındaki ADD TO CART butonuna tıkla
        ActionsUtils.scrollDown();
        ReusableMethods.click(allPages.wishlistPage().addToCartButton1);

        //Iphone 15 Pro Max isimli ürünün  sırasındaki ADD TO CART   butonuna tıkla
        ReusableMethods.click(allPages.wishlistPage().addToCartButton2);

        //Cart iconuna tıkla
        ActionsUtils.scrollUp();
        allPages.vendorCouponsPage().cartIcon.click();

        //Açılan sekmeden VIEW CART butonuna tıkla
        allPages.wishlistPage().viewCartButton.click();

        //Ürünlerin sepete eklendiğini doğrula
        Assert.assertTrue(allPages.productPage().products.getText().contains("Macbook V20.1"));
        Assert.assertTrue(allPages.productPage().products.getText().contains("Iphone 15 Pro Max"));


    }

    @Test
    public void TC05_buyProduct() {
        ReusableMethods.waitForSecond(3);
        //Cart iconuna tıkla
        allPages.vendorCouponsPage().cartIcon.click();

        //Açılan sekmeden VIEW CART butonuna tıkla
        allPages.wishlistPage().viewCartButton.click();

        //Sayfanın alt bölümündeki PROCEED TO CHECKOUT butonuna tıkla
        ActionsUtils.scrollDown();
        ReusableMethods.waitForSecond(2);

        ReusableMethods.click(allPages.wishlistPage().proceedToCheckout);

        //PLACE ORDER butonuna tıkla
        allPages.vendorCouponsPage().placeOrderButton.submit();

        //Siparişin oluşturulduğuna dair mesaj alındığını doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().orderFinishText.getText(),"Thank you. Your order has been received.");

    }

    @AfterClass
    public void afterClass() {
        ReusableMethods.click(allPages.homePage().signOutButton);
        ReusableMethods.click(allPages.myAccountPage().logoutButton);
    }
}
