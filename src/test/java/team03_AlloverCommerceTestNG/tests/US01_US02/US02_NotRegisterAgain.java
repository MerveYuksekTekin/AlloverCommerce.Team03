package team03_AlloverCommerceTestNG.tests.US01_US02;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US02_NotRegisterAgain {
    Pages allPages = new Pages();
    
 
    @Test
    public void testUS02TC01() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanina kayitli olmayan bir username gir
        Faker faker = new Faker();
        String Email = faker.internet().emailAddress();
        String username = faker.name().username();
        String password = faker.internet().password();
        
        allPages.homePage().username.sendKeys(username);
        
        
        //Your Email address alanina kayitli bir email adresi gir
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
       // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC02() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanina username i gir basina ve sonuna space karakteri ekle
        
        allPages.homePage().username.sendKeys("      ceneleme     ");
        
        
        //     Your Email address alanina bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC03() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanina bos birakilmali
        
        allPages.homePage().username.sendKeys("         ");
        
        
        //     Your Email address alanina gecerli email gir.
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC04() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanina kayitli bir username gir
        
        allPages.homePage().username.sendKeys("ceneleme");
        
        
        // Your Email address alanina kayitli olmayan bir email adresi gir
        Faker faker = new Faker();
        String Email = faker.internet().emailAddress();
        allPages.homePage().YourEmailaddress.sendKeys(Email);
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC05() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanina bos birakilmali
        
        allPages.homePage().username.sendKeys("         ");
        
        
        // Your Email address alanina bir veri gir
        
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    @Test
    public void testUS02TC06() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanına bir veri gir
        allPages.homePage().username.sendKeys("ceneleme");
        
        
        //Your Email address bolumunde @  alanina iki kez @ gir
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@@jollyfree.com");
        
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC07() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        //Username alani bir veri gir.
        
        allPages.homePage().username.sendKeys("ceneleme");
        
        
        // Your Email address alanina mailin sonuna @ gir.
        
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com@");
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //  I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC08() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        //Username alanina kayitli Username i girin
        allPages.homePage().username.sendKeys("ceneleme");
        
        
        // Your Email address alanina +, ",/,*,#,!,   ozel karakterker  giriniz
        
        allPages.homePage().YourEmailaddress.sendKeys("cen*eleme.egagunub@jollyfree.com@");
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //  I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC09() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        //Username alanina kayitli Username i girin
        allPages.homePage().username.sendKeys("ceneleme");
        
        //Your Email address alanina gecerli adres girilmeli
        
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //  I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC10() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        //Username alanina kayitli Username i girin
        allPages.homePage().username.sendKeys("ceneleme");
        
        //Your Email address alanina gecerli adres girilmeli
        
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        // Password alanina yanlis  bir veri girilir
        Faker faker = new Faker();
        String password = faker.internet().password();
        
        //  I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC11() {
        
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        //Username alanina kayitli Username i girin
        allPages.homePage().username.sendKeys("ceneleme");
        
        //Your Email address alanina gecerli adres girilmeli
        
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        //Password alanina dogru sifre ve ek olarak  baska karakter(ler) de girilmeli
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD123  ");
        
        //  I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
        
        String registerMessage = allPages.homePage().password.getText();
        Assert.assertEquals(registerMessage, "signOutButton");
    }
    
    @Test
    public void testUS02TC12() throws InterruptedException {
        Pages allPages = new Pages();
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        //Username alanina kayitli Username i girin
        allPages.homePage().username.sendKeys("ceneleme");
        
        //Your Email address alanina gecerli adres girilmeli
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@jollyfree.com");
        
        //Password alanina dogru sifre ve ek olarak  baska karakter(ler) de girilmeli
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD123  ");
        
        //  I agree to the privacy policy kontrol kutusunu seçme
        
        // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();

        //An account is already registered with your email address. Please log in.
        // Uyarisinin ciktigini ve tekrar SignUp pop-up penceresinin acildigini, kaydin gerceklesmedigini dogrula
       Assert.assertTrue( allPages.homePage().SignUp.isDisplayed());
        
        
        
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
  
}

