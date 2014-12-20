package com.SocialIQForgetPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class YourPasswordResetEmailWasSent {

	@Test
	public void EmailNameValidationTest() throws InterruptedException{
		
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 30L);
		driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div/div[2]/a")).click();
		driver.findElement(By.id("userNameForEmail")).sendKeys("raj@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='sendEmailButton']")).click();
		WebElement myDElement = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='fashSuccessMessage']")));
        System.out.println(myDElement.getText());
		
		Thread.sleep(3000);
		String expectedResult = "Your password reset email was sent - check your mail!" ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
}
}
