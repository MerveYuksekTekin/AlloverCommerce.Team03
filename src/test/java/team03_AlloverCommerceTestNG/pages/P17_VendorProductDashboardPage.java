package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P17_VendorProductDashboardPage {


    public P17_VendorProductDashboardPage() { PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "//*[.='Add New']")
    public WebElement addNewButton;


}
