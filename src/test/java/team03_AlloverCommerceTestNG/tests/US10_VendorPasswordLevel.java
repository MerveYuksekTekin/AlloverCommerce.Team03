package team03_AlloverCommerceTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ExtentReportUtils;

public class US10_VendorPasswordLevel {
    Pages allPages=new Pages();

    @BeforeMethod
    public void setUp() {

       //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ExtentReportUtils.extentTestInfo("Web sitesine gidildi");


       //Register linkine tıkla
        allPages.homePage().registerButton.click();
        ExtentReportUtils.extentTestInfo("Register linkine tıkla");

       //Become a Vendor linkine tıkla
        allPages.registerPage().becomeAVendorLink.click();
        ExtentReportUtils.extentTestInfo("Become a Vendor linkine tıklandı");
    }

    @Test
    public void tc01() {
        //Password boxa tek harf bir password gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("a");
        ExtentReportUtils.extentTestInfo("Password boxa tek harf bir password girildi");

        //Too short gördüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().passwordWrongMessage.getText(),"Too short");
        ExtentReportUtils.extentTestInfo("Become a Vendor linkine tıklandı");
    }

    @Test
    public void tc02() {
       // Password boxa aynı iki harf iki rakam ve iki sembol içeren bir pasword gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("aa11..");

       // Weak gördüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().passwordWrongMessage.getText(),"Weak");
    }

    @Test
    public void tc03() {
       // Password boxa farklı iki harf iki rakam ve iki sembol içeren blr password gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("as12.?");

       // Good gördüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().passwordWrongMessage.getText(),"Good");
    }

    @Test
    public void tc04() {
       //Password boxa en az 8 karakterli büyük küçük harf,rakam ve sembol içeren bir password gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("aS12.?a1");

       //Strong gördüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().passwordWrongMessage.getText(),"Strong");
    }
}
