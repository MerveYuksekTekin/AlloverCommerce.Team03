package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P12_ComparePage {

    public P12_ComparePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Compare']")
    public WebElement compare;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/a[2]")
    public WebElement startcompare;

    @FindBy(xpath = "//a[@class='compare-clean']")
    public WebElement cleanall;

    @FindBy(xpath = "//a[@data-product_id='14015']")
    public WebElement deleteprocduct;




}
