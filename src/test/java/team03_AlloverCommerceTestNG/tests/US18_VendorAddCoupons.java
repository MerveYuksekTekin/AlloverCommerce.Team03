package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.time.Duration;


public class US18_VendorAddCoupons {
    Pages allpages =new Pages();
    Actions actions=new Actions(Driver.getDriver());




    @BeforeMethod
    public void setUp() {
        //1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        //2	Sign In linkini tikla
        allpages.homePage().signInButton.click();
        //3	Vendor hesabi ile giris yap
        allpages.userVendorLoginPage().emailBox.sendKeys("nike.crew@floodouts.com");
        allpages.userVendorLoginPage().passwordBox.sendKeys("ft123456");
        allpages.userVendorLoginPage().signInButton.click();
        //Sign outa tikla
        allpages.homePage().signOutButton.click();

        //Store menager butonun tikla
        allpages.myAccountPage().storeManagerButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForSecond(3);

        //Couponsa tikla
        allpages.vendorProductManagerPage().coupons.click();

        //Add news coupona tikla
        ReusableMethods.click(allpages.vendorProductManagerPage().addNewCoupon);
        ReusableMethods.scroll(allpages.vendorProductManagerPage().addNewCoupon);
        allpages.vendorProductManagerPage().addNewCoupon.click();

    }

    @Test(priority = 1)
    public void CouponAddVendor() {
        //Code kutucuguna  coupons kodu yazilabildigini dogrula
        ReusableMethods.scroll(allpages.vendorProductManagerPage().codeBox);
        allpages.vendorProductManagerPage().codeBox.sendKeys(Keys.DELETE, "SPRING20");//Her testte kupon adını degistirmelisin; aynı kupon var diyor yoksa
        Assert.assertTrue(allpages.vendorProductManagerPage().codeBox.getAttribute("value")
                .contains("SPRING20"));
        ReusableMethods.waitForSecond(2);

        //Description kismina aciklama yazilabildigini dogrula
        ReusableMethods.click(allpages.vendorProductManagerPage().descriptionBox);
        allpages.vendorProductManagerPage().descriptionBox
                .sendKeys("Bahar sezonu indirimleri için %20 indirim kuponu.");
        Assert.assertTrue(allpages.vendorProductManagerPage().descriptionBox.getAttribute("value")
                .contains("Bahar sezonu indirimleri için %20 indirim kuponu."));

        //Discount Type; Percentage discount secilebildigini dogrula
        WebElement discountype = allpages.vendorProductManagerPage().discountType;
        Select select = new Select(discountype);
        select.selectByVisibleText("Percentage discount");
        String seciliDiscount1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(seciliDiscount1, "Percentage discount");


        ReusableMethods.waitForSecond(2);

        //Discount Type; Fixed Product Discount secilebilmeldigini dogrula
        ReusableMethods.scroll(allpages.vendorProductManagerPage().discountType);
        WebElement fixedproduct = allpages.vendorProductManagerPage().discountType;
        Select select1 = new Select(fixedproduct);
        select.selectByVisibleText("Fixed Product Discount");
        String seciliDiscount2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(seciliDiscount2, "Fixed Product Discount");

        ////Coupon amount yazilabildigini dogrula
        ReusableMethods.scroll(allpages.vendorProductManagerPage().couponAmountBox);
        allpages.vendorProductManagerPage().couponAmountBox.sendKeys(Keys.DELETE, "20");
        Assert.assertEquals(allpages.vendorProductManagerPage().
                couponAmountBox.getAttribute("value"), "20");


        //Coupon Expiry date girilebildigini dogrula
        ReusableMethods.scroll(allpages.vendorProductManagerPage().couponsExpiryDate);
        allpages.vendorProductManagerPage().couponsExpiryDate.sendKeys("2024-05-28", Keys.ENTER);
        Assert.assertEquals(allpages.vendorProductManagerPage().
                couponsExpiryDate.getAttribute("value"), "2024-05-28");

        //Allow free shipping secilebildigini dogrula
        ReusableMethods.waitForSecond(2);
        allpages.vendorProductManagerPage().AllowFreeShippingCheckbox.click();
        Assert.assertTrue(allpages.vendorProductManagerPage().AllowFreeShippingCheckbox.isSelected());

        //Show one store secilebildigini dogrula
        ReusableMethods.scroll(allpages.vendorProductManagerPage().ShowOnStoreCheckbox);
        allpages.vendorProductManagerPage().ShowOnStoreCheckbox.click();
        ReusableMethods.waitForSecond(3);
        Assert.assertTrue(allpages.vendorProductManagerPage().ShowOnStoreCheckbox.isSelected());

        //Submit butonuna tikla
        ReusableMethods.scroll(allpages.vendorProductManagerPage().couponsSubmitButton);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.click(allpages.vendorProductManagerPage().couponsSubmitButton);



        //Coupons butonuna tikla
        ReusableMethods.waitForSecond(5);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.click(allpages.vendorProductManagerPage().coupons);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForSecond(3);


        //Acilan sayfada coupon olusturuldugunu dogrula
        Assert.assertTrue(allpages.vendorProductManagerPage().couponsNewCouponVerifyM.getText().contains("SPRING20"));
        ReusableMethods.click(allpages.homePage().signOutfiliz);
        ReusableMethods.click(allpages.myAccountPage().logoutButton);


    }

    @Test(priority = 2)
    public void CodeBoxEmptyNegativeScenario() {
        //Code kutucugu bos birakarak coupon eklenmedigini dogrula

        ReusableMethods.click(allpages.vendorProductManagerPage().descriptionBox);
        allpages.vendorProductManagerPage().descriptionBox
                .sendKeys("Bahar sezonu indirimleri için %20 indirim kuponu.");
        Assert.assertTrue(allpages.vendorProductManagerPage().descriptionBox.getAttribute("value")
                .contains("Bahar sezonu indirimleri için %20 indirim kuponu."));


        ReusableMethods.scroll(allpages.vendorProductManagerPage().discountType);
        WebElement discountype = allpages.vendorProductManagerPage().discountType;
        Select select = new Select(discountype);
        select.selectByVisibleText("Percentage discount");

        ReusableMethods.scroll(allpages.vendorProductManagerPage().couponAmountBox);
        allpages.vendorProductManagerPage().couponAmountBox.sendKeys(Keys.DELETE, "20");
        allpages.vendorProductManagerPage().couponsExpiryDate.sendKeys("2024-05-28", Keys.ENTER);
        allpages.vendorProductManagerPage().AllowFreeShippingCheckbox.click();
        ReusableMethods.waitForSecond(3);

        ReusableMethods.scroll(allpages.vendorProductManagerPage().couponsSubmitButton);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.click(allpages.vendorProductManagerPage().couponsSubmitButton);

        Assert.assertFalse(allpages.vendorProductManagerPage().errormessage.getText().contains("Please insert atleast Coupon Title before submit."));

    }

}
