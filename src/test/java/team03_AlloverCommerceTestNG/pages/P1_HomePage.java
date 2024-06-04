package team03_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03_AlloverCommerceTestNG.utilities.Driver;

public class P1_HomePage {



    public P1_HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton;

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccountButton;

  @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;

  @FindBy(xpath = "//span[.='Sign Out']")
   public WebElement signOutfiliz;


@FindBy(id = "reg_username")
    public  WebElement username;


@FindBy(id = "reg_email")
public  WebElement YourEmailaddress;

@FindBy(id = "reg_password")
public  WebElement password;

@FindBy(id = "register-policy")
public  WebElement policybox;
@FindBy(xpath = "//button[@name='register' and @value='Sign Up']")
public WebElement SignUp;
@FindBy(xpath = "//p[@class='submit-status' and contains(text(), 'An account is already registered with that username. Please choose another.')]")
public  WebElement  AnaccountisAlreadyregisteredwiththatusername;
}
