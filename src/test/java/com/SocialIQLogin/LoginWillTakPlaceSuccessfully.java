package com.SocialIQLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class LoginWillTakPlaceSuccessfully {

	
	@Test
	public void LoginNameValidationTest(){
		
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 30L);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("raj@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		driver.quit();
	}
}
