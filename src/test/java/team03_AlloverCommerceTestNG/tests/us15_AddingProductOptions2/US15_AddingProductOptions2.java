package team03_AlloverCommerceTestNG.tests.us15_AddingProductOptions2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.List;

public class US15_AddingProductOptions2 {


    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

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
        ReusableMethods.scroll(allPages.vendorProductManagerPage().menuInventory);

    }

    @Test
    public void test01() {
        //Sayfa sonunda Inventory, Shipping, Attributes, Linked, Seo, Advanced menulerinin
        // goruntulendigini dogrula

      softAssert.assertTrue(allPages.vendorProductManagerPage().menuInventory.isDisplayed());
      softAssert.assertTrue(allPages.vendorProductManagerPage().menuShipping.isDisplayed());
      softAssert.assertTrue(allPages.vendorProductManagerPage().menuAttributes.isDisplayed());
      softAssert.assertTrue(allPages.vendorProductManagerPage().menuLinked.isDisplayed());
      softAssert.assertTrue(allPages.vendorProductManagerPage().menuSEO.isDisplayed());
      softAssert.assertTrue(allPages.vendorProductManagerPage().menuAdvanced.isDisplayed());
      softAssert.assertAll();
    }
     @Test
    public void test02() {
        // Gelen sayfanin sag tarafindaki Add New butonunu tikla ve Inventory kismina git
         ReusableMethods.waitForSecond(2);
         allPages.vendorProductManagerPage().menuInventory.click();
        // SKU (Stock-keeping unit) alanina urun kodunu girilebildigini dogrula
          allPages.vendorProductManagerPage().boxSku.sendKeys("kodGeldimi");
         JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
         String script = "return arguments[0].value;";
         String actualSkuValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().boxSku);
         softAssert.assertEquals(actualSkuValue, "kodGeldimi");

        // Manage Stock? alanini isaretlenebildigini ve stok yonetiminin aktif olabildigini dogrula
         allPages.vendorProductManagerPage().boxManageStock.click();
       Assert.assertTrue(allPages.vendorProductManagerPage().boxStockQty.isDisplayed());

        // Stock Qty kismina urun adedi girilebildigini dogrula
         allPages.vendorProductManagerPage().boxStockQty.clear();
         allPages.vendorProductManagerPage().boxStockQty.sendKeys("5");
         String actualQuantityValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().boxStockQty);
         softAssert.assertEquals(actualQuantityValue, "5");

        // Allow Backorders? dropdown unda Allow seceneginin secilebildigini dogrula
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxAllowBackorders, "Allow");
         Select select =new Select(allPages.vendorProductManagerPage().boxAllowBackorders);
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Allow");

        // Allow Backorders? dropdown unda Allow, but notify customer seceneginin goruntulenebildigini ve secilebildigini dogrula
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxAllowBackorders, "Allow, but notify customer");
         softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Allow, but notify customer");

         // Allow Backorders? dropdown unda Do not Allow seceneginin goruntulenebildigini ve secilebildigini dogrula
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxAllowBackorders, "Do not Allow");
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Do not Allow");
         // Sold Individually alanini secilebildigini dogrula
         allPages.vendorProductManagerPage().boxSoldIndividually.click();
        softAssert.assertTrue(allPages.vendorProductManagerPage().boxSoldIndividually.isSelected());
        softAssert.assertAll();
    }
     @Test
    public void test03() {
         // Inventory islemelerinin gorulebilmesi icin inventory tikla
         ReusableMethods.waitForSecond(2);
         allPages.vendorProductManagerPage().menuInventory.click();
         //SKU (Stock-keeping unit) alanina urun kodu gir
         allPages.vendorProductManagerPage().boxSku.sendKeys("kodGeldimi");

        // Stock status dropdown unda  In Stock, Out of Stock ve On backorder seklinde 3 tane option oldugunu ve secilebilir olduklarini dogrula
          Select select =new Select(allPages.vendorProductManagerPage().boxStockStatus);
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxStockStatus, "In stock");
         softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("In stock"));
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxStockStatus, "Out of stock");
         softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("Out of stock"));
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxStockStatus, "On backorder");
         softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("On backorder"));

        // Sold Individually alanini goruntulenebildigini ve secilebildigini dogrula
         allPages.vendorProductManagerPage().boxSoldIndividually.click();
         softAssert.assertTrue(allPages.vendorProductManagerPage().boxSoldIndividually.isSelected());
         softAssert.assertAll();

    }
     @Test
    public void test04() {
         //Add Product sayfasinda Shipping sekmesini tikla
         ReusableMethods.waitForSecond(2);
         allPages.vendorProductManagerPage().menuShipping.click();
        // Weight alanina urun kilosunun girilebildigini dogrula
         allPages.vendorProductManagerPage().weightBox.sendKeys("43");

         JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
         String script = "return arguments[0].value;";
         String actualWeightValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().weightBox);
        softAssert.assertEquals(actualWeightValue, "43");

         //Dimensions kismina length, width ve height grilebildigini dogrula
         //length icin
         allPages.vendorProductManagerPage().lengthBox.sendKeys("10");
         String actualLengthValue =(String) js.executeScript(script, allPages.vendorProductManagerPage().lengthBox);
         softAssert.assertEquals(actualLengthValue, "10");
         // width icin
         allPages.vendorProductManagerPage().widthBox.sendKeys("5");
         String actualWidthValue =(String) js.executeScript(script, allPages.vendorProductManagerPage().widthBox);
        softAssert.assertEquals(actualWidthValue, "5");
         //heigth icin
         allPages.vendorProductManagerPage().heightBox.sendKeys("30");
         String actualHeightValue =(String) js.executeScript(script, allPages.vendorProductManagerPage().heightBox);
        softAssert.assertEquals(actualHeightValue, "30");

         //Shipping class kisminda No shipping class yazisinin gorundugunu dogrula
         String actualDefaultShippingValue = allPages.vendorProductManagerPage().dropdownShipping.getText();
         softAssert.assertTrue(actualDefaultShippingValue.equals("No shipping class"));

         //Processing Time dropdown unda 10 tane secenek oldugunu ve her birinin secilebildgini dogrula
        Select select= new Select(allPages.vendorProductManagerPage().dropdownProcessingTime);
        List<WebElement> listOfShippingTime = select.getOptions();
        softAssert.assertTrue(listOfShippingTime.size()==10);
         for (WebElement option :listOfShippingTime) {
             // Dropdown'dan her bir değeri seçme
             select.selectByVisibleText(option.getText());
             String selectedOption = select.getFirstSelectedOption().getText();

             // Seçimi doğrulama
             softAssert.assertEquals(selectedOption, option.getText(), "Yanlış seçenek seçildi: " + selectedOption);
         }
         softAssert.assertAll();



    }
     @Test
    public void test05() {
        // Add Product sayfasinda Attributes sekmesini tiklanabildigini okay
         ReusableMethods.waitForSecond(2);
        softAssert.assertTrue(allPages.vendorProductManagerPage().menuAttributes.isEnabled());
         allPages.vendorProductManagerPage().menuAttributes.click();
        // Color check boxunu secilebildigini dogrula
         allPages.vendorProductManagerPage().colorCheckBox.click();
        softAssert.assertTrue(allPages.vendorProductManagerPage().colorCheckBox.isSelected());

        // Cikan color dropboxundan urun rengini secilebildigini dogrula
        allPages.vendorProductManagerPage().colorDropdown.sendKeys("kirmizi");
         JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions =new Actions(Driver.getDriver());
         actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

         ReusableMethods.waitForSecond(2);
        // Visible on the product page checkbox unu secilebildigini onayla
         allPages.vendorProductManagerPage().visibilityCheckBox1.click();
        // Size checkboxunu secilebildigini onayla
        softAssert.assertTrue(allPages.vendorProductManagerPage().sizeCheckBox.isSelected());
        // Cikan size dropboxundan urun size ini secilebildigini dogrula
         allPages.vendorProductManagerPage().sizeDropdown.sendKeys("XL");
         actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

         String expectedSizeValue ="XL";
         String script = "return arguments[0].value;";
         String actualSizeValue = allPages.vendorProductManagerPage().sizeDropdown.getAttribute("title");
         softAssert.assertEquals(actualSizeValue, expectedSizeValue);




        // Visible on the product page checkbox unu secilebildigini onayla
         allPages.vendorProductManagerPage().visibilityCheckBox2.click();
         softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown() {
        ReusableMethods.userVendorLogout();
    }

}
