package com.SocialIQAddUser;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class SpecialCharacters_Exe_UserHasBeenCreatedSuccessfully {
	
	@Test
	public void AddUserNameValidationTest() throws InterruptedException{
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 20L);
		long time =System.currentTimeMillis();
		
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("raj@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		
		
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a/i"));
		action.moveToElement(we).build().perform();
		WebElement we1 = driver.findElement(By.xpath(".//*[@id='userList']/a"));
		action.moveToElement(we1).click().perform();
		
		driver.findElement(By.xpath(".//*[@id='createUserLink']")).click();
		
		driver.findElement(By.xpath(".//input[@id='firstName']")).sendKeys("@!##@");
		driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys("!@@!#");
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(string1);
		driver.findElement(By.xpath(".//*[@id='enabled']")).click();
		driver.findElement(By.xpath(".//*[@value='ROLE_COMPANY_USER']")).click();
	    driver.findElement(By.xpath(".//*[@id='submitCreate']")).click();
	    
	    Thread.sleep(1000);
		   driver.findElement(By.xpath(".//*[@id='navbar-container']/div[2]/ul/li/a/span")).click();
		   driver.findElement(By.xpath(".//a[@href='/logout/index']")).click();
		  
		   driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(string1);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
			driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
	   
	}
	}

