package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Random;

public class BasePage extends BrowserDriver{

	public BasePage(BrowserDriver driver){
		super(driver);
	}

	public static int generateRandomIntIntRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void switchToFrame(){
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
	}

	public static void switchToMainFrame(){
		driver.switchTo().defaultContent();
	}

	public static void waitForElementVisible(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void waitAndClick(WebElement webElement) {
		waitForElementVisible(webElement);
		webElement.click();
	}

	public static String getText(WebElement webElement) {
		waitForElementVisible(webElement);
		return webElement.getText().trim();
	}
}
