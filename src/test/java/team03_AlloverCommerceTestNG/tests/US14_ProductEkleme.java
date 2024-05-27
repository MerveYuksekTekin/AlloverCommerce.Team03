package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.time.Instant;

public class US14_ProductEkleme {
    Pages allPages = new Pages();
     ReusableMethods resuable = new ReusableMethods();


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
        //Ürün Fotografı Eklemek için Sağ Tarafta ki Resim Ekleme Çerçevesine Tıkla
       allPages.vendorProductManagerPage().uploadPhoto.click();
        //Resim Eklemek için SELECT FILES'a Tıkla
        allPages.vendorProductManagerPage().selectFiles.click();
        //Acilan pencereden masaustune tikla

        String filePath = "C:User\\Gebruiker\\oneDrive\\Masaustu\\logo_360.png";
        resuable.uploadFilePath(filePath);


        allPages.vendorProductManagerPage().selectButton.click();
        //Eklemek istedigi resmin ustune tiklar

        //Eklemek istediği Resmi Seçip Aç Button'nuna Tıkla
        //Eklediği Resmin Üstüne Tıkla ve Sağ Alt Tarafta ki SELECT Botton'una Tıkla
        //Eklenen Resmin Eklendiğini Doğrula
    }

    @Test
    public void test07() {
        //Product Title'a bir veri gir
        allPages.vendorProductManagerPage().productTitle.sendKeys("Ali");
        //Short Description'a bir veri gir
        



       // Description'a bir veri gir

       // Product Title, Short Description ve Descriptiona yazi yazılabildigini dogrula

    }
}



