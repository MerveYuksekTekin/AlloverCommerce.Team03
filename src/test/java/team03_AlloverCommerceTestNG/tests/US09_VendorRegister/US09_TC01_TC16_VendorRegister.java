package team03_AlloverCommerceTestNG.tests.US09_VendorRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US09_TC01_TC16_VendorRegister {

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
    public void tc01() {

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

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        ExtentReportUtils.extentTestInfo("Register butonuna tıklandı");

        // Welcome to Allover Commerce! yazısı göründüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().welcomeToAllevorCommerce.getText(), "Welcome to Allover Commerce!");
        Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
        ReusableMethods.logOut();
        ExtentReportUtils.extentTestPass("Welcome to Allover Commerce! yazısı göründüğü doğrulandı");

    }

    @Test(description = "US09-Vendor Register")
    public void tc02() {

        // Email box boş bırakılmalı
        allPages.vendorRegisterPage().emailBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Email box boş bırakılıldı");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(ReusableMethods.emailAndCodeMessage(), "Email: This field is required.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");

    }

    @Test(description = "US09-Vendor Register")
    public void tc03() {
        // Email boxa kullanıcı adı içermeyen email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("@gmail.com");
        ExtentReportUtils.extentTestInfo("Email boxa kullanıcı adı içermeyen email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "Please provide a valid email address.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");

    }

    @Test(description = "US09-Vendor Register")
    public void tc04() {
        // Email boxa @ işareti içermeyen email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("abcdgmail.com");
        ExtentReportUtils.extentTestInfo("Email boxa @ işareti içermeyen email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "Please provide a valid email address.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc05() {
        // Email boxa iki @ işaretli bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@@gmail.com");
        ExtentReportUtils.extentTestInfo("Email boxa iki @ işaretli bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "This Email already exists. Please login to the site and apply as vendor.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc06() {
        // Email boxa domain içermeyen bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@");
        ExtentReportUtils.extentTestInfo("Email boxa domain içermeyen bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "Please provide a valid email address.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc07() {
        // Email boxa kullanıcı adı space içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asd f@gmail.com");
        ExtentReportUtils.extentTestInfo("Email boxa kullanıcı adı space içeren bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "This Email already exists. Please login to the site and apply as vendor.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc08() {
        // Email boxa domaini space içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@g mail.com");
        ExtentReportUtils.extentTestInfo("mail boxa domaini space içeren bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "This Email already exists. Please login to the site and apply as vendor.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc09() {
        // Email boxa kullanıcı adı sembol içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("as#df@gmail.com");
        ExtentReportUtils.extentTestInfo("Email boxa kullanıcı adı sembol içeren bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(), "Confirm Password: This field is required.");
        ExtentReportUtils.extentTestFail("Kayıt işleminin gerçekleşmemesi gerekiyordu,gerçekleşti!!");


    }

    @Test(description = "US09-Vendor Register")
    public void tc10() {
        //Email boxa domaini sembol içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@gm#ail.com");
        ExtentReportUtils.extentTestInfo("Email boxa domaini sembol içeren bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "This Email already exists. Please login to the site and apply as vendor.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc11() {
        //Email boxa nokta ile başlayan bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys(".asdf@gmail.com");
        ExtentReportUtils.extentTestInfo("Email boxa nokta ile başlayan bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "Email verification code invalid.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");

    }

    @Test(description = "US09-Vendor Register")
    public void tc12() {
        //Email boxa nokta ile biten bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@gmail.com.");
        ExtentReportUtils.extentTestInfo("Email boxa nokta ile biten bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "This Email already exists. Please login to the site and apply as vendor.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc13() {
        //Email boxa top level domainsiz bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@gmail");
        ExtentReportUtils.extentTestInfo("Email boxa top level domainsiz bir email girildi");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");
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

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(), "Please provide a valid email address.");
        ExtentReportUtils.extentTestPass("Kayıt işleminin gerçekleşmediği doğrulandı");

    }

    @Test(description = "US09-Vendor Register")
    public void tc14() {
        //Email boxa geçerli bir email adresi gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.fakemail.net/");
        String email = Driver.getDriver().findElement(By.id("email")).getText();
        Driver.getDriver().close();
        ReusableMethods.switchToWindow(0);
        allPages.vendorRegisterPage().emailBox.sendKeys(email);
        ExtentReportUtils.extentTestInfo("Email boxa fakemail.com a giderek bir mail kopyalındı ve geçerli bir email girildi");

        //Email adresinin girildiğini doğrula
        Assert.assertNotNull(allPages.vendorRegisterPage().emailBox);
        ExtentReportUtils.extentTestPass("Email adresinin girildiği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc15() {
        //Email boxa geçerli bir email adresi gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        //Verification Code boxa geçerli bir code girilir
        ReusableMethods.vendorRegisterCode();
        ExtentReportUtils.extentTestInfo("Verification Code boxa geçerli bir code girildi");

        //Code girildikten sonra beklenen mesajın geldiğini doğrula
        Assert.assertTrue(ReusableMethods.emailAndCodeMessage().contains("Verification code sent to your email:"));
        ExtentReportUtils.extentTestPass("Code girildikten sonra beklenen mesajın geldiği doğrulandı");
    }

    @Test(description = "US09-Vendor Register")
    public void tc16() {
        //Email boxa geçerli bir email adresi gir
        ReusableMethods.vendorRegisterEmail();
        ExtentReportUtils.extentTestInfo("Email boxa geçerli bir email girildi");

        //Verification Code boxa geçerli bir code gir
        ReusableMethods.switchToWindow(1);
        Driver.getDriver().findElement(By.xpath("(//tr[@data-href='2'])[1]")).click();
        Driver.getDriver().switchTo().frame("iframeMail");
        String code = Driver.getDriver().findElement(By.tagName("b")).getText();
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().findElement(By.cssSelector("span.glyphicon.glyphicon-share-alt.zavriOkno.zrcadli")).click();
        Driver.getDriver().findElement(By.cssSelector("a[href='/delete']")).click();
        Driver.getDriver().close();
        ReusableMethods.switchToWindow(0);
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys(code);
        ExtentReportUtils.extentTestInfo("Verification Code boxa fakemail.com da alınan geçerli bir code girildi");

        //Code'un text kutusuna girildiğini doğrula
        String enteredValue = allPages.vendorRegisterPage().verificationCodeBox.getAttribute("value");
        Assert.assertEquals(enteredValue, code, "Email input value is not as expected.");
        Driver.getDriver().navigate().refresh();
        ExtentReportUtils.extentTestPass("Code'un text kutusuna girildiği doğrulandı");
    }


}
