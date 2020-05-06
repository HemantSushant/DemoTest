package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingPage extends BasePage {

    public ShoppingPage(BrowserDriver driver) {
        super(driver);
    }

    public static String menuDress = ".sf-menu > :nth-child(2) > .sf-with-ul";
    public static String quickViewDress_xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img";

    public static void selectMenuItemFromMenuBar() throws InterruptedException {

        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(menuDress));
        WebElement summerDresses = driver.findElement(By.xpath("//*[text()='Summer Dresses']"));
        action.moveToElement(element).perform();

        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("document.querySelector('ul.submenu-container.clearfix.first-in-line-xs > li > a[title~=Summer]').click();", summerDresses);

    }

    public static String getCategoryTitle() {
        return getText(driver.findElement(By.className("cat-name")));
    }

    public static void selectOneDress() {
        WebElement dress = driver.findElement(By.xpath(quickViewDress_xpath));
        waitAndClick(dress);
    }

    public static void selectBlueColour() {

        switchToFrame();
        WebElement color = driver.findElement(By.id("color_14"));
        waitAndClick(color);
        switchToMainFrame();
    }

    public static void addToCart() {
        switchToFrame();

        driver.findElement(By.id("add_to_cart")).click();
        switchToMainFrame();
    }

    public static String getItemQuantity() {
        return getText(driver.findElement(By.id("layer_cart_product_quantity")));
    }

    public static String getItemName() {
        return getText(driver.findElement(By.id("layer_cart_product_title")));
    }

    public static String getItemColor() {
        return getText(driver.findElement(By.id("layer_cart_product_attributes")));
    }
}
