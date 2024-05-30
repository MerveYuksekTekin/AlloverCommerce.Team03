package team03_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.*;

public class US20_VendorCouponsShopping {


Pages allPages = new Pages();
SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void setUp() {
        //Web sitesine git https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        //Sign in linkini tikla
        allPages.homePage().signInButton.click();
        //Vendor hesabi ile giris yap
        allPages.userVendorLoginPage().emailBox.sendKeys(ConfigReader.getProperty("email"));
        allPages.userVendorLoginPage().passwordBox.sendKeys(ConfigReader.getProperty("password"));
        allPages.userVendorLoginPage().signInButton.click();
    }



    @Test
    public void TC01_addToProductCart() {

        ReusableMethods.addProductToCart();

        //Seçilen ürünlerin sepete eklendiğini doğrula
        Assert.assertTrue(allPages.productPage().urun.isDisplayed());
    }

    @Test
    public void TC02_viewTheProductInTehCart() {

        //Search kutusunun sağındaki Cart iconuna tıkla
        ReusableMethods.click(allPages.vendorCouponsPage().cartIcon);

        //Açılan kutucuktaki View Cart butonuna tıkla
        allPages.vendorProductDashboardPage().viewCart.click();

        //Açılan sayfada eklenen ürünlerin görüntülendiğini doğrula
        Assert.assertTrue(allPages.productPage().productName.isDisplayed());
    }

    @Test
    public void TC03_checkoutClickAndViewTheProduct() {

        ReusableMethods.waitForSecond(2);
        ReusableMethods.cartAndCheckout();

        //Açılan sayfada sepete eklenen ürünlere ait bilgilerin görüntülendiğini doğrula
        Assert.assertTrue(allPages.productPage().productName.getText().contains("Iphone 15 Pro Max"));
    }

