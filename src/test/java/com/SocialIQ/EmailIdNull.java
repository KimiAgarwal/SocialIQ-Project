package com.SocialIQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailIdNull {

	@Test
	public void FirstNameValidationTest1() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
	//	driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(com.SocialIQ.config.Config.APP_URL);
		driver. manage().window().maximize();
		
		driver.findElement(By.id("companyAdminEmail")).click();
	    driver.findElement(By.id("firstNameOfCompanyAdmin")).click();
	    WebElement myDElement = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("companyAdminEmailValidation")));
        System.out.println(myDElement.getText());
		
		//Thread.sleep(3000);
		String expectedResult = "Invalid Email Address." ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
	    
}
}


