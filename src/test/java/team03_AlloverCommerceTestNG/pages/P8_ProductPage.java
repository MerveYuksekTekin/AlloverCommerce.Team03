package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P8_ProductPage {
    @FindBy(xpath = "(//*[@class='product-name'])[1]")
    public WebElement productName;

    @FindBy(xpath = "//img[@width='300'][1]")
    public WebElement iphone;

    @FindBy(className = "cart_item")
    public WebElement productInfo;

    @FindBy (css = "img[height='179']")
    public WebElement macbook;
}
