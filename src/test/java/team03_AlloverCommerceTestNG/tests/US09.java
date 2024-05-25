package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class US09 {

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

       // Email boxa geçerli bir email gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.fakemail.net/");
        String email=Driver.getDriver().findElement(By.id("email")).getText();
        allPages.vendorRegisterPage().emailBox.sendKeys(email);
       // Verification Code boxa geçerli bir code gir
       // Password boxa geçerli bir veri gir
       // Confirm Password boxa aynı passwordu tekrar gir
       // Register butonuna tıkla
       // Giriş yapıldığını doğrula
    }

    @Test
    public void tc02() {
    }
    @Test
    public void tc03() {
    }
    @Test
    public void tc04() {
    }
    @Test
    public void tc05() {
    }
    @Test
    public void tc06() {
    }
    @Test
    public void tc07() {
    }
    @Test
    public void tc08() {
    }


}
