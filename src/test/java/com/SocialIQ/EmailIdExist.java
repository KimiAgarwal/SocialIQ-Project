package com.SocialIQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class EmailIdExist {

	@Test
	public void FirstNameValidationTest1() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
	//	driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(com.SocialIQ.config.Config.APP_URL);
		driver. manage().window().maximize();
		
		long time =System.currentTimeMillis();
		//driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys("kimi.agarwal@intelligrape.com");
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys(string1);

	    driver.findElement(By.id("firstNameOfCompanyAdmin")).click();
	    
}
}