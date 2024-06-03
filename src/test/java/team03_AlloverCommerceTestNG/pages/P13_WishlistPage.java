package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P13_WishlistPage {
    public P13_WishlistPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Wishlist']")
    public WebElement wishlistTitle;

    @FindBy (xpath = "(//div[contains(@class,'yith-wcwl-add-to-wishlist')])[1]")
    public WebElement wishListSymbol;

    @FindBy (className = "w-icon-heart")
    public WebElement wishListIcon;

    @FindBy(xpath ="(//button[contains(text(),'Quick View')])[2]")
    public WebElement quickViewButton1;

    @FindBy(xpath ="(//button[contains(text(),'Quick View')])[1]")
    public WebElement quickViewButton2;

    @FindBy(css ="button[class='mfp-close']")
    public WebElement closeButton;

    @FindBy(xpath ="(//a[text()='Add to cart'])[2]")
    public WebElement addToCartButton1;

    @FindBy(xpath ="(//a[text()='Add to cart'])[1]")
    public WebElement addToCartButton2;

    @FindBy(xpath ="(//p/a)[1]")
    public WebElement viewCartButton;

    @FindBy(partialLinkText ="Proceed to checkout ")
    public WebElement proceedToCheckout;
    @FindBy (css = "div[data-fragment-ref='21379']")
    public WebElement wishList;

    @FindBy(xpath="(//a[@rel='nofollow'])[2]")
    public WebElement macBookV20Icon;

    @FindBy(xpath="//a[@href='?add_to_wishlist=16777']")
    public WebElement macBookProIcon;
}
