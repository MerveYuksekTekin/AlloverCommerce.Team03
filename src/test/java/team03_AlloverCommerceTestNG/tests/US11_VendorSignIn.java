package team03_AlloverCommerceTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.P1_HomePage;
import team03_AlloverCommerceTestNG.pages.P3_UserVendorLoginPage;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;

//deneme-2
public class US11_VendorSignIn {
    P1_HomePage p1HomePage = new P1_HomePage();
    P3_UserVendorLoginPage p3UVLP = new P3_UserVendorLoginPage();

    @Test
    public void test01() {
        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("us11URL"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(p1HomePage.signInButton.isEnabled());
        p1HomePage.signInButton.click();

        // Kayıtlı bir email adresi girilmeli
        p3UVLP.emailBox.sendKeys(ConfigReader.getProperty("us11email"));

        // Kayıtlı password girilmeli
        p3UVLP.passwordBox.sendKeys(ConfigReader.getProperty("us11password"));

        // Sign In butonu tıklanır olmalı
        p3UVLP.signInButton.click();

        // My Account görülmeli

    }

    @Test
    public void test02() {

        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("us11URL"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(p1HomePage.signInButton.isEnabled());
        p1HomePage.signInButton.click();

        // Email box boş bırakılmalı
        p3UVLP.emailBox.sendKeys();
        // Kayıtlı password girilmeli
        p3UVLP.passwordBox.sendKeys(ConfigReader.getProperty("us11password"));

        // Sign In butonu tıklanır olmalı
        // Giriş işlemi gerçekleşmemeli

    }
}
