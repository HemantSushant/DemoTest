package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.*;


public class RegisterPage extends BasePage{

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    public static String emailAddressError_xpath = "//*[@id=\"create_account_error\"]/ol/li";

    public RegisterPage(BrowserDriver driver) {
        super(driver);
    }

    public static void openApplication() {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    public static void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
    }

    public static void createAccount(String emailid) {
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }


    //______________________

    public static void isEmailErrorMsgAppear() throws InterruptedException {
        String text = driver.findElement(By.xpath(emailAddressError_xpath)).getText();
        assertEquals("Invalid email address.", text);
    }
}
