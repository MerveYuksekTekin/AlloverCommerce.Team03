package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;


public class US17_VendorShopping {
    Pages allPages = new Pages();
    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void setUp() {
        //Web sitesine git https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        //Sign in linkini tikla
        allPages.homePage().signInButton.click();
        //Vendor hesabi ile giris yap
        allPages.userVendorLoginPage().emailBox.sendKeys("nike.crew@floodouts.com");
        allPages.userVendorLoginPage().passwordBox.sendKeys("ft123456");
        allPages.userVendorLoginPage().signInButton.click();

        //Sign Out tikla
        allPages.homePage().signOutButton.click();
        //ORDERS linkine tikla

        allPages.myAccountPage().ordersButton.click();
        //Search kutusuna tikla
        allPages.vendorProductDashboardPage().searchBox.sendKeys("Kalem", Keys.ENTER);

        //Add to Cart butonuna tikla
        allPages.vendorProductDashboardPage().addToCartButton.click();
        //Cart butonuna tikla

        allPages.vendorProductDashboardPage().cart.click();
        //Secilen urunlerin sepete eklendigini dogrula
        Assert.assertTrue(allPages.vendorProductDashboardPage().viewCart.isDisplayed());


    }

    @Test
    public void tc01() {
        //View Cart tiklanarak alınacak ürün ve ürünler görülebilmeli
        allPages.vendorProductDashboardPage().viewCart.click();
        Assert.assertTrue(allPages.vendorProductDashboardPage().product.isDisplayed());
    }

    @Test
    public void tc02() {
        //Checkout tiklanarak alınacak ürün ve ürünler görülebilmeli
        allPages.vendorProductDashboardPage().checkout.click();
        Assert.assertTrue(allPages.vendorProductDashboardPage().yourorder.isDisplayed());

    }

    @Test
    public void tc03() {
        //Fatura ayrintilari(Billing details)otomatik gelmeli
        allPages.vendorProductDashboardPage().checkout.click();
        softAssert.assertTrue(allPages.vendorProductDashboardPage().firstName.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductDashboardPage().lastName.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductDashboardPage().country.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductDashboardPage().street.isDisplayed());




    }
}


