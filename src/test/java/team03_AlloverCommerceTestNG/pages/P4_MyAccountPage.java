package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P4_MyAccountPage {

   public P4_MyAccountPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(partialLinkText = "Store Manager")
    public WebElement storeManagerButton;

   @FindBy(linkText = "Addresses")
    public WebElement addressesButton;


}
