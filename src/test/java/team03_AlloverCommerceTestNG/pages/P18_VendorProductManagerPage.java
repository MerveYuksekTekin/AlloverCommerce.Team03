package team03_AlloverCommerceTestNG.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P18_VendorProductManagerPage {

    public P18_VendorProductManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "product_type")
    public WebElement dropdownSimpleProduct;

    @FindBy(id = "is_virtual")
    public WebElement virtualCheckBox;
    @FindBy(id = "is_downloadable")
    public WebElement downloadableCheckBox;

    @FindBy(id = "regular_price")
    public WebElement priceBox;

    @FindBy(id = "sale_price")
    public WebElement salePriceBox;

    @FindBy(id = "pro_title")
    public WebElement productTitleBox;

     @FindBy(xpath = "//*[@value='510']")
    public WebElement categoryEducation;

    @FindBy(id = "featured_img_display")
    public WebElement uploadPhoto;











}
