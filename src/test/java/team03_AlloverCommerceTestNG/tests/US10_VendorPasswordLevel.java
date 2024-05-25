package team03_AlloverCommerceTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class US10_VendorPasswordLevel {
    Pages allPages=new Pages();

    @BeforeMethod
    public void setUp() {
       //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

       //Register linkine tıkla
        allPages.homePage().registerButton.click();

       //Become a Vendor linkine tıkla
        allPages.registerPage().becomeAVendorLink.click();
    }

    @Test
    public void tc01() {
        //Password boxa tek harf bir password gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("a");

        //Too short gördüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().passwordWrongMessage.getText(),"Too short");
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
