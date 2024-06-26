package team03_AlloverCommerceTestNG.tests.us16_addSimpleProducts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

public class US16_AddSimpleProduct {

    Pages allPages = new Pages();
    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void setUp() {
        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        // Kayitli vendor bilgileriyle giris yap
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("bert.emit@floodouts.com", "wrgyx9K?");

        // Sign out a tiklayarak My account sayfasina gir
        allPages.homePage().signOutButton.click();
        //Sol taraftaki listeden Store Manager i tikla
        allPages.myAccountPage().storeManagerButton.click();
        // My Store kisminda Products i tikla
        ReusableMethods.scroll(allPages.vendorStoreManagerPage().productsMenu);
        ReusableMethods.waitForSecond(2);
        allPages.vendorStoreManagerPage().productsMenu.click();
        // Gelen sayfanin sag tarafindaki Add New butonunu tikla
        allPages.vendorProductDashboardPage().addNewButton.click();

    }

    @Test
    public void test01() {


       // Add Product sayfasindaki ilk dropdown menusunde Simple Product seceneginin default olarak gorundugunu dogrula
       Select select = new Select(allPages.vendorProductManagerPage().dropdownSimpleProduct);
       String actualDefaultOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDefaultOption, "Simple Product");

    }

    @Test
    public void test02() {

        //Virtual ve Downloadable checkbox larini sec
       WebElement virtualCheckBox  = allPages.vendorProductManagerPage().virtualCheckBox;
        ReusableMethods.scroll(virtualCheckBox);
       if(!virtualCheckBox.isSelected()){
           virtualCheckBox.click();
       }

       WebElement downloadableCheckBox = allPages.vendorProductManagerPage().downloadableCheckBox;
        if(!downloadableCheckBox.isSelected()){
           downloadableCheckBox.click();
        }
       // Virtual ve Downloadable checkbox larinin secilebildigini dogrula
        softAssert.assertTrue(virtualCheckBox.isSelected());
        softAssert.assertTrue(downloadableCheckBox.isSelected());
        softAssert.assertAll();
    }

    @Test
    public void test03() {
        //Price bilgisini gir
        ReusableMethods.scroll(allPages.vendorProductManagerPage().priceBox);
        allPages.vendorProductManagerPage().priceBox.sendKeys("100");


        //Sale Price bilgisini gir
        allPages.vendorProductManagerPage().salePriceBox.sendKeys("80");

        //Price ve Sale Price bilgilerini girebildigini onayla
        String actualPrice= allPages.vendorProductManagerPage().priceBox.getText();// bos geliyo
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        softAssert.assertEquals(actualPriceValue, "100");
        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        softAssert.assertEquals(actualSalePriceValue, "80");
        softAssert.assertAll();

    }
    @Test
    public void test04() {
        //Product Title kisminda urun basliginin yazilabildigini dogrula
       allPages.vendorProductManagerPage().productTitleBox.sendKeys("Techpro QA Education");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualProductTitle = (String) js.executeScript(script, allPages.vendorProductManagerPage().productTitleBox);
        System.out.println(actualProductTitle);
        Assert.assertEquals(actualProductTitle,"Techpro QA Education" );

    }
    @Test
    public void test05() {
        //Categories kismindan istedigin bir secenegi sec
        //Categories kismindan secim yapilabildigini dogrula
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryEducation).perform();

        WebElement categoryEducation = allPages.vendorProductManagerPage().categoryEducation;
        categoryEducation.click();
        Assert.assertTrue(categoryEducation.isSelected());

    }

    @Test
    public void test06() {
       // Dropdown dan Simple Product sec
        ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().dropdownSimpleProduct, "Simple Product");
       // Virtual i sec

        ReusableMethods.scroll(allPages.vendorProductManagerPage().virtualCheckBox);
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().virtualCheckBox.click();

        //Product Title gir
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        allPages.vendorProductManagerPage().productTitleBox.sendKeys("Techpro QA Education "+randomNumber);
        //Price ve Sale Price bilgilerini gir
        allPages.vendorProductManagerPage().priceBox.sendKeys("4000");
        allPages.vendorProductManagerPage().salePriceBox.sendKeys("3000");
        //Kategori sec
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryEducation).perform();
        allPages.vendorProductManagerPage().categoryEducation.click();

       //Resim ekle
        allPages.vendorProductManagerPage().addPhotoButton.click();
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().menuLibraryButton.click();
        ReusableMethods.waitForSecond(4);
        ReusableMethods.click(allPages.vendorProductManagerPage().logoImage);
        allPages.vendorProductManagerPage().selectButton.click();

       // Galeri image ekle
        allPages.vendorProductManagerPage().addGalleryPhotoButton.click();
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().menuGalleryLibraryButton.click();
        ReusableMethods.waitForSecond(4);
        ReusableMethods.click(allPages.vendorProductManagerPage().logoGalleryImage.get(allPages.vendorProductManagerPage().logoGalleryImage.size()-1));
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().addToGalleryPhotoButton.click();

        //Submit butonuna bas
        ReusableMethods.scroll( allPages.vendorProductManagerPage().submitButton);
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().submitButton.click();

       // Soldaki menulerden Product i tikla
        ReusableMethods.waitForSecond(4);
        ReusableMethods.scroll( allPages.vendorProductManagerPage().menuProduct);
        allPages.vendorProductManagerPage().menuProduct.click();

      //  Product kisminda urunun adini gorerek eklendigini onayla
        List<WebElement> products = allPages.vendorProductManagerPage().addedProducts;
        for (WebElement product: products) {
            Assert.assertEquals("Techpro QA Education " + randomNumber, product.getText());

        }

    }


    @Test (dataProvider = "negativeDataForUS16")
    public void test07(String negativeDataForUS16){
        // Price bilgisini gir
        WebElement pricebox = allPages.vendorProductManagerPage().priceBox;
        pricebox.sendKeys(negativeDataForUS16);
        // Sale Price bilgisini gir
        WebElement salePriceBox = allPages.vendorProductManagerPage().salePriceBox;
        salePriceBox.sendKeys(negativeDataForUS16);
        //  Price kismina invalid bilgiler girilemedigini dogrula	abc, #@$,  space,
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        softAssert.assertTrue(actualPriceValue.isEmpty());
        // Sale Price kismina invalid bilgiler girilemedigini dogrula	abc, #@$,  space,
        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        softAssert.assertTrue(actualSalePriceValue.isEmpty());
       softAssert.assertAll();

    }

    @Test
    public void test08() {
        // Price bilgisini gir
       WebElement pricebox = allPages.vendorProductManagerPage().priceBox;
       pricebox.sendKeys("100");
        //Sale Price bilgisini gir
        WebElement salePriceBox = allPages.vendorProductManagerPage().salePriceBox;
        salePriceBox.sendKeys("200");
        //Price in Sale Price tan daha kucuk olamayacagini dogrula
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        Assert.assertTrue(Integer.parseInt(actualPriceValue)>Integer.parseInt(actualSalePriceValue));

    }

    @DataProvider(name = "negativeDataForUS16")
    private static Object[][] provideInvalidTestData() {
        return new Object[][] {
                { "abc" },
                { "#@%"},
                {" "}
        };
    }
    @AfterMethod
    public void tearDown() {
          ReusableMethods.userVendorLogout();
    }
}
