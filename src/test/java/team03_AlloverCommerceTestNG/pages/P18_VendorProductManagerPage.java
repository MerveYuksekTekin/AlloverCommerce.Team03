package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P18_VendorProductManagerPage {


    public P18_VendorProductManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']")
    public WebElement coupons;
    @FindBy(xpath = "//*[@id='add_new_coupon_dashboard']")
    public WebElement addNewCoupon;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement codeBox;
    @FindBy(xpath = "//*[@id='description']")
    public  WebElement descriptionBox;
    @FindBy(xpath = "(//select)[1]")
    public  WebElement discountType;
    @FindBy(xpath = "//*[@id='coupon_amount']")
    public  WebElement couponAmountBox;
}