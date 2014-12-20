package com.SocialIQForgetPassword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailInvalid {

	@Test
	public void EmailNameValidationTest() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		driver. manage().window().maximize();
		driver.get(com.SocialIQ.config.Config.Login_URL);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div/div[2]/a")).click();
		driver.findElement(By.id("userNameForEmail")).sendKeys("a.com");
		driver.findElement(By.xpath(".//*[@id='sendEmailButton']")).click();
		WebElement myDElement = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style='']")));
        System.out.println(myDElement.getText());
		
		String expectedResult = "Username not exist" ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
}
}
