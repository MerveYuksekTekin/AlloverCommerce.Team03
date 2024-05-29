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
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US09_TC01_TC16_VendorRegister {

    Pages allPages = new Pages();

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

        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Welcome to Allover Commerce! yazısı göründüğünü doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().welcomeToAllevorCommerce.getText(), "Welcome to Allover Commerce!");
        Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/store-manager/\"]")).click();
        ReusableMethods.logOut();

    }

    @Test
    public void tc02() {

        // Email box boş bırakılmalı
        allPages.vendorRegisterPage().emailBox.sendKeys("");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula

Assert.assertEquals(ReusableMethods.emailAndCodeMessage(),"Email: This field is required.");


    }

    @Test
    public void tc03() {
        // Email boxa kullanıcı adı içermeyen email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("@gmail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"Please provide a valid email address.");

    }

    @Test
    public void tc04() {
        // Email boxa @ işareti içermeyen email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("abcdgmail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"Please provide a valid email address.");
    }

    @Test
    public void tc05() {
        // Email boxa iki @ işaretli bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@@gmail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");
    }

    @Test
    public void tc06() {
        // Email boxa domain içermeyen bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"Please provide a valid email address.");
    }

    @Test
    public void tc07() {
        // Email boxa kullanıcı adı space içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asd f@gmail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");

    }

    @Test
    public void tc08() {
        // Email boxa domaini space içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@g mail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");
    }

    @Test
    public void tc09() {
        // Email boxa kullanıcı adı sembol içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("as#df@gmail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");


    }

    @Test
    public void tc10() {
        //Email boxa domaini sembol içeren bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@gm#ail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");
    }

    @Test
    public void tc11() {
        //Email boxa nokta ile başlayan bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys(".asdf@gmail.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"Email verification code invalid.");

    }

    @Test
    public void tc12() {
        //Email boxa nokta ile biten bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@gmail.com.");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");
    }

    @Test
    public void tc13() {
        //Email boxa top level domainsiz bir email gir
        allPages.vendorRegisterPage().emailBox.sendKeys("asdf@gmail");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("14785");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        //Kayıt işleminin gerçekleşmediği doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"Please provide a valid email address.");

    }

    @Test
    public void tc14() {
        //Email boxa geçerli bir email adresi gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.fakemail.net/");
        String email=Driver.getDriver().findElement(By.id("email")).getText();
        Driver.getDriver().close();
        ReusableMethods.switchToWindow(0);
        allPages.vendorRegisterPage().emailBox.sendKeys(email);

        //Email adresinin girildiğini doğrula
        Assert.assertNotNull(allPages.vendorRegisterPage().emailBox);
    }

    @Test
    public void tc15() {
        //Email boxa geçerli bir email adresi gir
        ReusableMethods.vendorRegisterEmail();
        //Verification Code boxa geçerli bir code girilir
        ReusableMethods.vendorRegisterCode();
        //Code girildikten sonra beklenen mesajın geldiğini doğrula
        Assert.assertTrue(ReusableMethods.emailAndCodeMessage().contains("Verification code sent to your email:"));
    }

    @Test
    public void tc16() {
        //Email boxa geçerli bir email adresi gir
        ReusableMethods.vendorRegisterEmail();
        //Verification Code boxa geçerli bir code gir
        ReusableMethods.switchToWindow(1);
        Driver.getDriver().findElement(By.xpath("(//tr[@data-href='2'])[1]")).click();
        // Driver.getDriver().findElement(By.xpath("(//tr[@data-href='2'])[1]")).click();
        Driver.getDriver().switchTo().frame("iframeMail");
        String code=Driver.getDriver().findElement(By.tagName("b")).getText();
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().findElement(By.cssSelector("span.glyphicon.glyphicon-share-alt.zavriOkno.zrcadli")).click();
        Driver.getDriver().findElement(By.cssSelector("a[href='/delete']")).click();

        Driver.getDriver().close();
        ReusableMethods.switchToWindow(0);
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys(code);
        //Code'un text kutusuna girildiğini doğrula
        String enteredValue = allPages.vendorRegisterPage().verificationCodeBox.getAttribute("value");
        Assert.assertEquals(enteredValue, code, "Email input value is not as expected.");
        Driver.getDriver().navigate().refresh();
    }

    @Test
    public void tc17() {
        //Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        //Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        //Password boxa küçük harf, büyük harf,rakam ve special karakter içeren bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        //Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        //Giriş yapıldığını doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().welcomeToAllevorCommerce.getText(), "Welcome to Allover Commerce!");
    }

    @Test
    public void tc18() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        // Password boxa veri girme
        allPages.vendorRegisterPage().passwordBox.sendKeys("");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Password kutusu boş bıraktığında kayıt işlemi gerçekleşmediğini doğrula

        Assert.assertTrue(ReusableMethods.passwordWrongMessage().contains("Password: This field is required."));
    }

    @Test
    public void tc19() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        // Password boxa küçük harf içermeyip, büyük harf,rakam ve special karakter içeren bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("AS1.AS1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("AS1.AS1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Password boxa küçük harf içermeyip, büyük harf,rakam ve special karakter içermeyen veri girildiğinde kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
    }

    @Test
    public void tc20() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        // Password boxa küçük harf , rakam ve special karakter içerip ,büyük harf içermeyen bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("as1.as1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("as1.as1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Password boxa küçük harf , rakam ve special karakter içerip ,büyük harf içermeyen bir veri girildiğinde kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");

    }

    @Test
    public void tc21() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        // Password küçük harf , büyük harf ve special karakter içerip ,rakam içermeyen bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As.As.");
        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As.As.");
        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        // Password küçük harf , büyük harf ve special karakter içerip ,rakam içermeyen bir veri girdiğimizde kayıt işleminin gerçekleşmediğini doğrula

        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"Password strength should be atleast \"Good\".", "Email input value is not as expected.");

    }

    @Test
    public void tc22() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        // Password boxa küçük harf , büyük harf ve rakam içerip ,special karakter içermeyen veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1As1");
        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1As1");
        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        // Password boxa küçük harf , büyük harf ve rakam içerip ,special karakter içermeyen bir veri girdiğinde kayıt işleminin gerçeklemediğini doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
    }

    @Test
    public void tc23() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");
        // Passwordun tekrar yazıldığını doğrula

        Assert.assertNotNull(allPages.vendorRegisterPage().confirmPasswordBox);
    }

    @Test
    public void tc24() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();
        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();
        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");
        // Confirm Password boxu boş bırak
        allPages.vendorRegisterPage().passwordBox.sendKeys("");
// Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        // Confim Password box boş bırakıldığında kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertEquals(ReusableMethods.passwordWrongMessage(),"Confirm Password: This field is required.");
    }

    @Test
    public void tc25() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa farklı veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // Confim Password box'a geçersiz veri girildiğinde kayıt işleminin gerçekleşmediğini doğrula
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String dynamicText = (String) jsExecutor.executeScript(
                "return document.querySelector('.wcfm-message.wcfm-error').textContent;");
        Assert.assertEquals(dynamicText,"Confirm Password: This field is required.");

    }

    @Test
    public void tc26() {
        // Email boxa geçerli bir email gir
        ReusableMethods.vendorRegisterEmail();

        // Verification Code boxa geçerli bir code gir
        ReusableMethods.vendorRegisterCode();

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıklayarak vendor olarak kaydın tamamlandığını doğrula
        Assert.assertTrue(allPages.vendorRegisterPage().registerButton.isDisplayed());
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);
        Assert.assertEquals(allPages.vendorRegisterPage().welcomeToAllevorCommerce.getText(), "Welcome to Allover Commerce!");

    }

    @Test
    public void tc27() {
        // Email boxa kayıtlı veri gir
        allPages.vendorRegisterPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Verification Code boxa geçerli bir code gir
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys("12345");

        // Password boxa geçerli bir veri gir
        allPages.vendorRegisterPage().passwordBox.sendKeys("As1.As1.");

        // Confirm Password boxa aynı passwordu tekrar gir
        allPages.vendorRegisterPage().confirmPasswordBox.sendKeys("As1.As1.");

        // Register butonuna tıkla
        ReusableMethods.click(allPages.vendorRegisterPage().registerButton);

        // "This Email already exists. Please login to the site and apply as vendor." mesajının alındığını doğrula
        Assert.assertEquals(allPages.vendorRegisterPage().emailWrongText.getText(),"This Email already exists. Please login to the site and apply as vendor.");

    }

    @AfterMethod
    public void tearDown() {


    }
}
