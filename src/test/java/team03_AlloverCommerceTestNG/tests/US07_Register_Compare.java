package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.*;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class US07_Register_Compare {

    Pages allPages = new Pages();

    @Test
    public void test01() throws InterruptedException {

        P1_HomePage p1HomePage = new P1_HomePage();
        P3_UserVendorLoginPage p3UVLP = new P3_UserVendorLoginPage();
        P7_ShoppingPage p7SP = new P7_ShoppingPage();
        P12_ComparePage p12CP = new P12_ComparePage();


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

        //Kullanıcı karşılaştırması istediği  1. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("Erkek T-shirt", Keys.ENTER);

        //Kullanıcı karşılaştıracak 1. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        //Kullanıcı karşılaştırması istediği  2. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("Erkek Kargo Pantolon", Keys.ENTER);

        //Kullanıcı karşılaştıracak 2. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        //Kullanıcı karşılaştırması istediği  3. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("Men sweater", Keys.ENTER);

        //Kullanıcı karşılaştıracak 3. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        //Kullanıcı karşılaştırması istediği  4. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("man boot", Keys.ENTER);

        //Kullanıcı karşılaştıracak 4. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        // Karşılaştırma listesine eklenecek 5.ürün aratılacbilmeli
        p7SP.searchBox.sendKeys("Yeşil Erkek Tisort", Keys.ENTER);

        //Karşılaştırma listesi maximum 4 ürün olamktadır. 5. ürün karşılaştırma listesine eklenebilmeli 1. ürün listeden çıkmalı
        p12CP.compare.click();
        Thread.sleep(5000);

        //Clean All butonuna tıklanabilmeli
        p12CP.cleanall.click();
        Thread.sleep(5000);


        //Kullanıcı karşılaştırması istediği  1. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("Erkek T-shirt", Keys.ENTER);

        //Kullanıcı karşılaştıracak 1. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        //Kullanıcı karşılaştırması istediği  2. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("Erkek Kargo Pantolon", Keys.ENTER);

        //Kullanıcı karşılaştıracak 2. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        //Kullanıcı karşılaştırması istediği  3. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("Men sweater", Keys.ENTER);

        //Kullanıcı karşılaştıracak 3. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();

        //Kullanıcı karşılaştırması istediği  4. ürünü aratabilmeli
        p7SP.searchBox.sendKeys("man boot", Keys.ENTER);

        //Kullanıcı karşılaştıracak 4. ürünü  karşılaştırma listesine ekyelebilmeli
        p12CP.compare.click();
        Thread.sleep(3000);


        //Start Compare Butonuna tıklanabilmeli
        p12CP.startcompare.click();

        //Kullanıcı karşılaştıracak yanlış eklenen 2.ürün "Erkek Kargo Pantolon"  çıkartılabilmeli
        p12CP.deleteprocduct.click();
        Thread.sleep(3000);

        // Karşılaştırma listesinden çıkartılan ürün yerine yeni ürün eklenebilmeli
        p7SP.searchBox.sendKeys("Yeşil Erkek Tisort", Keys.ENTER);

        //Karşılaştırma listesi maximum 4 ürün olamktadır. 5. ürün karşılaştırma listesine eklenebilmeli 1. ürün listeden çıkmalı
        p12CP.compare.click();
        Thread.sleep(5000);

        //Start Compare Butonuna tıklanabilmeli
        p12CP.startcompare.click();


    }
}
