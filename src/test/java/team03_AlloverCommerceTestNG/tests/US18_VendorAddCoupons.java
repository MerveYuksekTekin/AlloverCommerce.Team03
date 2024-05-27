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

        allpages.homePage().signOutButton.click();

       allpages.myAccountPage().storeManagerButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForSecond(3);
        //actions.moveToElement(allpages.vendorProductManagerPage().couponsButton).perform();
        allpages.vendorProductManagerPage().coupons.click();
        WebElement addnewcoupon =Driver.getDriver().findElement(By.xpath("//*[@id='add_new_coupon_dashboard']"));


       //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].scrollIntoView(true)",addnewcoupon);
        ReusableMethods.click(addnewcoupon);
        ReusableMethods.scroll(allpages.vendorProductManagerPage().addNewCoupon);
        allpages.vendorProductManagerPage().addNewCoupon.click();

    }

    @Test
    public void tc02() {
        ReusableMethods.scroll(allpages.vendorProductManagerPage().codeBox);
        allpages.vendorProductManagerPage().codeBox.sendKeys("SPRINGSALE20");

        allpages.vendorProductManagerPage().descriptionBox.sendKeys("Bahar sezonu indirimleri için %20 indirim kuponu.");

    }

    @Test
    public void tc03() {
     //Discount Type; Percentage discount secilebilmeli
        WebElement discountype=allpages.vendorProductManagerPage().discountType;
        Select select=new Select(discountype);
        select.selectByVisibleText("Percentage discount");


    }

    @Test
    public void tc04() {
        //Discount Type; Fixed product discount secilebilmeli
        ReusableMethods.scroll(allpages.vendorProductManagerPage().discountType);
        WebElement fixedproduct=allpages.vendorProductManagerPage().discountType;
        Select select=new Select(fixedproduct);
        select.selectByIndex(1);


    }

    @Test
    public void tc05() {
        //Coupon amount yazilabilmeli
        ReusableMethods.scroll(allpages.vendorProductManagerPage().couponAmountBox);
        allpages.vendorProductManagerPage().couponAmountBox.sendKeys("50");




    }
}
