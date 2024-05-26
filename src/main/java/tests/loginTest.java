package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseContainer.TestBase;

public class loginTest extends TestBase{
	
	@Test(priority = 2)
	public void inputNumeric() {
		driver.findElement(By.cssSelector("#user-message")).clear();
		driver.findElement(By.cssSelector("#user-message")).sendKeys("2030");
		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
		String retriv = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(retriv, "2030");
	}
	
	@Test (priority = 3)//(enabled = false)
	public void inputAlphabet() {
		driver.findElement(By.cssSelector("#user-message")).clear();
		driver.findElement(By.cssSelector("#user-message")).sendKeys("Mubarak");
		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
		String retriv = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(retriv, "2030");
	}
	
	@Test(priority = 1)
	public void inputAlphaNumeric() {
		driver.findElement(By.cssSelector("#user-message")).clear();
		driver.findElement(By.cssSelector("#user-message")).sendKeys("Mubarak2030");
		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
	}
	
	@Test(priority = 0)
	public void inputSpecialCharacter() {
		driver.findElement(By.id("btn_basic_example")).click();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		driver.findElement(By.cssSelector("#user-message")).clear();
		driver.findElement(By.cssSelector("#user-message")).sendKeys("$$$$$$$$");
		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
	}
	
	

}
