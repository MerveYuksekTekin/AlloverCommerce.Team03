package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US15_AddingProductOptions2 {


    Pages allPages = new Pages();

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
      Assert.assertTrue(allPages.vendorProductManagerPage().menuInventory.isDisplayed());
      Assert.assertTrue(allPages.vendorProductManagerPage().menuShipping.isDisplayed());
      Assert.assertTrue(allPages.vendorProductManagerPage().menuAttributes.isDisplayed());
      Assert.assertTrue(allPages.vendorProductManagerPage().menuLinked.isDisplayed());
      Assert.assertTrue(allPages.vendorProductManagerPage().menuSEO.isDisplayed());
      Assert.assertTrue(allPages.vendorProductManagerPage().menuAdvanced.isDisplayed());
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
         Assert.assertEquals(actualSkuValue, "kodGeldimi");

        // Manage Stock? alanini isaretlenebildigini ve stok yonetiminin aktif olabildigini dogrula
         allPages.vendorProductManagerPage().boxManageStock.click();
        // DIKKAT DOGRULAMA YAPILMADI>

        // Stock Qty kismina urun adedi girilebildigini dogrula
         allPages.vendorProductManagerPage().boxStockQty.clear();
         allPages.vendorProductManagerPage().boxStockQty.sendKeys("5");
         String actualQuantityValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().boxStockQty);
         Assert.assertEquals(actualQuantityValue, "5");

        // Allow Backorders? dropdown unda Allow seceneginin secilebildigini dogrula
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxAllowBackorders, "Allow");
         Select select =new Select(allPages.vendorProductManagerPage().boxAllowBackorders);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Allow");

        // Allow Backorders? dropdown unda Allow, but notify customer seceneginin goruntulenebildigini ve secilebildigini dogrula
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxAllowBackorders, "Allow, but notify customer");
         Assert.assertEquals(select.getFirstSelectedOption().getText(), "Allow, but notify customer");

         // Allow Backorders? dropdown unda Do not Allow seceneginin goruntulenebildigini ve secilebildigini dogrula
         ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().boxAllowBackorders, "Do not Allow");
         Assert.assertEquals(select.getFirstSelectedOption().getText(), "Do not Allow");
         // Sold Individually alanini secilebildigini dogrula
         allPages.vendorProductManagerPage().boxSoldIndividually.click();
        Assert.assertTrue(allPages.vendorProductManagerPage().boxSoldIndividually.isSelected());
    }
     @Test
    public void test03() {
         //Gelen sayfanin sag tarafindaki Add New butonunu tikla ve Inventory kismina git
         ReusableMethods.waitForSecond(2);
         allPages.vendorProductManagerPage().menuInventory.click();
         //SKU (Stock-keeping unit) alanina urun kodu gir
         allPages.vendorProductManagerPage().boxSku.sendKeys("kodGeldimi");
        // Stock status dropdown unda  In Stock, Out of Stock ve On backorder seklinde 3 tane option oldugunu ve secilebilir olduklarini dogrula


        // Sold Individually alanini goruntulenebildigini ve secilebildigini dogrula

    }
     @Test
    public void test04() {
         //Add Product sayfasinda Shipping sekmesini tikla
        // Weight alanina urun kilosunun girilebildigini dogrula
         //Dimensions kismina length, width ve height grilebildigini dogrula
         //Shipping class kisminda No shipping class yazisinin gorundugunu dogrula
         //Processing Time dropdown unda 10 tane secenek oldugunu ve her birinin secilebildgini dogrula

    }
     @Test
    public void test05() {
        // Add Product sayfasinda Attributes sekmesini tiklanabildigini onayla
        // Color check boxunu secilebildigini dogrula
        // Cikan color dropboxundan urun rengini secilebildigini dogrula
        // Visible on the product page checkbox unu secilebildigini onayla
        // Size checkboxunu secilebildigini onayla
        // Cikan size dropboxundan urun size ini secilebildigini dogrula
        // Visible on the product page checkbox unu secilebildigini onayla
        // ADD butonuyla yeni bi attribute eklenebildigini dogrula

    }


}
