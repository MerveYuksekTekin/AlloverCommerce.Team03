package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.P1_HomePage;
import team03_AlloverCommerceTestNG.pages.P3_UserVendorLoginPage;
import team03_AlloverCommerceTestNG.pages.P7_ShoppingPage;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class US06_Register_Shopping {

    Pages allPages = new Pages();


    @BeforeMethod
    public void setUp() {
        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        //Sing In linkine tıkla
        allPages.homePage().signInButton.click();
        //Username or email adress kutusuna geçerli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys(ConfigReader.getProperty("email"));
        //Password kutusuna geçerli bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(ConfigReader.getProperty("password"));
        //SING IN butonuna tıkla
        allPages.userVendorLoginPage().signInButton.click();



        P7_ShoppingPage p7SP = new P7_ShoppingPage();

    }

    @Test
    public void TC01_productsearch () throws InterruptedException {


        P7_ShoppingPage p7SP = new P7_ShoppingPage();


        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Men’s Clothing", Keys.ENTER);

    }

    @Test
    public void TC02_ () throws InterruptedException {

        P7_ShoppingPage p7SP = new P7_ShoppingPage();

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

        //fatura adresi görüntülenebilmeli
        p7SP.billing.click();
        Thread.sleep(3000);

        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve pay at the door seçebilmeli
        p7SP.paydoor.click();
        Thread.sleep(3000);


        //kullanıcı ödeme seçeneklerini görüntüleyebilmeli ve wire/eft seçeneğini seçebilmeli
        p7SP.eftwire.click();
        Thread.sleep(3000);


        p7SP.placeorder.click();


    }
}
