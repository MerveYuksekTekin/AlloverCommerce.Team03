package team03_AlloverCommerceTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.Driver;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

//deneme-2
public class US11_VendorSignIn {
    Pages allPages = new Pages();

    @BeforeMethod
    public void setUp() {
        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();


    }

    @Test
    public void tc01() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Sign Out görülmeli
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc02() {

        // Email box boş bırakılmalı
        allPages.userVendorLoginPage().emailBox.sendKeys("");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        String validationMessage = allPages.userVendorLoginPage().emailBox.getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Lütfen bu alanı doldurun.");



    }

    @Test
    public void tc03() {

        // Email boxa geçersiz bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("merve@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }

    @Test
    public void tc04() {

        // Email boxa geçersiz bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("merve@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }

    @Test
    public void tc05() {

        // Email boxa kayıtlı bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Password boxa geçersiz password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("merve");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }

    @Test
    public void tc06() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Dashboard altında  Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out seçeneklerinin görüldüğünü doğrula
        List<String> linkTexts = allPages.myAccountPage().getLinkTexts();
        List<String> expectedTexts = Arrays.asList(
                "Dashboard",
                "Store Manager",
                "Orders",
                "Downloads",
                "Addresses",
                "Account details",
                "Wishlist",
                "Support Tickets",
                "Followings",
                "Logout"
        );
        Assert.assertEquals(linkTexts, expectedTexts);
        ReusableMethods.logOut();


    }

    @Test
    public void tc07() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Store manager butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().storeManagerButton);

        //Store manager başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorStoreManagerPage().storeManagerTitle.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc08() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Orders butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().ordersButton);

        //Addresses başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().ordersButtonTitle.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc09() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Dowloads butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().dowloadsButton);

        //Downloads başlığının görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().dowloadsButtonTitle.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc10() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Addresses butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().addressesButton);

        //Addresses başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorAddressesPage().addressesTitle.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc11() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().accountDetailsButton);

        //Account details başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().accountDetailsButton.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc12() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Wishlist butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().wishlistButton);

        //Ticket(s) başlığı görülmeli
        Assert.assertTrue(allPages.wishlistPage().wishlistTitle.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc13() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Support tickets butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().supportTicketsButton);

        //Ticket(s) başlığı görülmeli
        Assert.assertTrue(allPages.myAccountPage().supportTicketsButtonTicketsText.isDisplayed());
        ReusableMethods.logOut();

    }

    @Test
    public void tc14() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Followings butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().followingsButton);

        //Actions başlığı görülmeli
        Assert.assertTrue(allPages.myAccountPage().followingButtonActionText.isDisplayed());
        ReusableMethods.logOut();


    }

    @Test
    public void tc15() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Dashboard altında Log out  menüsüne girildiğini doğrula
        ReusableMethods.click(allPages.myAccountPage().logoutButton);
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());

    }
    @Test
    public void tc16() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");

        // Password boxa basina yeya sonuna space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(" aaaaaaaaaa11");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //Giriş yapılmadığını doğrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());


    }



    @AfterMethod
    public void tearDown() {

    }
}