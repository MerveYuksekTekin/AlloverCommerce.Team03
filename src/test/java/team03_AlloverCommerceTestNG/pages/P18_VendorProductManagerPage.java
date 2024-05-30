package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

import java.util.List;

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


    @FindBy(id = "featured_img_display")
    public WebElement addPhotoButton;


    @FindBy(xpath = "(//*[@id='menu-item-browse'])[1]")
    public WebElement menuLibraryButton;

    @FindBy(xpath = "//img[@src='https://allovercommerce.com/wp-content/uploads/2024/05/logo-1-300x237.png']")
    public WebElement logoImage;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement addGalleryPhotoButton;
    @FindBy(xpath = "(//*[@id='menu-item-browse'])[2]")
    public WebElement menuGalleryLibraryButton;
    @FindBy(xpath = "//li[@role='checkbox']")
    public List<WebElement> logoGalleryImage;

    @FindBy(xpath = "(//button[.='Add to Gallery'])[2]")
    public WebElement addToGalleryPhotoButton;

    @FindBy(id= "wcfm_products_simple_submit_button")
    public WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    public WebElement menuProduct;

    @FindBy(className= "wcfm_product_title" )
    public List<WebElement> addedProducts;


    @FindBy(xpath = "//*[.='Inventory']")
    public WebElement menuInventory;
     @FindBy(xpath = "//*[.='Shipping']")
    public WebElement menuShipping;
     @FindBy(xpath = "//div[.='Attributes']")
    public WebElement menuAttributes;
     @FindBy(xpath = "//div[.='Linked']")
    public WebElement menuLinked;

    @FindBy(id ="wcfm_products_manage_form_yoast_head")
      public WebElement menuSEO;

    @FindBy(xpath = "//div[.='Advanced']")
      public WebElement menuAdvanced;

      @FindBy(id = "sku")
      public WebElement boxSku;

      @FindBy(id = "manage_stock")
      public WebElement boxManageStock;

      @FindBy(id = "stock_qty")
      public WebElement boxStockQty;

      @FindBy(id = "backorders")
      public WebElement boxAllowBackorders;

      @FindBy(id = "sold_individually")
      public WebElement boxSoldIndividually;

     @FindBy(id = "stock_status")
      public WebElement boxStockStatus;

      @FindBy(id = "weight")
      public WebElement weightBox;

@FindBy(id = "length")
      public WebElement lengthBox;

@FindBy(xpath = "//input[@name='width']")
      public WebElement widthBox;

@FindBy(id = "height")
      public WebElement heightBox;

@FindBy(id = "shipping_class")
      public WebElement dropdownShipping;

@FindBy(id = "_wcfmmp_processing_time")
      public WebElement dropdownProcessingTime;

@FindBy(id = "attributes_is_active_1")
      public WebElement colorCheckBox;

@FindBy(id = "attributes_is_active_2")
      public WebElement sizeCheckBox;

@FindBy(xpath = "(//input[@placeholder='Search for an attribute ...'])[1]")
      public WebElement colorDropdown;

@FindBy(xpath = "(//*[@class='select2-search__field'])[3]")
      public WebElement sizeDropdown;

@FindBy (id = "attributes_is_visible_1")
      public WebElement visibilityCheckBox1;

@FindBy(id = "attributes_is_visible_2")
      public WebElement visibilityCheckBox2;




}
