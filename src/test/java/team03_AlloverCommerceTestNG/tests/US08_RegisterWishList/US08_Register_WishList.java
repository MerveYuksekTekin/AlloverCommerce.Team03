package team03_AlloverCommerceTestNG.tests.US08_RegisterWishList;

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
import team03_AlloverCommerceTestNG.utilities.*;

import java.time.Duration;

public class US08_Register_WishList {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ExtentReportUtils.extentTestInfo("Web sitesine gidildi");

        allPages.homePage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sing In linkine tıklandı");

        allPages.userVendorLoginPage().emailBox.sendKeys(ConfigReader.getProperty("email"));
        ExtentReportUtils.extentTestInfo("Emailbox alanına geçerli email girildi");

        allPages.userVendorLoginPage().passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ExtentReportUtils.extentTestInfo("Password alanına geçerli password girildi");

        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sing In butonuna tıklandı");
    }

    @Test(description = "US08-Register_WishList")
    public void TC01_addProductToWishList() {
        ReusableMethods.waitForSecond(2);
        allPages.vendorCouponsPage().search.click();
        ExtentReportUtils.extentTestInfo("Search kutusuna tıklanıldı");

        allPages.vendorCouponsPage().search.sendKeys(ConfigReader.getProperty("macbook"));
        ExtentReportUtils.extentTestInfo("Searchbox butonuna Basic Handbag yazıldı");

        allPages.vendorCouponsPage().search.submit();
        ExtentReportUtils.extentTestInfo("Enter tuşuna basıldı");

        ReusableMethods.waitForSecond(2);
        ActionsUtils.hoverOver(allPages.productPage().macBookV20);
        allPages.wishlistPage().wishListSymbol.click();
        ExtentReportUtils.extentTestInfo("Macbook V20 isimli ürüne tıklanıldı");


        allPages.vendorCouponsPage().search.sendKeys(ConfigReader.getProperty("iphone"), Keys.ENTER);
        ExtentReportUtils.extentTestInfo("Search kutusuna iphone yazıldı ve Enter tuşuna basıldı");

        ReusableMethods.waitForSecond(2);
        ActionsUtils.hoverOver(allPages.productPage().iphone);
        allPages.wishlistPage().wishListSymbol.click();
        ExtentReportUtils.extentTestInfo("Iphone 15 Pro Max isimli ürüne tıklanıldı");

        Assert.assertTrue(allPages.wishlistPage().wishListSymbol.isEnabled());
        ExtentReportUtils.extentTestInfo("WishList sembolün tıklanabilir olduğu doğrulandı");

        ReusableMethods.logOut();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

    @Test(description = "US08-Register_WishList")
    public void TC02_viewProductInWishList() {
        ReusableMethods.click(allPages.wishlistPage().wishListIcon);
        ActionsUtils.scrollDown();
        ExtentReportUtils.extentTestInfo("WishList iconuna tıklanıldı");

        Assert.assertTrue(allPages.productPage().products.getText().contains("Macbook V20.1"));
        Assert.assertTrue(allPages.productPage().products.getText().contains("Iphone 15 Pro Max"));
        ExtentReportUtils.extentTestInfo("Eklenen ürünlerin Wishlist listesinde olduğu doğrulandı");

        JSUtils.JSclickWithTimeout(allPages.vendorCouponsPage().signOutMine);
        allPages.myAccountPage().logoutButton.click();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

    @Test(description = "US08-Register_WishList")
    public void TC03_viewProductsProperty() {
        ReusableMethods.waitForSecond(2);
        allPages.wishlistPage().wishListIcon.click();
        ExtentReportUtils.extentTestInfo("WishList iconuna tıklanıldı");

        ReusableMethods.click(allPages.wishlistPage().quickViewButton1);
        ReusableMethods.waitForSecond(2);
        ExtentReportUtils.extentTestInfo("QUİCK VIEW butonuna tıklanıldı");

        ReusableMethods.click(allPages.wishlistPage().closeButton);
        ExtentReportUtils.extentTestInfo("Close butonuna tıklanıldı");

        ReusableMethods.click(allPages.wishlistPage().quickViewButton2);
        ExtentReportUtils.extentTestInfo("QUİCK VIEW butonuna tıklanıldı");

        ReusableMethods.click(allPages.wishlistPage().closeButton);
        ExtentReportUtils.extentTestInfo("Close butonuna tıklanıldı");

        //Ürünün özelliklerinin görüntülendiğini doğrula
        Assert.assertTrue(allPages.productPage().products.getText().contains("Iphone 15 Pro Max"));
        ExtentReportUtils.extentTestInfo("Ürünün özelliklerinin görüntülendiği doğrulandı");

        JSUtils.JSclickWithTimeout(allPages.vendorCouponsPage().signOutMine);
        allPages.myAccountPage().logoutButton.click();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US08-Register_WishList")
    public void TC04_addProductToCart() {
        ReusableMethods.waitForSecond(3);
        allPages.wishlistPage().wishListIcon.click();
        ExtentReportUtils.extentTestInfo("WishList iconuna tıklanıldı");

        ActionsUtils.scrollDown();
        ReusableMethods.click(allPages.wishlistPage().addToCartButton1);
        ExtentReportUtils.extentTestInfo(" ADD TO CART butonuna tıklanıldı");

        ReusableMethods.click(allPages.wishlistPage().addToCartButton2);
        ExtentReportUtils.extentTestInfo(" 15 Pro Max isimli ürünün  sırasındaki ADD TO CART butonuna tıklanıldı");

        ActionsUtils.scrollUp();
        allPages.vendorCouponsPage().cartIcon.click();
        ExtentReportUtils.extentTestInfo(" CART iconuna tıklanıldı");

        allPages.wishlistPage().viewCartButton.click();
        ExtentReportUtils.extentTestInfo("VIEW CART iconuna tıklanıldı");


        //Ürünlerin sepete eklendiğini doğrula
        Assert.assertTrue(allPages.productPage().products.getText().contains("Macbook V20.1"));
        Assert.assertTrue(allPages.productPage().products.getText().contains("Iphone 15 Pro Max"));
        ExtentReportUtils.extentTestInfo("Ürünlerin sepete eklendiği doğrulandı");

        ReusableMethods.logOut();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US08-Register_WishList")
    public void TC05_buyProduct() {
        ReusableMethods.waitForSecond(3);
        allPages.vendorCouponsPage().cartIcon.click();
        ExtentReportUtils.extentTestInfo(" CART iconuna tıklanıldı");

        allPages.wishlistPage().viewCartButton.click();
        ExtentReportUtils.extentTestInfo("VIEW CART iconuna tıklanıldı");


        ReusableMethods.waitForSecond(2);
        allPages.wishlistPage().proceedToCheckout.click();
        ExtentReportUtils.extentTestInfo("PROCEED TO CHECKOUT butonuna tıklanıldı");

        allPages.vendorCouponsPage().placeOrderButton.click();
        ExtentReportUtils.extentTestInfo("PLACE ORDER butonuna tıklanıldı");

        Assert.assertEquals(allPages.vendorCouponsPage().orderFinishText.getText(), "Thank you. Your order has been received.");
        ExtentReportUtils.extentTestInfo("Siparişin oluşturulduğuna dair mesaj alındığı doğrulandı");

        ReusableMethods.logOut();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

}
