package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P8_ProductPage {
    public P8_ProductPage() {PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "cart_item")
    public WebElement productName;

    @FindBy(xpath = "(//h2/a)[1]")
    public WebElement productInfo;

    @FindBy (css = "img[height='182']")
    public WebElement macbook;

    @FindBy(xpath = "(//img[@height='300'])[1]")
    public WebElement urun;

    @FindBy(id = "product-48566")
    public WebElement urunQuickView;

    @FindBy(xpath="//img[@width='180']")
    public WebElement macBookV20;

    @FindBy(xpath="(//img[@width='300'])[2]")
    public WebElement macBookPro;

    @FindBy(xpath="(//figure/a)[1]")
    public WebElement iphone;

    @FindBy(className="page-content")
    public WebElement products;
    @FindBy(css="div[id='order_review']")
    public WebElement yourOrder;


}
