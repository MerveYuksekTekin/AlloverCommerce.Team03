package team03_AlloverCommerceTestNG.tests;

import org.testng.annotations.BeforeMethod;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class US08_Register_WishList {
    Pages pages = new Pages();
    @BeforeMethod
    public void setUp() {
    //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
    //Sing In linkine tıkla
        pages.homePage().signInButton.click();
    //Username or email adress kutusuna geçerli bir email adresi gir
        pages.userVendorLoginPage().emailBox.sendKeys("kourosh.lavell@floodouts.com");
    //Password kutusuna geçerli bir password gir
        pages.userVendorLoginPage().passwordBox.sendKeys("Password kutusuna geçerli bir password gir");
    //SING IN butonuna tıkla
        pages.userVendorLoginPage().signInButton.click();
    //Search kutusuna tıkla
        System.out.println();


    }
}
