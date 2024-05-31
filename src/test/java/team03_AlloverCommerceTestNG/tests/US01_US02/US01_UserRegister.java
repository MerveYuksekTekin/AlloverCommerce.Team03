package team03_AlloverCommerceTestNG.tests.US01_US02;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US01_UserRegister {
    Pages allPages = new Pages();
    public void testUS01TC02(){
        
      
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
      // Username alanına bir veri gir
       Faker faker = new Faker();
       String us01 =faker.name().username();
       String usEmail = faker.name().username();
       
        allPages.homePage().username.sendKeys(faker.name().username());
        
      //  Your Email address alanına bir veri gir
     allPages.homePage().YourEmailaddress.sendKeys( faker.internet().emailAddress());
     //   Password alanı bos birakilmali
        allPages.homePage().password.sendKeys("                       ");
        
   //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
    //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
    String passwordMessage =allPages.homePage().password.getText();
    Assert.assertEquals(passwordMessage,"signOutButton");
    }
    
    @Test(description = "US01TC01")
    public void test02() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //   Password alanına sayi gir.
        allPages.homePage().password.sendKeys("1234567");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test(description = "US01TC03")
    public void testTC03() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //   Password alanına sayi gir.
        allPages.homePage().password.sendKeys("aaaaaaa");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test(description = "US01TC04")
    public void testTC04() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //   Password alanına sayi gir.
        allPages.homePage().password.sendKeys("AAAAAAA");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testTC05() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //   Password alanına VERI gir.
        allPages.homePage().password.sendKeys("!\"£$%^&");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUS01TC06() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //  Password alanına rakam kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys("AAAsss\"\"\"\"**/");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUS01TC07() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //  Password alanına buyuk harf kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys("aaaas222$$");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUC01TC08() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        //  Password alanina ozel karakter kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys("aaaas2fed");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUC01TC09() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        
        
        // Password alanına güçlü bir şifre oluştur
        allPages.homePage().password.sendKeys("Awe12\"&*+##343");
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //WELCOME TO ALLOVER COMMERCE... in goruldugu  ve Sign Out linkinin göründüğünü doğrula

Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
    }
    
    @Test
    public void testTC01US10() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys("Art12#");
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        
        
        // Password alanina ozel karakter kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //WELCOME TO ALLOVER COMMERCE... in goruldugu  ve Sign Out linkinin göründüğünü doğrula

Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
    }
    
    @Test
    public void testUS01TC11() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        
        // Username alanına sadece  sayi karakteri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys("516464151");
        
        //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        
        
        // Password alanina ozel karakter kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUS01TC12() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address kutucuguna '@' simgesinden  sonra ( - )veya ( . ) harici özel karakterli bir mail gir
        allPages.homePage().YourEmailaddress.sendKeys("derse rl@mail.com");
        
        
        // Password alanina ozel karakter kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testTC01UC13() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address alanına dersleer@ders formatinda bir email gir.
        allPages.homePage().YourEmailaddress.sendKeys("dersleer@ders");
        
        
        //Password alanına gecerli password girilir
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUS01TC14() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //  Your Email address kutucuguna '@' alanina '@@' gir.
        allPages.homePage().YourEmailaddress.sendKeys("dersler@@mail.com");
        
        
        //Password alanına gecerli password girilir
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUS01TC15() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys(faker.name().username());
        
        // Your Email address kutucuguna '@' dan once sayi ve harf gir.
        allPages.homePage().YourEmailaddress.sendKeys("12dersler@@mail.com");
        
        
        //Password alanina ozel karakter kullanmadan sifre olustur.
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }
    
    @Test
    public void testUS01TC16() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        
        // Username alanına bir veri gir
        Faker faker = new Faker();
        String us01 = faker.name().username();
        String usEmail = faker.name().username();
        allPages.homePage().username.sendKeys(faker.name().username());
        
        // Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys(faker.internet().emailAddress());
        
        
        //Password alanına güçlü bir şifre oluştur
        allPages.homePage().password.sendKeys(faker.internet().password());
        
        
        //     I agree to the privacy policy kontrol kutusunu tiklama
        // allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
    }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 



