package com.SocialIQ;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailIdAlreadyExist {

		
		@Test
		public void FirstNameValidationTest1() throws InterruptedException{
			
			WebDriver driver = new FirefoxDriver();
		//	driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(com.SocialIQ.config.Config.APP_URL);
			driver. manage().window().maximize();
			
			driver.findElement(By.id("companyAdminEmail")).sendKeys("raj@pepsi.com");
		    driver.findElement(By.id("firstNameOfCompanyAdmin")).click();
		    
			WebElement myDElement = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='red']")));
	        System.out.println(myDElement.getText());
	       
			String expectedResult = "Email already exists";
			String actualResult = (myDElement.getText());
			Assert.assertEquals(actualResult, expectedResult);
			driver.quit();
		
		}
		

	}


