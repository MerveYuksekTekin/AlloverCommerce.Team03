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

    @FindBy(xpath = "//option[@value='external']")
    public WebElement dropdownExternalProduct;

    @FindBy(xpath = "//option[@value='grouped']")
    public WebElement dropdownGroupedProduct;

    @FindBy(xpath = "//option[@value='variable']")
    public WebElement dropdownVariableProduct;

    @FindBy(id ="__wp-uploader-id-1")
    public WebElement selectFiles;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectButton;

    @FindBy(xpath = "//div[@class='media-frame-content']//li[contains(@class, 'attachment')]//img")
    public WebElement addedImage;

    @FindBy (id= "pro_title")
    public WebElement productTitle;


    public  WebElement shortDescription;















}
