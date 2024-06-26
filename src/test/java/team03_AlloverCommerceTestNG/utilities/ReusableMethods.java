package team03_AlloverCommerceTestNG.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import team03_AlloverCommerceTestNG.pages.Pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static Pages allPages = new Pages();
    public static void userVendorlogin(String email, String password) {
        allPages.userVendorLoginPage().emailBox.sendKeys(email);
        allPages.userVendorLoginPage().passwordBox.sendKeys(password);
        allPages.userVendorLoginPage().signInButton.click();
    }


   
    public static void userVendorLogout(){
        ReusableMethods.click(allPages.homePage().signOutButton);
        ReusableMethods.click(allPages.myAccountPage().logoutButton);


    }

    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    public void createExtentReport(String testName, String qaName, String name){
        //Bu objecti raporlari olusturmak ve yönetmek icin kullanacağız
        extentReports = new ExtentReports();

        //Oncelikle olusturmak istedigimiz html report projemizde nerede saklamak istiyorsak bir dosya yolu olusturmaliyz
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(  LocalDateTime.now());
        String path =name+"target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentsReports'a html raporlayici ekler,ve bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //HTML raporun belge basligini ayarlar
        extentHtmlReporter.config().setDocumentTitle("Allover Commerce Test Raporu");

        //Raporda gösterilecek olan genel basligi ayarlar
        extentHtmlReporter.config().setReportName("My Extent Report");

        //Bu html raporunda görmek isteyebileceğimz diger bilgileri asagidaki sekilde ekleyebiliriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer ",qaName);

        //AmazonTest adinda yeni bir test olusturur ve Test Steps aciklamasini ekler
        extentTest = extentReports.createTest(testName,"Test Steps");
    }
    //HARD WAIT METHOD
    public static void waitForSecond(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
   /*
       Select select2 = new Select(gun);
       select2.selectByVisibleText("7");
       //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
    */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }
    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS
    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //Tüm Sayfa ScreenShot
    public static void screenShot(String name) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/techproed/testOutputs/Screenshots/" + name + date + ".png";
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebElement ScreenShot
//webelement screenshot
    public static void   screenShotOfWebElement(WebElement webElement){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/techproed/testOutputs/webElementScreenshots/" +  date + ".png";
        try {
            Files.write(  Paths.get(dosyaYolu) , webElement.getScreenshotAs(OutputType.BYTES) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }
    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }
    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }
    //JS SetAttributeValue
    public static void setAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }
    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }


    //File Upload Robot Class
    public void uploadFilePath(String dosyaYolu) {
        try {
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }


    //extent rapora ekran görüntüsü ekleme
    public void addScreenShotToReport() {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\NEWW" + date + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + path);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //rapora Webelement screen shot ekleme
    public void addScreenShotOfWebElementToReport(WebElement webElement) {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\webElementSS" + date + ".png";
        try {
            Files.write(Paths.get(path), webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void vendorRegisterEmail(){
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.fakemail.net/");
        String email=Driver.getDriver().findElement(By.id("email")).getText();
        ReusableMethods.switchToWindow(0);
        allPages.vendorRegisterPage().emailBox.sendKeys(email);
    }
    public static void vendorRegisterCode(){
        ReusableMethods.switchToWindow(1);
        visibleWait(By.xpath("(//tr[@data-href='2'])[1]"), 10);
        click(Driver.getDriver().findElement(By.xpath("(//tr[@data-href='2'])[1]")));
       // Driver.getDriver().findElement(By.xpath("(//tr[@data-href='2'])[1]")).click();
        Driver.getDriver().switchTo().frame("iframeMail");
        visibleWait(By.tagName("b"), 10);
        String code = Driver.getDriver().findElement(By.tagName("b")).getText();

        Driver.getDriver().switchTo().defaultContent();
        click(Driver.getDriver().findElement(By.cssSelector("span.glyphicon.glyphicon-share-alt.zavriOkno.zrcadli")));
        click(Driver.getDriver().findElement(By.cssSelector("a[href='/delete']")));
        waitForSecond(2);
        Driver.getDriver().close();
        ReusableMethods.switchToWindow(0);
        allPages.vendorRegisterPage().verificationCodeBox.sendKeys(code);
    }
    public static String emailAndCodeMessage(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String dynamicText = (String) jsExecutor.executeScript(
                "return document.querySelector('.wcfm-message.email_verification_message').textContent;"
        );
        return dynamicText;
    }

    public static String passwordWrongMessage(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String dynamicText = (String) jsExecutor.executeScript(
                "return document.querySelector('.wcfm-message.wcfm-error').textContent;");
        return dynamicText;
    }

    public static void logOut(){
        allPages.homePage().signOutButton.click();
        allPages.myAccountPage().logoutButton.click();
    }


    public static void cartAndCheckout(){

        allPages.vendorProductDashboardPage().cart.click();
        allPages.vendorCouponsPage().checkoutButton.click();
    }

    public static void addProductToCart(){

        ReusableMethods.click(allPages.vendorProductDashboardPage().searchBox);
        allPages.vendorCouponsPage().search.sendKeys(ConfigReader.getProperty("iphone"));
        allPages.vendorCouponsPage().search.submit();
        ReusableMethods.click(allPages.productPage().urun);
        ReusableMethods.click(allPages.vendorProductDashboardPage().addToCartButton);

    }

}
