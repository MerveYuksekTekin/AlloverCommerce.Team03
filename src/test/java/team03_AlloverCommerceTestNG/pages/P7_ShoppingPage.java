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

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[1]")
    public WebElement viewcart;

    @FindBy(xpath = "//button[@title='Plus']")
    public WebElement buttonPlus;

    @FindBy(xpath = "//button[@title='Minus']")
    public WebElement buttonMinus;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/ul/li[2]/a")
    public WebElement billing;

    @FindBy(xpath = "//input[@value='cod']")
    public WebElement paydoor;

    @FindBy(xpath = "//input[@value='bacs']")
    public WebElement eftwire;

    @FindBy(css = "#place_order")
    public WebElement placeorder;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement couponBox;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCoupon;

    @FindBy(xpath = "//button[@name='clear_cart']")
    public WebElement clearcart;













}
