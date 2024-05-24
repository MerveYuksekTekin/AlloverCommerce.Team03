package team03_AlloverCommerceTestNG.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import team03_AlloverCommerceTestNG.pages.Pages;
import team03_AlloverCommerceTestNG.utilities.ConfigReader;
import team03_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US16_AddSimpleProduct {

    Pages allPages = new Pages();
    @Test
    public void test01() {
        ReusableMethods.userVendorlogin(ConfigReader.getProperty("us11email"), "234");
        allPages.homePage().signInButton.click();
        allPages.userVendorLoginPage().emailBox.sendKeys("al");
        allPages.userVendorLoginPage().passwordBox.sendKeys("32");
        allPages.userVendorLoginPage().signInButton.click();
       // Web sitesine git
       // Kayitli vendor bilgileriyle giris yap
        // Sign out a tiklayarak My account sayfasina gir
        //Sol taraftaki listeden Store Manager i tikla
       // My Store kisminda Products i tikla
       // Gelen sayfanin sag tarafindaki Add New butonunu tikla

       // Add Product sayfasindaki ilk dropdown menusunde Simple Product seceneginin default olarak gorundugunu dogrula

    }
}
