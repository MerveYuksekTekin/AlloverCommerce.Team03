package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;




public class US14_ProductEkleme {
    Pages allPages = new Pages();
    ReusableMethods resuable = new ReusableMethods();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("wynton.eamon@floodouts.com", "dvbre3X@");
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

        String filePath = "C:\\Users\\Gebruiker\\OneDrive\\Masaüstü\\logo_360.png";
        resuable.uploadFilePath(filePath);


        allPages.vendorProductManagerPage().selectButton.click();
        ReusableMethods.waitForSecond(3);

        //Eklenen Resmin Eklendiğini Doğrula
        // Assert.assertTrue(allPages.vendorProductManagerPage().imageverify.isDisplayed());

        String imgSrc = allPages.vendorProductManagerPage().imageverify.getAttribute("src");

        // Beklenen src değeri ile karşılaştırma (örnek olarak)
       // String expectedSrc = "https://allovercommerce.com/wp-content/uploads/2024/05/logo_360-6.png";
        String expectedPartialSrc = "/wp-content/uploads/2024/05/logo_360";

        // imgSrc içinde expectedPartialSrc'nin bulunduğunu doğrula
        Assert.assertTrue(imgSrc.contains(expectedPartialSrc), "Resim doğrulaması başarısız oldu. Eklenen resim doğru değil.");


    }


    @Test
    public void test06() {

        //Ürün Fotografı Eklemek için Sağ Tarafta ki kucuk Resim Ekleme Çerçevesine Tıkla
        ReusableMethods.click(allPages.vendorProductManagerPage().uploadsmallphoto);
        ReusableMethods.waitForSecond(2);

       // Cikan Upload Filese tikla
        ReusableMethods.click( allPages.vendorProductManagerPage().selectFiles);



       // Resim Eklemek için SELECT FILES'a Tıkla
        String filePath = "C:\\Users\\Gebruiker\\OneDrive\\Masaüstü\\logo_360.png";
        resuable.uploadFilePath(filePath);


        ReusableMethods.waitForSecond(3);
         ReusableMethods.click( allPages.vendorProductManagerPage().addGalleryButton);

        //Eklenen Resmin Eklendiğini Doğrula
        String imgSrc1 = allPages.vendorProductManagerPage().uploadsmallphoto.getAttribute("src");

        String expectedPartialSrc1 = "/wp-content/uploads/2024/05/logo_360";
        Assert.assertTrue(imgSrc1.contains(expectedPartialSrc1), "Resim doğrulaması başarısız oldu. Eklenen resim doğru değil.");



    }

    @Test
    public void test07() {


        //Product Title'a bir veri gir
        allPages.vendorProductManagerPage().productTitle.sendKeys("Ali", Keys.ENTER);

        Assert.assertTrue(allPages.vendorProductManagerPage().productTitle.getAttribute("class").contains("success"));
        //Short Description'a bir veri gir

        Driver.getDriver().switchTo().frame(0);
        allPages.vendorProductManagerPage().shortDes.sendKeys("nasilsn");
         Assert.assertTrue(allPages.vendorProductManagerPage().shortDes.getText().contains("nasilsn"));

        Driver.getDriver().switchTo().defaultContent(); // Frame'den çıkış
        ReusableMethods.waitForSecond(3);


        Driver.getDriver().switchTo().frame(1);
        allPages.vendorProductManagerPage().des.sendKeys("Hava nasil.");
        Assert.assertTrue(allPages.vendorProductManagerPage().des.getText().contains("Hava nasil."));
        ReusableMethods.waitForSecond(2);

        Driver.getDriver().switchTo().defaultContent();



    }

    @Test
    public void test08() {
        //Categories sec ve dogrula
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryArabalar).perform();


        WebElement categoryArabalar = allPages.vendorProductManagerPage().categoryArabalar;
        categoryArabalar.click();
        Assert.assertTrue(categoryArabalar.isSelected());
    }

    @Test
    public void test09() {
        //+Add new category tikla
        WebElement addNewButton = allPages.vendorProductManagerPage().addNewButton;
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(addNewButton).perform();
        ReusableMethods.click(addNewButton);

        // Yeni Category için Category Name bir veri gir
        allPages.vendorProductManagerPage().categoryName.sendKeys("Bebek");
        // Parent category tikla
        WebElement parentCategoryDropdown = allPages.vendorProductManagerPage().parentCategoryButton;
        ReusableMethods.click(parentCategoryDropdown);
        WebElement parentCategoryOption = allPages.vendorProductManagerPage().parentAtli;
        ReusableMethods.click(parentCategoryOption);


        //Yeni Category için ADD Botton'una Tıkla
        WebElement addCategoryButton = allPages.vendorProductManagerPage().addCategoryButton;
        ReusableMethods.click(addCategoryButton);

        //Yeni Category eklendigni dogrula




    }

    @Test
    public void test10() {
        // Product brands sec ve dogrula
        Actions actions = new Actions(Driver.getDriver());

        actions.scrollToElement(allPages.vendorProductManagerPage().productApple).perform();

        WebElement productApple = allPages.vendorProductManagerPage().productApple;
        productApple.click();
        Assert.assertTrue(productApple.isSelected());

    }
    @Test
    public void test11() {
       // +Add new Product brands'e Tıkla
        WebElement addNewProductButton = allPages.vendorProductManagerPage().addNewProductButton;
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(addNewProductButton).perform();
        ReusableMethods.click(addNewProductButton);
        //Product brands Name bir veri gir
        allPages.vendorProductManagerPage().productName.sendKeys("Bebek");
        //Parent taxonomy bir secenek sec
        WebElement parentTaxonomyButton = allPages.vendorProductManagerPage().parentTaxonomyButton;
        ReusableMethods.click(parentTaxonomyButton);
        ReusableMethods.waitForSecond(5);
        WebElement parentCategoryOption = allPages.vendorProductManagerPage().book;
        ReusableMethods.click(parentCategoryOption);

       //ADD linkine tikla
        WebElement addParentButton = allPages.vendorProductManagerPage().addParentButton;
        ReusableMethods.click(addParentButton);


    }





    @AfterMethod
    public void tearDown() {

        ReusableMethods.userVendorLogout();
    }

}



