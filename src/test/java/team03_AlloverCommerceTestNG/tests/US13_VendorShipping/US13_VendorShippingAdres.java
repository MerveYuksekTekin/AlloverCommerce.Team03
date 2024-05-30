package team03_AlloverCommerceTestNG.tests.US13_VendorShipping;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;


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

    @Test(description = "US13")
    public void test01() {


        // First Name alanına bir veri gir
        allPages.vendorAddressesPage().firstName.clear();
        allPages.vendorAddressesPage().firstName.sendKeys("Ayse");
        ExtentReportUtils.extentTestInfo(" First Name alanına bir veri girildi");

        // Last Name alanına bir veri gir
        allPages.vendorAddressesPage().lastName.clear();
        allPages.vendorAddressesPage().lastName.sendKeys("Gul");
        ExtentReportUtils.extentTestInfo(" Last Name alanına bir veri girildi");

        // Company Name alanına bir veri gir
        allPages.vendorAddressesPage().companyName.clear();
        allPages.vendorAddressesPage().companyName.sendKeys("Adalar");
        ExtentReportUtils.extentTestInfo(" Company alanına bir veri girildi");

        // Country alanına bir veri gir
        allPages.vendorAddressesPage().selectCountry("Albania");
        ExtentReportUtils.extentTestInfo(" Country alanına bir veri girildi");

        // Street alanına bir veri gir
        allPages.vendorAddressesPage().streetName.clear();
        allPages.vendorAddressesPage().streetName.sendKeys("Ata");
        ExtentReportUtils.extentTestInfo(" Street alanına bir veri girildi");

        // City alanına bir veri gir
        allPages.vendorAddressesPage().cityName.clear();
        allPages.vendorAddressesPage().cityName.sendKeys("Hillogom");
        ExtentReportUtils.extentTestInfo(" City alanına bir veri girildi");

        // State alanına bir veri gir
        allPages.vendorAddressesPage().selectState("Elbasan");
        ExtentReportUtils.extentTestInfo(" State alanına bir veri girildi");

        // Zip Code alanına bir veri gir
        allPages.vendorAddressesPage().zipCodeName.clear();
        allPages.vendorAddressesPage().zipCodeName.sendKeys("2345");
        ExtentReportUtils.extentTestInfo(" Zip Code alanına bir veri girildi");

        // Save Address butonunu tıkla
        allPages.vendorAddressesPage().saveButton.submit();
        ExtentReportUtils.extentTestInfo(" Save Address butonunu tıklanildi");


        // Address changed successfully metnini gör
       Assert.assertTrue(allPages.vendorAddressesPage().successMessage.isDisplayed());
       ExtentReportUtils.extentTestPass("Address changed successfully metnini göruldu");

    }


    @Test(description = "US13")
    public void test02() {
        // First Name alanına bir veri gir
        allPages.vendorAddressesPage().firstName.clear();
        allPages.vendorAddressesPage().firstName.sendKeys("Ayse");
        ExtentReportUtils.extentTestInfo(" First Name alanına bir veri girildi");

        // Last Name alanına bir veri gir
        allPages.vendorAddressesPage().lastName.clear();
        allPages.vendorAddressesPage().lastName.sendKeys("Gul");
        ExtentReportUtils.extentTestInfo(" Last Name alanına bir veri girildi");

        // Company Name alanına bir veri gir
        allPages.vendorAddressesPage().companyName.clear();
        allPages.vendorAddressesPage().companyName.sendKeys("Adalar");
        ExtentReportUtils.extentTestInfo("Company alanına bir veri girildi");

        // Country alanına bir veri gir
        allPages.vendorAddressesPage().selectCountry("Albania");
        ExtentReportUtils.extentTestInfo(" Country alanına bir veri girildi");

        // Street alanına bir veri gir
        allPages.vendorAddressesPage().streetName.clear();
        allPages.vendorAddressesPage().streetName.sendKeys("Ata");
        ExtentReportUtils.extentTestInfo(" Zip Code alanına bir veri girildi");

        // City alanına bir veri gir
        allPages.vendorAddressesPage().cityName.clear();
        allPages.vendorAddressesPage().cityName.sendKeys("Hillogom");
        ExtentReportUtils.extentTestInfo(" City alanına bir veri girildi");

        // State alanına bir veri gir
        allPages.vendorAddressesPage().selectState("Elbasan");
        ExtentReportUtils.extentTestInfo(" State alanına bir veri girildi");

        // Zip Code alanıni bos birak
        allPages.vendorAddressesPage().zipCodeName.clear();
        allPages.vendorAddressesPage().zipCodeName.sendKeys("");
        ExtentReportUtils.extentTestInfo(" Zip Code alanına bir veri girilmedi");

        // Save Address butonunu tıkla
        allPages.vendorAddressesPage().saveButton.submit();
        ExtentReportUtils.extentTestInfo(" Save Address butonunu tıklanildi");


        Assert.assertTrue(allPages.vendorAddressesPage().zipCodeErrorMessage.isDisplayed());
        ExtentReportUtils.extentTestPass("Address changed successfully metnini görulmedi");
    }


    @Test
    public void test03() {
        // First Name alanına bir veri gir
        allPages.vendorAddressesPage().firstName.clear();
        allPages.vendorAddressesPage().firstName.sendKeys("Ayse");
        ExtentReportUtils.extentTestInfo(" First Name alanına bir veri girildi");

        // Last Name alanına bir veri gir
        allPages.vendorAddressesPage().lastName.clear();
        allPages.vendorAddressesPage().lastName.sendKeys("Gul");
        ExtentReportUtils.extentTestInfo(" Last Name alanına bir veri girildi");

        // Company Name alanına bir veri gir
        allPages.vendorAddressesPage().companyName.clear();
        allPages.vendorAddressesPage().companyName.sendKeys("Adalar");
        ExtentReportUtils.extentTestInfo(" Company alanına bir veri girildi");

        // Country alanına bir veri gir
        allPages.vendorAddressesPage().selectCountry("Albania");
        ExtentReportUtils.extentTestInfo(" Country alanına bir veri girildi");

        // Street alanına bir veri gir
        allPages.vendorAddressesPage().streetName.clear();
        allPages.vendorAddressesPage().streetName.sendKeys("Ata");
        ExtentReportUtils.extentTestInfo(" Street alanına bir veri girildi");

        // City alanıni bos birak
        allPages.vendorAddressesPage().cityName.clear();
        allPages.vendorAddressesPage().cityName.sendKeys("");
        ExtentReportUtils.extentTestInfo(" Company alanına bir veri girilmedi");

        // State alanına bir veri gir
        allPages.vendorAddressesPage().selectState("Elbasan");
        ExtentReportUtils.extentTestInfo(" State alanına bir veri girildi");

        // Zip Code alanına bir veri gir
        allPages.vendorAddressesPage().zipCodeName.clear();
        allPages.vendorAddressesPage().zipCodeName.sendKeys("2345");
        ExtentReportUtils.extentTestInfo(" Zip Code alanına bir veri girildi");

        // Save Address butonunu tıkla
        allPages.vendorAddressesPage().saveButton.submit();
        ExtentReportUtils.extentTestInfo(" Save Address butonunu tıklanildi");

        // Address changed successfully metnini gör
        Assert.assertTrue(allPages.vendorAddressesPage().cityErrorMessage.isDisplayed());
        ExtentReportUtils.extentTestPass("Address changed successfully metnini görulmedi");


    }

    @AfterMethod
    public void tearDown() {

          ReusableMethods.userVendorLogout();
    }



}

