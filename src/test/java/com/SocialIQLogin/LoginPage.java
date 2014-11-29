package com.SocialIQLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {

	@Test
	public void FirstNameValidationTest1() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://app.siq.qa2.intelligrape.net/");
	
	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("raj@mirinda.com");
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("hjfhs");
	driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
	WebElement myDElement = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='flashErrorMessage']")));
    System.out.println(myDElement.getText());
	String expectedResult = "Sorry, we were not able to find a user with that username and password." ;
	String actualResult = (myDElement.getText());
	Assert.assertEquals(actualResult, expectedResult);
	driver.quit();
}
}