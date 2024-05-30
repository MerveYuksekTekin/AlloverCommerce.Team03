package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.P1_HomePage;
import team03_AlloverCommerceTestNG.pages.P3_UserVendorLoginPage;
import team03_AlloverCommerceTestNG.pages.P7_ShoppingPage;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

import java.beans.Visibility;

public class US19_CustomerCouponShopping {

    Pages allPages = new Pages();

    @Test
    public void test01() throws InterruptedException{

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3UVLP = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        // Site anasayfası açılmalı
        Driver.getDriver().get(ConfigReader.getProperty("us06URL"));

        // Giriş butonu tıklanır olmalı
        p1HomePage.signInButton.click();

        // Kayıtlı bir email adresi girilmeli
        p3UVLP.emailBox.sendKeys(ConfigReader.getProperty("us06name"));

        // Kayıtlı password girilmeli
        p3UVLP.passwordBox.sendKeys(ConfigReader.getProperty("us06password"));

        // Sign In butonu tıklanır olmalı
        p3UVLP.signInButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Çalışma Masası", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.viewcart.click();

        //Sepette ürün adeti artırılabilmeli
        p7SP.buttonPlus.click();
        Thread.sleep(3000);

        //Sepette ürün adeti azaltılabilmeli
        p7SP.buttonMinus.click();
        Thread.sleep(3000);

        //indirim kuponu girilebilmeli
        p7SP.couponBox.sendKeys("indirim100");
        Thread.sleep(3000);

        //indirim kuponu kullnaılabilmeli
        p7SP.applyCoupon.click();
        Thread.sleep(3000);

        //sepetteki ürün çıkarılmalı
        p7SP.clearcart.click();



        //indirim kuponu seçili ürünlerde kullanılamamalı

        //Seçili ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Men’s Clothing", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.viewcart.click();

        //indirim kuponu girilebilmeli
        p7SP.couponBox.sendKeys("indirim100");
        Thread.sleep(3000);

        //girilen indirim kuponu kodu onaylanabilmeli
        p7SP.applyCoupon.click();
        Thread.sleep(3000);

        //sepetteki ürün çıkarılmalı
        p7SP.clearcart.click();


        //geçerli kupon girilmeli

        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Çalışma Masası", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.viewcart.click();

        //girilen indirim kuponu kodu onaylanabilmeli
        p7SP.couponBox.sendKeys("indirim200");
        Thread.sleep(3000);

        //Geçersiz bir kupon kodu girince sistem uyarı vermeli
        p7SP.applyCoupon.click();
        Thread.sleep(3000);

        //sepetteki ürün çıkarılmalı
        p7SP.clearcart.click();

        //boş bırakılmamalı

        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Çalışma Masası", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.viewcart.click();

        //indirim kuponu kutusu boş bırakılmamalı
        p7SP.couponBox.sendKeys("");
        Thread.sleep(3000);

        //indirim kuponu kutusu boş bırakılınca sistem uyarı vermeli
        p7SP.applyCoupon.click();
        Thread.sleep(3000);

        /*

        //fatura adresi görüntülenebilmeli
        p7SP.billing.click();
        Thread.sleep(3000);

        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve "pay at the door" seçebilmeli
        p7SP.paydoor.click();
        Thread.sleep(3000);


        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve wire/eft seçeneğini seçebilmeli
         p7SP.eftwire.click();
        Thread.sleep(3000);

        //kullanıcı siparişi tamamlayabilmeli
        p7SP.placeorder.click();


*/






    }
}
