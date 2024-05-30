package team03_AlloverCommerceTestNG.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.P1_HomePage;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import static team03_AlloverCommerceTestNG.utilities.ReusableMethods.allPages;

public class US01_UserRegister {
    Pages allPages = new Pages();
    @Test
    public void testUS01TC02() {
        
      
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        
        
        //Register linkine tıkla
//allPages.homePage().registerButton.submit();
        ReusableMethods.click(allPages.homePage().registerButton);
// Username alanına bir veri gir
       Faker faker = new Faker();
       String us01 =faker.name().username();
       
        allPages.homePage().username.sendKeys(faker.name().username());
        
        //
      //  Your Email address alanına bir veri gir
        allPages.homePage().YourEmailaddress.sendKeys("");
     //   Password alanına bir veri gir
        allPages.homePage().password.sendKeys("!\"£$%^&");
        
   //     I agree to the privacy policy kontrol kutusunu seç
        allPages.homePage().policybox.click();
        
        
        //SIGN UP butonuna tıkla
        allPages.homePage().SignUp.click();
        
        
    //Kayıt işleminin gerçekleşmediğini doğrula
//Assert.assertEquals("Sign Out","Assert.assertEquals(allPages.homePage().signInButton");
    String passwordMessage =allPages.homePage().password.getText();
    Assert.assertEquals(passwordMessage,"signOutButton");
    
    
    }
}
