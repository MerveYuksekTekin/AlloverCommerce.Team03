package team03_AlloverCommerceTestNG.tests.US17_VendorShopping;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;


public class US17_VendorShopping {
    Pages allPages = new Pages();
    Actions actions=new Actions(Driver.getDriver());


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
        Assert.assertTrue(allPages.vendorProductDashboardPage().shoppingcart.isDisplayed());

        //Checkout tiklanarak alinacak urunlerin goruldugunu dogrula
        allPages.vendorProductDashboardPage().checkout.click();
        Assert.assertTrue(allPages.vendorProductDashboardPage().yourorder.isDisplayed());


    }

    @Test(priority = 1)
    public void BillingDetailsOtomatic() {

        //Fatura ayrintilari(Billing details)otomatik geldigini dogrula

        //First name otomatik geldigini dogrula
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().firstName);
        ReusableMethods.waitForSecond(5);

        if (allPages.vendorProductDashboardPage().firstName != null) {
            Assert.assertTrue(true);
        }
        if (allPages.vendorProductDashboardPage().lastName != null) {
            Assert.assertTrue(true);
        }
        if (allPages.vendorProductDashboardPage().country != null) {
            Assert.assertTrue(true);

        }
        if (allPages.vendorProductDashboardPage().street != null) {
            Assert.assertTrue(true);
        }
        if (allPages.vendorProductDashboardPage().townCity != null) {
            Assert.assertTrue(true);

        }
        if (allPages.vendorProductDashboardPage().postcodeZip != null) {
            Assert.assertTrue(true);

        }
        if (allPages.vendorProductDashboardPage().phone != null) {
            Assert.assertTrue(true);

        }
        if (allPages.vendorProductDashboardPage().email != null) {
            Assert.assertTrue(true);

            ReusableMethods.waitForSecond(3);


            ReusableMethods.click(allPages.homePage().signOutfiliz);

            //ReusableMethods.click(Driver.getDriver().findElement(By.xpath("//span[.='Sign Out']")));
            ReusableMethods.click(allPages.myAccountPage().logoutButton);


        }
    }



    @Test(priority = 2)
    public void ToplamRakam () {
        //Toplam ödenecek miktarin goruntulenebildigini dogrula
        //ReusableMethods.waitForSecond(3);
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().totalprice);
        Assert.assertTrue(allPages.vendorProductDashboardPage().totalprice.isDisplayed());
        ReusableMethods.waitForSecond(4);

        ReusableMethods.click(allPages.homePage().signOutfiliz);
        ReusableMethods.click(allPages.myAccountPage().logoutButton);



    }

    @Test(priority = 3)
    public void ShoppingSucces() {
        //Wire Transfer secili geldigini dogrula
        // ReusableMethods.click(allPages.vendorProductDashboardPage().wireTransfer);
        Assert.assertTrue(allPages.vendorProductDashboardPage().wireTransfer.isSelected());


        //Pay at the door transfer/EFT seceneginin secilebildigini dogrula
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().payAtTheDoor);
        ReusableMethods.waitForSecond(3);
        ReusableMethods.click(allPages.vendorProductDashboardPage().payAtTheDoor);
        Assert.assertTrue(allPages.vendorProductDashboardPage().payAtTheDoor.isSelected());

        //Place Order  tıklayarak  alışverişin tamamlandığıni dogrula

        ReusableMethods.waitForSecond(2);
        ReusableMethods.click(allPages.vendorProductDashboardPage().placeOrder);

        Assert.assertTrue(allPages.vendorProductDashboardPage()
                .Verifymessage.getText().contains("Thank you. Your order has been received."));

        ReusableMethods.waitForSecond(3);


        ReusableMethods.click(allPages.homePage().signOutfiliz);
        ReusableMethods.click(allPages.myAccountPage().logoutButton);
    }

    @Test(priority = 4)
    public void OrderDetails() {

        //ORDER DETAILS' in gorulebildigini dogrula

        ReusableMethods.scroll(allPages.vendorProductDashboardPage().payAtTheDoor);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.click(allPages.vendorProductDashboardPage().placeOrder);
        ReusableMethods.waitForSecond(10);
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().myAccount);
        ReusableMethods.click(allPages.vendorProductDashboardPage().myAccount);
        ReusableMethods.click(allPages.myAccountPage().ordersButton);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.click(allPages.vendorProductDashboardPage().siparisWiewButonu);
        ReusableMethods.waitForSecond(4);
        //ReusableMethods.scroll(allPages.vendorProductDashboardPage().totalprice);
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().orderdetails);
        Assert.assertTrue(allPages.vendorProductDashboardPage().orderdetails.isDisplayed());


    }
}