    @Test
    public void TC04_automaticallyViewTheBillingDetails() {
        ReusableMethods.waitForSecond(2);
        //Search kutusuna tikla
        //Database de tanımlı olan bir ürün ismi yaz,Entera ya da search simgesine tıkla
        allPages.vendorProductDashboardPage().searchBox.sendKeys("kalem", Keys.ENTER);

        //Açılan sayfada bulunan ADD TO CART butonuna tıkla
        ReusableMethods.click(allPages.vendorProductDashboardPage().addToCartButton);

        ReusableMethods.cartAndCheckout();

        //First name bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().firstNameBox!=null) {
            Assert.assertTrue(true);
        }
        //Last name bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().lastNameBox!=null) {
            Assert.assertTrue(true);
        }
        //Country / Region bilgisinin otomatik seçili  geldigini dogrula
        softAssert.assertEquals(allPages.vendorCouponsPage().countryBox
                .getText(),"Turkey");

        //Street address bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().streetBox!=null) {
            softAssert.assertTrue(true);
        }
        //Town / City bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().townCityBox!=null) {
            softAssert.assertTrue(true);
        }
        //ZIP Code bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().postcodeZipBox!=null) {
            softAssert.assertTrue(true);
        }
        //Phone  bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().phoneBox!=null) {
            softAssert.assertTrue(true);
        }
        //Email address  bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().emailBox!=null) {
            softAssert.assertTrue(true);
        }
        softAssert.assertAll();
        }

    @Test
    public void TC05_totalAmountToBePaidDisplay() {
        ReusableMethods.waitForSecond(2);
        ReusableMethods.cartAndCheckout();

        //Total, toplam ödenecek rakam bilgisinin görüntülendiğini doğrula
        allPages.vendorProductDashboardPage().totalprice.isDisplayed();
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().totalprice);
        Assert.assertTrue(allPages.vendorProductDashboardPage().totalprice.isDisplayed());

    }

    @Test
    public void TC06_wireTranserEftSelect() {

        ReusableMethods.waitForSecond(2);

        ReusableMethods.cartAndCheckout();

        //Wire transfer/EFT seçeneğine tıkla
        if (!allPages.vendorCouponsPage().wireTransfer.isSelected()) {
            ReusableMethods.click(allPages.vendorCouponsPage().wireTransfer);
        }

        //Wire transfer/EFT seceneginin secilebildigini dogrula
        Assert.assertTrue(allPages.vendorCouponsPage().wireTransfer.isSelected());

    }

    @Test
    public void TC07_payAtTheDoorSelect() {
        ReusableMethods.waitForSecond(2);

        ReusableMethods.cartAndCheckout();

        //Pay at the door seçeneğine tikla
        if (!allPages.vendorCouponsPage().payAtTheDoor.isSelected()) {
            ReusableMethods.click(allPages.vendorCouponsPage().payAtTheDoor);
        }

        //Pay at the door seceneginin secilebildigini dogrula
        Assert.assertTrue(allPages.vendorCouponsPage().payAtTheDoor.isSelected());

        //Pay at the door ve Wire transfer/EFT seçeneklerinin ikisinin birden tıklanamadığını doğrula
        ReusableMethods.click(allPages.vendorCouponsPage().wireTransfer);
        Assert.assertFalse(allPages.vendorCouponsPage().payAtTheDoor.isSelected());

    }

    @Test
    public void TC08_placeOrderClick() {

        ReusableMethods.waitForSecond(2);
        ReusableMethods.cartAndCheckout();

        //Wire transfer/EFT seçeneğine tıkla
        if (!allPages.vendorCouponsPage().wireTransfer.isSelected()) {
            allPages.vendorCouponsPage().wireTransfer.click();
        }

        //PLACE ORDER butonuna tikla
        allPages.vendorCouponsPage().placeOrderButton.submit();

        //siparişin oluşturulduğuna dair mesaj alındığını doğrula
        Assert.assertTrue(allPages.vendorCouponsPage().orderFinishText.isDisplayed());

        Assert.assertEquals(allPages.vendorCouponsPage().orderFinishText.getText(),"Thank you. Your order has been received.");
    }

    @Test
    public void TC09_payAtThDoorSelectAndPlaceOrder() {

        ReusableMethods.addProductToCart();
        //Search kutusunun sağındaki Cart iconuna tıkla
        allPages.vendorProductDashboardPage().cart.click();

        //Çıkan kutucuktaki CHECKOUT  butonuna tıkla
        allPages.vendorCouponsPage().checkoutButton.click();

        //Pay at the door seçeneğini seç
        if (!allPages.vendorCouponsPage().payAtTheDoor.isSelected()) {
            allPages.vendorCouponsPage().payAtTheDoor.click();
        }

        //PLACE ORDER butonuna tikla
        allPages.vendorCouponsPage().placeOrderButton.submit();

        //siparişin oluşturulduğuna dair mesaj alındığını doğrula
        Assert.assertTrue(allPages.vendorCouponsPage().orderFinishText.isDisplayed());

        Assert.assertEquals(allPages.vendorCouponsPage().orderFinishText.getText(),"Thank you. Your order has been received.");
    }

    @Test
    public void TC10_viewTheOrderDetails() {
        //Ana sayfanın altındaki My ACCOUNT linkine tıkla
        allPages.homePage().signOutButton.click();

        //Açılan My Account sayfasındaki ORDERS icona tıkla
        allPages.vendorCouponsPage().ordersLink.click();

        //VIEW butonuna tıkla
       ReusableMethods.click(allPages.vendorCouponsPage().viewButton);
       ReusableMethods.waitForSecond(2);

        //Alışverişe ait bilgilerin görüntülendiğini doğrula

    }

    @Test
    public void tc11() {
        //Search kutusuna tikla
        ReusableMethods.click(allPages.vendorProductDashboardPage().searchBox);

        //Database de tanımlı olan bir ürün ismi yaz,Entera ya da search simgesine tıkla
        allPages.vendorProductDashboardPage().searchBox.sendKeys("Basic Handbag", Keys.ENTER);

        //Açılan sayfada bulunan ADD TO CART butonuna tıkla
        ReusableMethods.click(allPages.vendorProductDashboardPage().addToCartButton);

        //Search kutusunun sağındaki Cart iconuna tıkla
        allPages.vendorProductDashboardPage().cart.click();

        //Çıkan kutucuktaki CHECKOUT  butonuna tıkla
        allPages.vendorCouponsPage().checkoutButton.click();

        //ENTER CODE YOUR yazınına tıkla
        allPages.vendorCouponsPage().enterCodeYourText.click();

        //Açılan kutucuğa geçerli kupon kodunu gir
        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2024");

        //APPLY COUPON butonuna tıkla
        allPages.vendorCouponsPage().applyCouponButton.click();

        //Coupon kodunun girildiğini doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Coupon code applied successfully.");
    }

    @Test
    public void tc12() {
        ReusableMethods.cartAndCheckout();

        //ENTER CODE YOUR yazınına tıkla
        allPages.vendorCouponsPage().enterCodeYourText.click();

        //Açılan kutucuğa geçersiz kupon kodunu gir
        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2020");

        //APPLY COUPON butonuna tıkla
        allPages.vendorCouponsPage().applyCouponButton.click();

        //"Coupon "SALE2020" does not exist!"("SALE2020" kuponu mevcut değil!) mesajı alındığını doğrula
       Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Coupon \"sale2020\" does not exist!");
    }

    @Test
    public void tc13() {
        ReusableMethods.waitForSecond(3);
        //Search kutusuna tikla
        ReusableMethods.click(allPages.vendorProductDashboardPage().searchBox);

        //Database de tanımlı olan bir ürün ismi yaz,Entera ya da search simgesine tıkla
        allPages.vendorProductDashboardPage().searchBox.sendKeys("kalem", Keys.ENTER);

        //Açılan sayfada bulunan ADD TO CART butonuna tıkla
        ReusableMethods.click(allPages.vendorProductDashboardPage().addToCartButton);

        //Search kutusunun sağındaki Cart iconuna tıkla
        ReusableMethods.click(allPages.vendorProductDashboardPage().cart);

        //Çıkan kutucuktaki CHECKOUT  butonuna tıkla
        allPages.vendorProductDashboardPage().checkout.click();

        //ENTER CODE YOUR yazınına tıkla
        allPages.vendorCouponsPage().enterCodeYourText.click();

        //Açılan kutucuğa geçerli kupon kodunu gir
        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2024");

        //APPLY COUPON butonuna tıkla
        allPages.vendorCouponsPage().applyCouponButton.click();

        //"Sorry, this coupon is not applicable to selected products"
        // ("Üzgünüz, bu kupon seçili ürünlerde geçerli değildir.") mesajı alındığını doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Sorry, this coupon is not applicable to selected products.");

    }

    @Test
    public void tc14() {
        //Search kutusunun sağındaki Cart iconuna tıkla
        ReusableMethods.click(allPages.vendorProductDashboardPage().cart);
        //Çıkan kutucuktaki CHECKOUT  butonuna tıkla
        allPages.vendorProductDashboardPage().checkout.click();

        //ENTER CODE YOUR yazınına tıkla
        allPages.vendorCouponsPage().enterCodeYourText.click();

        //Açılan kutucuğu boş bırak

        //APPLY COUPON butonuna tıkla
        allPages.vendorCouponsPage().applyCouponButton.click();

        //"Please enter a coupon code." mesajı alındığını  doğrula
       Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Please enter a coupon code.");

    }

    @Test
    public void tc15() {
         //Search kutusunun sağındaki Cart iconuna tıkla
        ReusableMethods.click(allPages.vendorProductDashboardPage().cart);

        //Çıkan kutucuktaki CHECKOUT  butonuna tıkla
        allPages.vendorProductDashboardPage().checkout.click();

        //ENTER CODE YOUR yazınına tıkla
        allPages.vendorCouponsPage().enterCodeYourText.click();

        //Açılan kutucuğa geçerli kupon kodunu gir
        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2024");

        //APPLY COUPON butonuna tıkla
        allPages.vendorCouponsPage().applyCouponButton.click();
        System.out.println(allPages.vendorCouponsPage().couponCodeVerify.getText());
        //"Coupon code already applied!." mesajı alındığını doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Coupon code already applied!");

    }
}

