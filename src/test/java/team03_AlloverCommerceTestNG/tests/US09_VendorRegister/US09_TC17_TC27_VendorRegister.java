package team03_AlloverCommerceTestNG.tests.US09_VendorRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US09_TC17_TC27_VendorRegister {

    Pages allPages = new Pages();

    @BeforeMethod
    public void setUp() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ExtentReportUtils.extentTestInfo("Web sitesine gidildi");

        //Register linkine tıkla
        allPages.homePage().registerButton.click();
        ExtentReportUtils.extentTestInfo("Register linkine tıklandı");

        //Become a Vendor linkine tıkla
        allPages.registerPage().becomeAVendorLink.click();
        ExtentReportUtils.extentTestInfo("Become a Vendor linkine tıklandı");
    }



    @Test(description = "US09-Vendor Register")
    public void tc17() {
        //Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        //Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        //Password boxa küçük harf, büyük harf,rakam ve special karakter içeren bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Password boxa küçük harf, büyük harf,rakam ve special karakter içeren bir veri girildi");

        //Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        //Giriş yapıldığını doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().welcomeToAllevorCommerce.getText(), "Welcome to Allover Commerce!");
        Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
        ReusableMethods.logOut();
        ExtentReportUtils.extentTestPass("Giriş yapıldığı doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc18() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa veri girme
        allPages.vendorRegisterPage().passwordBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Password boxa veri girme girilmedi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Password kutusu boş bıraktığında kayıt işlemi gerçekleşmediğini doğrula
        Assert.assertTrue(ReusableMethods.passwordWrongMessage().contains("Password: This field is required."));
        ExtentReportUtils.extentTestPass("Password kutusu boş bıraktığında kayıt işlemi gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc19() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa küçük harf içermeyip, büyük harf,rakam ve special karakter içeren bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("AS1.AS1.");
        ExtentReportUtils.extentTestInfo("Password boxa küçük harf içermeyip, büyük harf,rakam ve special karakter içeren bir veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("AS1.AS1.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Password boxa küçük harf içermeyip, büyük harf,rakam ve special karakter içermeyen veri girildiğinde kayıt işleminin gerçekleşmediğini doğrula
       try {
           Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
       }catch (AssertionError ignored){

       }finally {
           Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
           ReusableMethods.logOut();
       }
       ExtentReportUtils.extentTestFail("Password boxa küçük harf içermeyip, büyük harf,rakam ve special karakter içermeyen veri girildiğinde kayıt işleminin gerçekleşmemesi gerekirdi, kayıt oldu!!");
    }

    @Test(description = "US09-Vendor Register")
    public void tc20() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa küçük harf , rakam ve special karakter içerip ,büyük harf içermeyen bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("as1.as1.");
        ExtentReportUtils.extentTestInfo("Password boxa küçük harf , rakam ve special karakter içerip ,büyük harf içermeyen bir veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("as1.as1.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Password boxa küçük harf , rakam ve special karakter içerip ,büyük harf içermeyen bir veri girildiğinde kayıt işleminin gerçekleşmediğini doğrula
        try {
            Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
        }catch (AssertionError ignored){

        }finally {
            Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
            ReusableMethods.logOut();
        }
        ExtentReportUtils.extentTestFail("Password boxa küçük harf , rakam ve special karakter içerip ,büyük harf içermeyen bir veri girildiğinde kayıt işleminin gerçekleşmemesi gerekirdi, kayıt oldu!!");
    }

    @Test(description = "US09-Vendor Register")
    public void tc21() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password küçük harf , büyük harf ve special karakter içerip ,rakam içermeyen bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As.As.");
        ExtentReportUtils.extentTestInfo("Password küçük harf , büyük harf ve special karakter içerip ,rakam içermeyen bir veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As.As.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Password küçük harf , büyük harf ve special karakter içerip ,rakam içermeyen bir veri girdiğimizde kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
        ExtentReportUtils.extentTestFail("Password küçük harf , büyük harf ve special karakter içerip ,rakam içermeyen bir veri girdiğimizde kayıt işleminin gerçekleşmemesi gerekirdi, kayıt oldu!!");
    }

    @Test(description = "US09-Vendor Register")
    public void tc22() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa küçük harf , büyük harf ve rakam içerip ,special karakter içermeyen veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1As1");
        ExtentReportUtils.extentTestInfo("Password boxa küçük harf , büyük harf ve rakam içerip ,special karakter içermeyen veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1As1");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Password boxa küçük harf , büyük harf ve rakam içerip ,special karakter içermeyen bir veri girdiğinde kayıt işleminin gerçeklemediğini doğrula
        try {
            Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
        }catch (AssertionError ignored){

        }finally {
            Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
            ReusableMethods.logOut();
        }
        ExtentReportUtils.extentTestFail("Password boxa küçük harf , büyük harf ve rakam içerip ,special karakter içermeyen bir veri girdiğinde kayıt işleminin gerçeklememesi gerekirdi, kayıt oldu!!");
    }

    @Test(description = "US09-Vendor Register")
    public void tc23() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Password boxa geçerli bir veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Passwordun tekrar yazıldığını doğrula
        Assert.assertNotNull(allPages.vendorRegisterPage().confirmPasswordBox);
        ExtentReportUtils.extentTestPass("Passwordun tekrar yazıldığı doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc24() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Password boxa geçerli bir veri girildi");

        // Confirm Password boxu boş bırak
        allPages.vendorRegisterPage().passwordBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Confirm Password boxu boş bırakıldı");

// Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Confirm Password box boş bırakıldığında kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
        ExtentReportUtils.extentTestPass("Confirm Password box boş bırakıldığında kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc25() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Password boxa geçerli bir veri girildi");

        // Confirm Password boxa farklı veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa farklı veri girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Confim Password box'a geçersiz veri girildiğinde kayıt işleminin gerçekleşmediğini doğrula
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String dynamicText = (String) jsExecutor.executeScript(
                "return document.querySelector('.wcfm-message.wcfm-error').textContent;");
        Assert.assertEquals(dynamicText,"Confirm Password: This field is required.");
        ExtentReportUtils.extentTestPass("Confim Password box'a geçersiz veri girildiğinde kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc26() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Password boxa geçerli bir veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıklayarak vendor olarak kaydın tamamlandığını doğrula
        Assert.assertTrue(allPages.vendorRegisterPage().registerButton.isDisplayed());
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        Assert.assertEquals(allPages.vendorRegisterPage().welcomeToAllevorCommerce.getText(), "Welcome to Allover Commerce!");
        Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
        ReusableMethods.logOut();
        ExtentReportUtils.extentTestPass("Register butonuna tıklayarak vendor olarak kaydın tamamlandığı doğrulandı");

    }

    @Test(description = "US09-Vendor Register")
    public void tc27() {
        // Email boxa kayıtlı veri gir
        allPages.vendorRegisterPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("12345");
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Password boxa geçerli bir veri girildi");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");
        ExtentReportUtils.extentTestInfo("Confirm Password boxa aynı passwordu tekrar girildi");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // "This Email already exists. Please login to the site and apply as vendor." mesajının alındığını doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");
        ExtentReportUtils.extentTestPass("\"This Email already exists. Please login to the site and apply as vendor.\" mesajının alındığı doğrulandı");
    }

}
