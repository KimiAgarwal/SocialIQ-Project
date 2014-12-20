package com.SocialIQLogin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class SorryYouAccountIsDisabled_InvalidPassword {

	@Test
	public void LoginNameValidationTest(){
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 30L);
		
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("john@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("jnkndfkjtest");
		driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		
		WebElement myDElement = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='flashErrorMessage']")));
        System.out.println(myDElement.getText());
		
		//Thread.sleep(3000);
		String expectedResult = "Sorry, your account is disabled." ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
	}
}
