package team03_AlloverCommerceTestNG.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P18_VendorProductManagerPage {

    public P18_VendorProductManagerPage() { PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (id="product_type")
    public WebElement dropdownSimpleProduct;
    @FindBy(xpath = "//option[@value='variable']")
    public WebElement dropdownVariableProduct;
    @FindBy(xpath = "//option[@value='grouped']")
    public WebElement dropdownGroupedProduct;

    @FindBy(xpath = "//option[@value='external']")
    public WebElement dropdownExternalProduct;








}
