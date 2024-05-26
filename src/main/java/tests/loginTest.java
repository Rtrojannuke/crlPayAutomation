package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseContainer.TestBase;

public class loginTest extends TestBase{
	
	@Test(priority = 2)
	public void inputNumeric() {
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).clear();
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).sendKeys(config.getProperty("numeric"));
		driver.findElement(By.xpath(locator.getProperty("showMessage"))).click();
		String retriv = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(retriv, "2030");
	}
	
	@Test (priority = 3)//(enabled = false)
	public void inputAlphabet() {		
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).clear();
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).sendKeys(config.getProperty("alphabet"));
		driver.findElement(By.xpath(locator.getProperty("showMessage"))).click();
		String retriv = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(retriv, "2030");
	}
	
	@Test(priority = 1)
	public void inputAlphaNumeric() {
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).clear();
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).sendKeys(config.getProperty("alphaNumeric"));
		driver.findElement(By.xpath(locator.getProperty("showMessage"))).click();
	}
	
	@Test(priority = 0)
	public void inputSpecialCharacter() {
		driver.findElement(By.id(locator.getProperty("startPractising"))).click();
		driver.findElement(By.linkText(locator.getProperty("simpleFormDemo"))).click();
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).clear();
		driver.findElement(By.cssSelector(locator.getProperty("inputField"))).sendKeys(config.getProperty("specialCharacter"));
		driver.findElement(By.xpath(locator.getProperty("showMessage"))).click();
	}
	
	

}
