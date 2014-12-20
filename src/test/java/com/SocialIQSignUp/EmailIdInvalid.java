package com.SocialIQSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class EmailIdInvalid {

	@Test
	public void FirstNameValidationTest2() throws InterruptedException{
		
		WebDriver driver = WebDriverUtil.createWebDriver(Config.FreeTrialPage_URL, 30L);
		
    	driver.findElement(By.id("companyAdminEmail")).sendKeys("raj.com");
	
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