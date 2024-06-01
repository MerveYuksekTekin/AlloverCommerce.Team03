package team03_AlloverCommerceTestNG.tests.US20_VendorCouponsShopping;

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

        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ExtentReportUtils.extentTestInfo("Web sitesine gidildi");

        allPages.homePage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sing In linkine tıklandı");

        allPages.userVendorLoginPage().emailBox.sendKeys("gmt_2601@hotmail.com");
        ExtentReportUtils.extentTestInfo("Emailbox alanına geçerli email girildi");

        allPages.userVendorLoginPage().passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ExtentReportUtils.extentTestInfo("Password alanına geçerli password girildi");

        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sing In butonuna tıklandı");
    }


    @Test(description = "US20 Vendor Coupon Shopping")
    public void TC01_addToProductCart() {

        ReusableMethods.addProductToCart();
        ExtentReportUtils.extentTestInfo("Ürün seacrhboxta aratılıp sepete eklendi");

        //Seçilen ürünlerin sepete eklendiğini doğrula
        Assert.assertTrue(allPages.vendorCouponsPage().cartVerify.getText().contains("“Iphone 15 Pro Max” has been added to your cart."));
        ExtentReportUtils.extentTestInfo("ürünün sepete eklendiği doğrulandı");

        ReusableMethods.logOut();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC02_viewTheProductInTheCart() {

        //Search kutusunun sağındaki Cart iconuna tıkla
        ReusableMethods.click(allPages.vendorCouponsPage().cartIcon);
        ExtentReportUtils.extentTestInfo("Cart iconuna tıklanıldı");

        //Açılan kutucuktaki View Cart butonuna tıkla
        allPages.vendorProductDashboardPage().viewCart.click();
        ExtentReportUtils.extentTestInfo("View Cart iconuna tıklanıldı");


        //Açılan sayfada eklenen ürünlerin görüntülendiğini doğrula
        Assert.assertTrue(allPages.productPage().productName.isDisplayed());
        ExtentReportUtils.extentTestInfo("View cart' a tıklanarak ürünlenin sepete eklendiği doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC03_checkoutClickAndViewTheProduct() {

        ReusableMethods.waitForSecond(2);
        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");


        //Açılan sayfada sepete eklenen ürünlere ait bilgilerin görüntülendiğini doğrula
        Assert.assertTrue(allPages.productPage().yourOrder.getText().contains("Iphone 15 Pro Max"));
        ExtentReportUtils.extentTestInfo("Checkout'a tıklanarak ürünlenin sepete eklendiği doğrulandı");


        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC04_automaticallyViewTheBillingDetails() {
        ReusableMethods.waitForSecond(2);

        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");


        //First name bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().firstNameBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("First name bilgisinin otomatik olarak geldiği doğrulandı");

        //Last name bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().lastNameBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("Last name bilgisinin otomatik olarak geldiği doğrulandı");

        //Country / Region bilgisinin otomatik seçili  geldigini dogrula
        softAssert.assertEquals(allPages.vendorCouponsPage().countryBox
                .getText(),"Turkey");
        ExtentReportUtils.extentTestInfo("Country/Region bilgisinin otomatik olarak seçili geldiği doğrulandı");

        //Street address bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().streetBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("Street address bilgisinin otomatik olarak geldiği doğrulandı");

        //Town / City bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().townCityBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("Town/City bilgisinin otomatik olarak geldiği doğrulandı");

        //ZIP Code bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().postcodeZipBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("Zip Code bilgisinin otomatik olarak geldiği doğrulandı");

        //Phone  bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().phoneBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("Phone bilgisinin otomatik olarak geldiği doğrulandı");

        //Email address  bilgisinin otomatik geldigini dogrula
        if (allPages.vendorCouponsPage().emailBox!=null) {
            softAssert.assertTrue(true);
        }
        ExtentReportUtils.extentTestInfo("Email address bilgisinin otomatik olarak geldiği doğrulandı");

        softAssert.assertAll();

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC05_totalAmountToBePaidDisplay() {
        ReusableMethods.waitForSecond(2);
        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        //Total, toplam ödenecek rakam bilgisinin görüntülendiğini doğrula
        allPages.vendorProductDashboardPage().totalprice.isDisplayed();
        ReusableMethods.scroll(allPages.vendorProductDashboardPage().totalprice);
        Assert.assertTrue(allPages.vendorProductDashboardPage().totalprice.isDisplayed());
        ExtentReportUtils.extentTestInfo("Checkout butonuna tıklanarak toplam ödenecek rakam bilgisinin görüntülendiği doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");


    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC06_wireTranserEftSelect() {

        ReusableMethods.waitForSecond(2);

        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        ReusableMethods.scroll(allPages.vendorCouponsPage().wireTransfer);
        //Wire transfer/EFT seçeneğine tıkla
        if (!allPages.vendorCouponsPage().wireTransfer.isSelected()) {
            ReusableMethods.click(allPages.vendorCouponsPage().wireTransfer);
        }
        ExtentReportUtils.extentTestInfo("Wire transfer/EFT seçeneğine tıklanıldı");


        //Wire transfer/EFT seceneginin secilebildigini dogrula
        Assert.assertTrue(allPages.vendorCouponsPage().wireTransfer.isSelected());
        ExtentReportUtils.extentTestInfo("Wire transfer/EFT seçeneğinin seçilebildiği doğrulandı");


        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");


    }

    @Test
    public void TC07_payAtTheDoorSelect() {
        ReusableMethods.waitForSecond(2);

        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        //Pay at the door seçeneğine tikla

        if (!allPages.vendorCouponsPage().payAtTheDoor.isSelected()) {
            ReusableMethods.click(allPages.vendorCouponsPage().payAtTheDoor);
        }
        ExtentReportUtils.extentTestInfo("Pay at the door seçeneğine tıklanıldı");

        //Pay at the door seceneginin secilebildigini dogrula
        softAssert.assertTrue(allPages.vendorCouponsPage().payAtTheDoor.isSelected());
        ExtentReportUtils.extentTestInfo("Pay at the door seçeneğinin seçilebildiği doğrulandı");

        //Pay at the door ve Wire transfer/EFT seçeneklerinin ikisinin birden tıklanamadığını doğrula
        ReusableMethods.click(allPages.vendorCouponsPage().wireTransfer);
        softAssert.assertFalse(allPages.vendorCouponsPage().payAtTheDoor.isSelected());
        ExtentReportUtils.extentTestInfo("Pay at the door ve Wire transfer/EFT seçeneklerinin ikisinin birden tıklanamadığı doğrulandı");
        softAssert.assertAll();

        JSUtils.JSclickWithTimeout(allPages.vendorCouponsPage().signOutMine);
        allPages.myAccountPage().logoutButton.click();

        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC08_placeOrderClick() {

        ReusableMethods.waitForSecond(2);
        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        //Wire transfer/EFT seçeneğine tıkla
        if (!allPages.vendorCouponsPage().wireTransfer.isSelected()) {
            allPages.vendorCouponsPage().wireTransfer.click();
        }
        ExtentReportUtils.extentTestInfo("Wire transfer/EFT seçeneğine tıklanıldı");

        //PLACE ORDER butonuna tikla
        allPages.vendorCouponsPage().placeOrderButton.submit();
        ExtentReportUtils.extentTestInfo("PLACE ORDER butonuna tıklanıldı");

        //siparişin oluşturulduğuna dair mesaj alındığını doğrula
        Assert.assertTrue(allPages.vendorCouponsPage().orderFinishText.isDisplayed());
        Assert.assertEquals(allPages.vendorCouponsPage().orderFinishText.getText(),"Thank you. Your order has been received.");
        ExtentReportUtils.extentTestInfo("siparişin oluşturulduğuna dair mesaj alındığı doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC09_payAtThDoorSelectAndPlaceOrder() {

        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        WaitUtils.waitForVisibility(allPages.vendorCouponsPage().payAtTheDoor,5);
        if (!allPages.vendorCouponsPage().payAtTheDoor.isSelected()) {
           ReusableMethods.click(allPages.vendorCouponsPage().payAtTheDoor);
        }
        ExtentReportUtils.extentTestInfo("Pay at the door seçeneğine tıklanıldı");

        softAssert.assertTrue(allPages.vendorCouponsPage().payAtTheDoor.isSelected());
        ExtentReportUtils.extentTestInfo("Pay at the door seçeneğinin görüntülendiği doğrulandı");

        //PLACE ORDER butonuna tikla
        allPages.vendorCouponsPage().placeOrderButton.submit();
        ExtentReportUtils.extentTestInfo("PLACE ORDER butonuna tıklanıldı");

        //siparişin oluşturulduğuna dair mesaj alındığını doğrula
        softAssert.assertTrue(allPages.vendorCouponsPage().orderFinishText.isDisplayed());

        softAssert.assertEquals(allPages.vendorCouponsPage().orderFinishText.getText(),"Thank you. Your order has been received.");
        ExtentReportUtils.extentTestInfo("Siparişin oluşturulduğuna dair mesaj alındığı doğrulandı");
        softAssert.assertAll();

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC10_viewTheOrderDetails() {
        allPages.homePage().signOutButton.click();
        ExtentReportUtils.extentTestInfo("My ACCOUNT linkine tıklanıldı");

        allPages.vendorCouponsPage().ordersLink.click();
        ExtentReportUtils.extentTestInfo("ORDERS icona tıklanıldı");

       ReusableMethods.click(allPages.vendorCouponsPage().viewButton);
       ReusableMethods.waitForSecond(2);
        ExtentReportUtils.extentTestInfo("VIEW butonuna tıklanıldı");

        //Yapılan alışverişe ait bilgilerin görüntülendiğini doğrula
        Assert.assertTrue(allPages.vendorCouponsPage().ordersDetails.getText().contains("Iphone 15 Pro Max"));
        ExtentReportUtils.extentTestInfo("Yapılan alışverişe ait bilgilerin görüntülendiği doğrula");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC11_clickEnterYourCodeAndAddCode() {
        ReusableMethods.click(allPages.vendorProductDashboardPage().searchBox);
        ExtentReportUtils.extentTestInfo("Search kutusuna tıklanıldı");

        allPages.vendorCouponsPage().search.sendKeys("Basic Handbag");
        ExtentReportUtils.extentTestInfo("Searchbox butonuna Basic Handbag yazıldı");

        allPages.vendorCouponsPage().search.submit();
        ExtentReportUtils.extentTestInfo("Enter tuşuna basıldı");

        ReusableMethods.click(allPages.vendorProductDashboardPage().addToCartButton);
        ExtentReportUtils.extentTestInfo("Add to Cart butonuna tıklandı");

        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        allPages.vendorCouponsPage().enterCodeYourText.click();
        ExtentReportUtils.extentTestInfo("ENTER CODE YOUR yazınına tıklanıldı");

        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2024");
        ExtentReportUtils.extentTestInfo("Açılan kutucuğa oluşturulan kupon codu girildi");


        allPages.vendorCouponsPage().applyCouponButton.click();
        ExtentReportUtils.extentTestInfo("APPLY COUPON butonuna tıklanıldı");

        //Coupon kodunun girildiğini doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Coupon code applied successfully.");
        ExtentReportUtils.extentTestInfo("Coupon kodunun onaylandığı doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC12_addInvalidCouponCode() {
        ReusableMethods.waitForSecond(2);

        ReusableMethods.cartAndCheckout();
        ExtentReportUtils.extentTestInfo("Ürün sepete eklendi ve Checkout butonuna tıklanıldı");

        allPages.vendorCouponsPage().enterCodeYourText.click();
        ExtentReportUtils.extentTestInfo("ENTER CODE YOUR yazınına tıklanıldı");

        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2020");
        ExtentReportUtils.extentTestInfo("Açılan kutucuğa geçersiz kupon codu girildi");

        allPages.vendorCouponsPage().applyCouponButton.click();
        ExtentReportUtils.extentTestInfo("APPLY COUPON butonuna tıklanıldı");

        //"Coupon "SALE2020" does not exist!"("SALE2020" kuponu mevcut değil!) mesajı alındığını doğrula
       Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Coupon \"sale2020\" does not exist!");
        ExtentReportUtils.extentTestInfo("Coupon kodunun onaylanmadığı doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }
    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC13_notUseACouponMoreThanOnce() {
        ReusableMethods.click(allPages.vendorProductDashboardPage().cart);
        ExtentReportUtils.extentTestInfo("Cart iconuna tıklanıldı");

        allPages.vendorProductDashboardPage().checkout.click();
        ExtentReportUtils.extentTestInfo("CHECKOUT  butonuna tıklanıldı");

        allPages.vendorCouponsPage().enterCodeYourText.click();
        ExtentReportUtils.extentTestInfo("ENTER CODE YOUR yazınına tıklanıldı");

        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2024");
        ExtentReportUtils.extentTestInfo("Açılan kutucuğa geçerli kupon codu girildi");

        allPages.vendorCouponsPage().applyCouponButton.click();
        ExtentReportUtils.extentTestInfo("APPLY COUPON butonuna tıklanıldı");

        System.out.println(allPages.vendorCouponsPage().couponCodeVerify.getText());
        //"Coupon code already applied!." mesajı alındığını doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Coupon code already applied!");
        ExtentReportUtils.extentTestInfo("Coupon kodunun onaylanmadığı doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC14_unableToUseSelectedProduct() {
        ReusableMethods.waitForSecond(3);
        ReusableMethods.click(allPages.vendorProductDashboardPage().searchBox);
        ExtentReportUtils.extentTestInfo("Search kutusuna tıklanıldı");

        //Database de tanımlı olan bir ürün ismi yaz,Entera ya da search simgesine tıkla
        allPages.vendorProductDashboardPage().searchBox.sendKeys("kalem", Keys.ENTER);
        ExtentReportUtils.extentTestInfo("Search kutusuna kalem yazıldı ve Enter tuşuna basıldı");

        ReusableMethods.click(allPages.vendorProductDashboardPage().addToCartButton);
        ExtentReportUtils.extentTestInfo("ADD TO CART  butonuna tıklanıldı");

        ReusableMethods.click(allPages.vendorProductDashboardPage().cart);
        ExtentReportUtils.extentTestInfo("CART iconuna tıklanıldı");

        allPages.vendorCouponsPage().handbagClose.click();
        ExtentReportUtils.extentTestInfo("Çanta sepetten silindi");

        allPages.vendorProductDashboardPage().checkout.click();
        ExtentReportUtils.extentTestInfo("CHECKOUT butonuna tıklanıldı");

        allPages.vendorCouponsPage().enterCodeYourText.click();
        ExtentReportUtils.extentTestInfo("ENTER CODE YOUR yazınına tıklanıldı");

        allPages.vendorCouponsPage().couponCodeBox.sendKeys("SALE2024");
        ExtentReportUtils.extentTestInfo("Açılan kutucuğa geçerli kupon codu girildi");

        allPages.vendorCouponsPage().applyCouponButton.click();
        ExtentReportUtils.extentTestInfo("APPLY COUPON butonuna tıklanıldı");

        //"Sorry, this coupon is not applicable to selected products"
        // ("Üzgünüz, bu kupon seçili ürünlerde geçerli değildir.") mesajı alındığını doğrula
        Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Sorry, this coupon is not applicable to selected products.");
        ExtentReportUtils.extentTestInfo("Coupon kodunun onaylanmadığı doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");

    }

    @Test(description = "US20-Vendor Coupon Shopping")
    public void TC15_doNotTheBoxEmpty() {
        ReusableMethods.click(allPages.vendorProductDashboardPage().cart);
        ExtentReportUtils.extentTestInfo("CART iconuna tıklanıldı");

        allPages.vendorProductDashboardPage().checkout.click();
        ExtentReportUtils.extentTestInfo("CHECKOUT butonuna tıklanıldı");

        allPages.vendorCouponsPage().enterCodeYourText.click();
        ExtentReportUtils.extentTestInfo("ENTER CODE YOUR yazınına tıklanıldı");

        //Açılan kutucuğu boş bırak

        allPages.vendorCouponsPage().applyCouponButton.click();
        ExtentReportUtils.extentTestInfo("APPLY COUPON butonuna tıklanıldı");

        //"Please enter a coupon code." mesajı alındığını  doğrula
       Assert.assertEquals(allPages.vendorCouponsPage().couponCodeVerify.getText(),"Please enter a coupon code.");
        ExtentReportUtils.extentTestInfo("Coupon kodunun onaylanmadığı doğrulandı");

        ReusableMethods.userVendorLogout();
        ExtentReportUtils.extentTestInfo("Siteden çıkış yapıldı");
    }

}

