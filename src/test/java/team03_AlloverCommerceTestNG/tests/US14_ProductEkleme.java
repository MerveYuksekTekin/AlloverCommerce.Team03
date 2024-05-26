package team03_AlloverCommerceTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US14_ProductEkleme {
    Pages allPages = new Pages();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("wynton.eamon@floodouts.com","dvbre3X@");
        allPages.homePage().signOutButton.click();
        allPages.myAccountPage().storeManagerButton.click();
        allPages.vendorStoreManagerPage().productsMenu.click();
        allPages.vendorProductDashboardPage().addNewButton.click();





    }

    @Test
    public void test01() {

        //Acilan sayfada Simple Product tikla
        allPages.vendorProductManagerPage().dropdownSimpleProduct.click();
        //Simple Product yazisinin oldugunu dogrula
        Assert.assertTrue(allPages.vendorProductManagerPage().dropdownSimpleProduct.isDisplayed());
    }

    @Test
    public void test02() {
        //Acilan sayfada Simple Product tikla
        allPages.vendorProductManagerPage().dropdownSimpleProduct.click();
        //Acilan sekmede Variable Product seçenegini gor
        Assert.assertTrue(allPages.vendorProductManagerPage().dropdownVariableProduct.isDisplayed());
    }

    @Test
    public void test03() {
        //Acilan sayfada Simple Product tikla
        allPages.vendorProductManagerPage().dropdownSimpleProduct.click();
        //Acilan sekmede  Grouped Product  seçenegini gor
        Assert.assertTrue(allPages.vendorProductManagerPage().dropdownGroupedProduct.isDisplayed());
    }

    @Test
    public void test04() {
        //Acilan sayfada Simple Product tikla
        allPages.vendorProductManagerPage().dropdownSimpleProduct.click();
        //Acilan sekmede External - Affiliate Product  seçenegini gor
        Assert.assertTrue(allPages.vendorProductManagerPage().dropdownExternalProduct.isDisplayed());

    }

    @Test
    public void test05() {
        
    }
}



