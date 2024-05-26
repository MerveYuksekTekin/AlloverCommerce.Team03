package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P4_MyAccountPage {


 public P4_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
  
     @FindBy(partialLinkText = "Store Manager")
    public WebElement storeManagerButton;

   @FindBy(linkText = "Addresses")
    public WebElement addressesButton;

    @FindBy(linkText = "Orders")
    public WebElement ordersButton;

    @FindBy(linkText = "Downloads")
    public WebElement dowloadsButton;

    @FindBy(linkText = "Account details")
    public WebElement accountDetailsButton;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlistButton;

    @FindBy(partialLinkText = "Support Tickets")
    public WebElement supportTicketsButton;

    @FindBy(partialLinkText = "Followings")
    public WebElement followingsButton;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    @FindBy(xpath= "//*[.='Actions']")
    public WebElement followingButtonActionText;
    @FindBy(xpath= "//*[.='Ticket(s)']")
    public WebElement supportTicketsButtonTicketsText;

    @FindBy(xpath= "//h4[.='Account Details']")
    public WebElement accountDetailsButtonTitle;

    @FindBy(xpath= "//h4[.='Orders']")
    public WebElement ordersButtonTitle;

    @FindBy(xpath= "//h4[.='Downloads']")
    public WebElement dowloadsButtonTitle;



}
