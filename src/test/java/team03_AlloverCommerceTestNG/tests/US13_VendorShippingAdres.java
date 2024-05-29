package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.*;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import javax.swing.*;
import java.time.Duration;


public class US13_VendorShippingAdres {
    Pages allPages = new Pages();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("wynton.eamon@floodouts.com","dvbre3X@");
        allPages.homePage().signOutButton.click();
        allPages.myAccountPage().addressesButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(allPages.vendorAddressesPage().addButton).click();
        actions.perform();





    }

    @Test
    public void test01() {


        // First Name alanına bir veri gir
        allPages.vendorAddressesPage().firstName.clear();
        allPages.vendorAddressesPage().firstName.sendKeys("Ayse");
        // Last Name alanına bir veri gir
        allPages.vendorAddressesPage().lastName.clear();
        allPages.vendorAddressesPage().lastName.sendKeys("Gul");
        // Company Name alanına bir veri gir
        allPages.vendorAddressesPage().companyName.clear();
        allPages.vendorAddressesPage().companyName.sendKeys("Adalar");
        // Country alanına bir veri gir

        allPages.vendorAddressesPage().selectCountry("Albania");
        // Street alanına bir veri gir
        allPages.vendorAddressesPage().streetName.clear();
        allPages.vendorAddressesPage().streetName.sendKeys("Ata");
        // City alanına bir veri gir
        allPages.vendorAddressesPage().cityName.clear();
        allPages.vendorAddressesPage().cityName.sendKeys("Hillogom");
        // State alanına bir veri gir
        allPages.vendorAddressesPage().selectState("Elbasan");
        // Zip Code alanına bir veri gir
        allPages.vendorAddressesPage().zipCodeName.clear();
        allPages.vendorAddressesPage().zipCodeName.sendKeys("2345");
        // Save Address butonunu tıkla
        allPages.vendorAddressesPage().saveButton.submit();

        // Address changed successfully metnini gör
       Assert.assertTrue(allPages.vendorAddressesPage().successMessage.isDisplayed());

    }


    @Test
    public void test02() {
        // First Name alanına bir veri gir
        allPages.vendorAddressesPage().firstName.clear();
        allPages.vendorAddressesPage().firstName.sendKeys("Ayse");
        // Last Name alanına bir veri gir
        allPages.vendorAddressesPage().lastName.clear();
        allPages.vendorAddressesPage().lastName.sendKeys("Gul");
        // Company Name alanına bir veri gir
        allPages.vendorAddressesPage().companyName.clear();
        allPages.vendorAddressesPage().companyName.sendKeys("Adalar");
        // Country alanına bir veri gir

        allPages.vendorAddressesPage().selectCountry("Albania");
        // Street alanına bir veri gir
        allPages.vendorAddressesPage().streetName.clear();
        allPages.vendorAddressesPage().streetName.sendKeys("Ata");
        // City alanına bir veri gir
        allPages.vendorAddressesPage().cityName.clear();
        allPages.vendorAddressesPage().cityName.sendKeys("Hillogom");
        // State alanına bir veri gir
        allPages.vendorAddressesPage().selectState("Elbasan");
        // Zip Code alanıni bos birak
        allPages.vendorAddressesPage().zipCodeName.clear();
        allPages.vendorAddressesPage().zipCodeName.sendKeys("");
        // Save Address butonunu tıkla
        allPages.vendorAddressesPage().saveButton.submit();


        Assert.assertTrue(allPages.vendorAddressesPage().zipCodeErrorMessage.isDisplayed());
    }


    @Test
    public void test03() {
        // First Name alanına bir veri gir
        allPages.vendorAddressesPage().firstName.clear();
        allPages.vendorAddressesPage().firstName.sendKeys("Ayse");
        // Last Name alanına bir veri gir
        allPages.vendorAddressesPage().lastName.clear();
        allPages.vendorAddressesPage().lastName.sendKeys("Gul");
        // Company Name alanına bir veri gir
        allPages.vendorAddressesPage().companyName.clear();
        allPages.vendorAddressesPage().companyName.sendKeys("Adalar");
        // Country alanına bir veri gir

        allPages.vendorAddressesPage().selectCountry("Albania");
        // Street alanına bir veri gir
        allPages.vendorAddressesPage().streetName.clear();
        allPages.vendorAddressesPage().streetName.sendKeys("Ata");
        // City alanıni bos birak
        allPages.vendorAddressesPage().cityName.clear();
        allPages.vendorAddressesPage().cityName.sendKeys("");
        // State alanına bir veri gir
        allPages.vendorAddressesPage().selectState("Elbasan");
        // Zip Code alanına bir veri gir
        allPages.vendorAddressesPage().zipCodeName.clear();
        allPages.vendorAddressesPage().zipCodeName.sendKeys("2345");
        // Save Address butonunu tıkla
        allPages.vendorAddressesPage().saveButton.submit();

        // Address changed successfully metnini gör
        Assert.assertTrue(allPages.vendorAddressesPage().cityErrorMessage.isDisplayed());
    }
}

