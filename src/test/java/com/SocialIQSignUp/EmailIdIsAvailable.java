package com.SocialIQSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class EmailIdIsAvailable {

	@Test
	public void FirstNameValidationTest1() throws InterruptedException{
		
		WebDriver driver = WebDriverUtil.createWebDriver(Config.FreeTrialPage_URL, 30L);
		
		long time =System.currentTimeMillis();
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys(string1);

	    driver.findElement(By.id("firstNameOfCompanyAdmin")).click();
	    driver.quit();
}
}