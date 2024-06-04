package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.P1_HomePage;
import team03_AlloverCommerceTestNG.pages.P3_UserVendorLoginPage;
import team03_AlloverCommerceTestNG.pages.P7_ShoppingPage;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;


public class US06_Register_Shopping {

    Pages allPages = new Pages();


    @Test
    public void TC01_spaceSearchBox () throws InterruptedException {

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3Vendor = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        // Site anasayfası açılmalı
        Driver.getDriver().get(ConfigReader.getProperty("us06URL"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        p1HomePage.signInButton.click();

        // Kayıtlı bir email adresi girilmeli
        p3Vendor.emailBox.sendKeys(ConfigReader.getProperty("us06name"));

        // Kayıtlı password girilmeli
        p3Vendor.passwordBox.sendKeys(ConfigReader.getProperty("us06password"));

        // Sign In butonu tıklanır olmalı
        p3Vendor.signInButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        //searchbox kutusu boş olmamalı
        p7SP.searchBox.sendKeys("", Keys.ENTER);
        Thread.sleep(3000);
        ExtentReportUtils.extentTestInfo("Arama kutusu boş olmamalı");

    }


    @Test
    public void TC02_failProduct () throws InterruptedException {


        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //searchbox kutusu boş olmamalı
        p7SP.searchBox.sendKeys("Takım Elbise", Keys.ENTER);

    }

    @Test
    public void TC03_productsearch () throws InterruptedException {

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3Vendor = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Men’s Clothing", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

    }

    @Test
    public void TC04_addToCart () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();

    }

    @Test
    public void TC05_shoppingCart () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.cart.click();
        p7SP.viewcart.click();

    }
    @Test
    public void TC06_plusProduct () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);


        //Sepette ürün adeti artırılabilmeli
        p7SP.buttonPlus.click();

    }

    @Test
    public void TC07_minusProduct () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //Sepette ürün adeti azaltılabilmeli
        p7SP.buttonMinus.click();

    }

    @Test
    public void TC08_manualProduct () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //Sepette ürün adeti klavyeden bir rakam girilerek değiştirilmeli 15
        Thread.sleep(3000);
        p7SP.inputnumber.sendKeys("5", Keys.ENTER);


        //sepet güncellenmeli
        Thread.sleep(3000);
        //p7SP.updateCart.click();


    }


    @Test
    public void TC09_clearCart () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //Sepette ürünler silinebilmeli
        Thread.sleep(3000);
        p7SP.clearCart.click();

    }



    @Test
    public void TC10_paymentMethods () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Men’s Clothing", Keys.ENTER);


        //Seçilen ürün sepete eklenebilmeli
        Thread.sleep(3000);
        p7SP.addTocart.click();


        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();
        p7SP.viewcart.click();

        //sipariş kontrol edilmeli
        p7SP.checkout.click();

        ReusableMethods.scroll(p7SP.subTotal);
        Thread.sleep(3000);

        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve pay at the door seçebilmeli
        p7SP.paydoor.click();
        Thread.sleep(3000);

    }

    @Test
    public void TC11_paymentMethods2 () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        ReusableMethods.scroll(p7SP.subTotal);
        Thread.sleep(3000);


        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve EFT/Wire seçebilmeli
        p7SP.eftWire.click();
        Thread.sleep(3000);

    }

    @Test
    public void TC12_placeOrder() throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        ReusableMethods.scroll(p7SP.subTotal);
        Thread.sleep(3000);

        //kullanıcı farklı adres kutusunu görebilmeli ve tıklayabilmeli
        p7SP.differentAddress.sendKeys(Keys.TAB);
        Thread.sleep(3000);

        //kullanıcı siparişi tamamlayabilmeli
        p7SP.placeorder.click();


        Assert.assertTrue(p7SP.orderComplete.isDisplayed());


        System.out.println("Report =" + p7SP.orderComplete.getText());
        System.out.println("Report Order =" + p7SP.endOrder.getText());


    }


}
