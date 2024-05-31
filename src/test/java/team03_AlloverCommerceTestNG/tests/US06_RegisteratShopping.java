package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.P1_HomePage;
import team03_AlloverCommerceTestNG.pages.P3_UserVendorLoginPage;
import team03_AlloverCommerceTestNG.pages.P7_ShoppingPage;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class US06_RegisteratShopping  {

    @Test
    public void test01() throws InterruptedException{

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3UVLP = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();


                // Site anasayfası açılmalı
        Driver.getDriver().get(ConfigReader.getProperty("us06URL"));



        // Giriş butonu tıklanır olmalı ve Giriş penceresi açılmalı
        p1HomePage.signInButton.click();



        // Kayıtlı bir email adresi girilmeli
        p3UVLP.emailBox.sendKeys(ConfigReader.getProperty("us06name"));

        // Kayıtlı password girilmeli
        p3UVLP.passwordBox.sendKeys(ConfigReader.getProperty("us06password"));

        // Sign In butonu tıklanır olmalı
        p3UVLP.signInButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


        //İstenilen ürün aratlıabilmeli
        p7SP.searchBox.sendKeys("Men’s Clothing", Keys.ENTER);

        //Seçilen ürün sepete eklenebilmeli
        p7SP.addTocart.click();

        //Seçilen ürün Shopping Card'ta görüntülenebilmeli
        p7SP.cart.click();

        //Alışveriş Sepeti görüntülenebilmeli
        p7SP.viewcart.click();

        //Sepette ürün adeti artırılabilmeli
        p7SP.buttonPlus.click();

        //Sepette ürün adeti azaltılabilmeli
        p7SP.buttonMinus.click();











    }
}