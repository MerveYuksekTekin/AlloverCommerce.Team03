package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P20_VendorCouponsPage {
    public P20_VendorCouponsPage() {
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//*[@href='https://allovercommerce.com/checkout-2/'])[1]")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@href='?add-to-cart=48566']")
    public WebElement cartSymbol;

    @FindBy(xpath = "(//*[@href='https://allovercommerce.com/checkout-2/'])[2]")
    public WebElement checkoutBox;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement lastNameBox;
    @FindBy(id = "billing_address_1")
    public WebElement streetBox;
    @FindBy(id = "select2-billing_country-container")
    public WebElement countryBox;
    @FindBy(id = "billing_postcode")
    public WebElement postcodeZipBox;
    @FindBy(id = "billing_city")
    public WebElement townCityBox;

    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    public WebElement StateBox;

    @FindBy(id = "billing_phone")
    public WebElement phoneBox;
    @FindBy(id = "billing_email")
    public WebElement emailBox;

    @FindBy(id = "payment_method_bacs")
    public WebElement wireTransfer;

    @FindBy(id = "payment_method_cod")
    public WebElement payAtTheDoor;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//p[contains(@class,'thankyou-order-received order')]")
    public WebElement orderFinishText;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/orders/'])[1]")
    public WebElement ordersLink;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/view-order/55691/'])[2]")
    public WebElement viewButton;

    @FindBy(className = "showcoupon")
    public WebElement enterCodeYourText;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeBox;

    @FindBy(css = "button[name='apply_coupon']")
    public WebElement applyCouponButton;
    @FindBy(xpath = "//*[contains(@class,'alert-close-top')]")
    public WebElement couponCodeVerify;

    @FindBy(xpath ="//a[@class='cart-toggle']")
    public WebElement cartIcon;

}
