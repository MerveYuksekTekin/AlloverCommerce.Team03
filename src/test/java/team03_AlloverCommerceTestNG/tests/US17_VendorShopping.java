package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

        //Browse Product tikla
       // ReusableMethods.click(allPages.myAccountPage().browseProduct);


        //Search kutusuna tikla
        allPages.vendorProductDashboardPage().searchBox.sendKeys("Kalem", Keys.ENTER);

        //Add to Cart butonuna tikla
        allPages.vendorProductDashboardPage().addToCartButton.click();
        //Cart butonuna tikla
        allPages.vendorProductDashboardPage().cart.click();
        //Secilen urunlerin sepete eklendigini dogrula
        Assert.assertTrue(allPages.vendorProductDashboardPage().viewCart.isDisplayed());


    }

   // @Test()
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
        //Fatura ayrintilari(Billing details)otomatik geldigini dogrula
        allPages.vendorProductDashboardPage().checkout.click();
       //First name otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"Mike");
         //Lastname otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"John");
        //Company name otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"Tira");
        //Country otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"Germany");
        //Street adres otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"Mosel str8");

        //Postcode otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"60306");
        //Town/City otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"Frankfurt");
        //State otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"Hesse");
        //Phone otomatik geldigigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"123456");
        //Email adresin otomatik geldigini dogrula
        softAssert.assertEquals(allPages.vendorProductDashboardPage()
                .firstName.getAttribute("value"),"nike.crew@floodouts.com");



    }

    @Test
    public void tc04() {

        //Toplam ödenecek miktarin goruntulenebildigini dogrula
        allPages.vendorProductDashboardPage().checkout.click();
        allPages.vendorProductDashboardPage().totalprice.isDisplayed();
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().totalprice);
        Assert.assertTrue(allPages.vendorProductDashboardPage().totalprice.isDisplayed());

        //Pay at the door transfer/EFT seceneginin secilebildigini dogrula
        ReusableMethods.waitForSecond(3);
        ReusableMethods.click(allPages.vendorProductDashboardPage().payAtTheDoor);
        Assert.assertTrue(allPages.vendorProductDashboardPage().payAtTheDoor.isSelected());

        //Place Order  tıklayarak  alışverişin tamamlandığıni dogrula

         ReusableMethods.waitForSecond(2);
         ReusableMethods.click(allPages.vendorProductDashboardPage().placeOrder);

        Assert.assertTrue(allPages.vendorProductDashboardPage()
                .Verifymessage.getText().contains("Thank you. Your order has been received."));


        ReusableMethods.waitForSecond(3);
        //ORDER DETAILS' in gorulebildigini dogrula
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().myAccount);
        ReusableMethods.click(allPages.vendorProductDashboardPage().myAccount);
        ReusableMethods.click(allPages.myAccountPage().ordersButton);



    }

}
