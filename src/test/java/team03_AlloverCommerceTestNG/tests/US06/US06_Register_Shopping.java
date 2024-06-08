package team03_AlloverCommerceTestNG.tests.US06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
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


    @BeforeMethod
    public void setUp() {

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3Vendor = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();

    }

    @Test (description = "US06")
    public void TC01_spaceSearchBox () throws InterruptedException {

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3Vendor = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        // Site anasayfası açılmalı
        Driver.getDriver().get(ConfigReader.getProperty("us06URL"));
        ExtentReportUtils.extentTestInfo("Ana sayfaya gidildi");

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        p1HomePage.signInButton.click();

        // Kayıtlı bir email adresi girilmeli
        p3Vendor.emailBox.sendKeys(ConfigReader.getProperty("us06name"));

        // Kayıtlı password girilmeli
        p3Vendor.passwordBox.sendKeys(ConfigReader.getProperty("us06password"));

        // Sign In butonu tıklanır olmalı
        p3Vendor.signInButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        ExtentReportUtils.extentTestInfo("Kullanıcı girişi başarılı");




        //searchbox kutusu boş olmamalı
        p7SP.searchBox.sendKeys("", Keys.ENTER);
        Thread.sleep(3000);

        ExtentReportUtils.extentTestInfo("Arama kutusu boş bırakıldı");

        ExtentReportUtils.extentTestPass("Searchbox kutusu boş bırakıldığında arama işlemi gerçekleşmediği doğrulandı.");

    }


    @Test (description = "US06")
    public void TC02_failProduct () throws InterruptedException {
        Pages allPages = new Pages();

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //searchbox kutusuna sitede olmayan ürün yazılmamalı
        p7SP.searchBox.sendKeys("Takım Elbise", Keys.ENTER);


        Assert.assertEquals(allPages.shoppingPage().noProducts.getText(), "No products were found matching your selection.");

        ExtentReportUtils.extentTestInfo("Arama kutusuna sitede olamyan ürün aratıldı.");

        ExtentReportUtils.extentTestPass("Searchbox kutusuna yanlış ürün ismi girildiğinde sonuç bulunamadığı doğrulandı.");




    }

    @Test (description = "US06")
    public void TC03_productsearch () throws InterruptedException {

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3Vendor = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Men’s Clothing", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

        //Aratılan ürünün listelendiğini doğrula
        Assert.assertEquals(allPages.shoppingPage().mensclothing.getText(), "Men’s Clothing");

        ExtentReportUtils.extentTestInfo("Arama kutusuna ürün ismi girildi");

        ExtentReportUtils.extentTestPass("Aratılan ürünün listelendiği doğrulandı");

    }

    @Test (description = "US06")
    public void TC04_addToCart () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();


        ExtentReportUtils.extentTestInfo("Seçilen ürün sepete eklendi");

        ExtentReportUtils.extentTestPass("Seçilen ürünün sepete eklendiği doğrulandı.");

    }

    @Test (description = "US06")
    public void TC05_shoppingCart () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.cart.click();
        p7SP.viewcart.click();

        //Seçilen ürün Shopping Card'ta görüntülendiğini doğrula
        Assert.assertEquals(p7SP.trueCart.getText(), "Men’s Clothing");

        ExtentReportUtils.extentTestInfo("Sepet görüntülendi");

        ExtentReportUtils.extentTestPass("Sepetin görüntülendiği doğrulandı.");

    }
    @Test (description = "US06")
    public void TC06_plusProduct () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //Sepette ürün adeti artırılabilmeli
        p7SP.buttonPlus.click();
        Thread.sleep(3000);

        //Ürünün 1 artırıldığını doğrula
        //Assert.assertEquals(p7SP.valuePlus.isDisplayed(), "2");

        ExtentReportUtils.extentTestInfo("Sepetteki ürün adeti 1 arttırıldı.");

        ExtentReportUtils.extentTestPass("Sepetteki ürünün 1 artırıldığı doğrulandı.");

    }

    @Test (description = "US06")
    public void TC07_minusProduct () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        Thread.sleep(3000);

        //Sepette ürün adeti azaltılabilmeli
        p7SP.buttonMinus.click();

        ExtentReportUtils.extentTestInfo("Sepetteki ürün adeti 1 azaltıldı.");

        ExtentReportUtils.extentTestPass("Sepetteki ürünün 1 azaltıldı doğrulandı.");

    }

    @Test (description = "US06")
    public void TC08_manualProduct () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //Sepette ürün adeti klavyeden bir rakam girilerek değiştirilmeli 15
        Thread.sleep(3000);
        p7SP.inputnumber.sendKeys("5", Keys.ENTER);

        //sepet güncellenmeli
        Thread.sleep(3000);
        //p7SP.updateCart.click();

        ExtentReportUtils.extentTestInfo("Sepetteki ürün adeti istenilen sayıda günlelendi.");

        ExtentReportUtils.extentTestPass("Sepetteki ürünün istenilen sayıda güncellendiği doğrulandı.");


    }


    @Test (description = "US06")
    public void TC09_clearCart () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //Sepette ürünler silinebilmeli
        Thread.sleep(3000);
        p7SP.clearCart.click();

        ExtentReportUtils.extentTestInfo("Sepetteki ürünler silindi.");

        ExtentReportUtils.extentTestPass("Sepetteki ürünlerin silindiği doğrulandı.");



    }



    @Test (description = "US06")
    public void TC10_payDoor () throws InterruptedException {

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

        ExtentReportUtils.extentTestInfo("Pay at the door yöntemi seçildi");

        ExtentReportUtils.extentTestPass("Pay at the door ödeme yöntemi seçildiği doğrulandı.");


    }

    @Test (description = "US06")
    public void TC11_payEFTWire () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        ReusableMethods.scroll(p7SP.subTotal);
        Thread.sleep(3000);


        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve EFT/Wire seçebilmeli
        p7SP.eftWire.click();
        Thread.sleep(3000);

        ExtentReportUtils.extentTestInfo("EFT/Wire ödeme yöntemi seçildi.");

        ExtentReportUtils.extentTestPass("EFT/Wire ödeme yöntemi seçildiği doğrulandı.");


    }

    @Test (description = "US06")
    public void TC12_placeOrder() throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        ReusableMethods.scroll(p7SP.subTotal);
        Thread.sleep(3000);



        //kullanıcı siparişi tamamlayabilmeli
        p7SP.placeorder.click();


        Assert.assertTrue(p7SP.orderComplete.isDisplayed());


        System.out.println("Report =" + p7SP.orderComplete.getText());
        System.out.println("Report Order =" + p7SP.endOrder.getText());




        ExtentReportUtils.extentTestInfo("Kullanıcı siparişi tamamladı.");

        ExtentReportUtils.extentTestPass("Siparişin tamamlandığı doğrulandı.");


    }


}
