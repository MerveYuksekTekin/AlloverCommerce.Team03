package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P7_ShoppingPage {

    public P7_ShoppingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addTocart;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div")
    public WebElement cart;

    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCart;

    @FindBy(xpath = "//h1[@class='product_title entry-title']")
    public WebElement mensclothing;

    @FindBy(xpath = "//li[@class='no-product']")
    public WebElement noProducts;

    @FindBy(xpath = "//td[@data-title='Product']")
    public WebElement trueCart;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[1]")
    public WebElement viewcart;

    @FindBy(xpath = "//button[@title='Plus']")
    public WebElement buttonPlus;

    @FindBy(xpath = "//input[@value='2']")
    public WebElement valuePlus;



    @FindBy(xpath = "//button[@title='Minus']")
    public WebElement buttonMinus;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement inputnumber;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/ul/li[2]/a")
    public WebElement billing;

    @FindBy(id = "//input[@name='ship_to_different_address']")
    public WebElement differentAddress;

    @FindBy(xpath = "//input[@value='bacs']")
    public WebElement eftWire;

    @FindBy(xpath = "//input[@value='cod']")
    public WebElement paydoor;

    @FindBy(css = "#place_order")
    public WebElement placeorder;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement couponBox;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCoupon;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[1]/form/table/tbody/tr[1]/td[1]/a[2]")    ////button[@name='clear_cart']
    public WebElement clearCart;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/ul/li[2]/a")
    public WebElement checkout;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[9]/div/div/a/span")
    public WebElement signout;

    @FindBy(xpath = "//*[.='Thank you. Your order has been received.']")
    public WebElement orderComplete;

    @FindBy(xpath = "//div[@class='woocommerce-order']")
    public WebElement endOrder;

    @FindBy(xpath = "//*[@id=\"order_review\"]/table/tfoot/tr[1]")
    public WebElement subTotal;














}
