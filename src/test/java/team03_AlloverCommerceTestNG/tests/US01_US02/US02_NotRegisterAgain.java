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
        public void testUS02TC01 () {
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
            String passwordMessage = allPages.homePage().password.getText();
            Assert.assertEquals(passwordMessage, "signOutButton");
        }
    
    @Test
    public void testUS02TC02() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        //Register linkine tıkla
        ReusableMethods.click(allPages.homePage().registerButton);
        
        // Username alanina kayitli olmayan bir username gir
        Faker faker = new Faker();
        String username = faker.name().username();
        String Email = faker.internet().emailAddress();
        String password=faker.internet().password();
        allPages.homePage().username.sendKeys(username);
        
        
        //Your Email address bolumunde @  alanina iki kez @ gir
        allPages.homePage().YourEmailaddress.sendKeys("ceneleme.egagunub@@jollyfree.com");
        
        
        // Password alanina kayitli password'u gir
        allPages.homePage().password.sendKeys("KrrN7!UXmg_HD ");
        
        //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
       // SIGN UP butonuna tikla
        allPages.homePage().SignUp.click();
        
        
        //Kayıt işleminin gerçekleşmedigini doğrula
        String passwordMessage = allPages.homePage().password.getText();
        Assert.assertEquals(passwordMessage, "signOutButton");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
