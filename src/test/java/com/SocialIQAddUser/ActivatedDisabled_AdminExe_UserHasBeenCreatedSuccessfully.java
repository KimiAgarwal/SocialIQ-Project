package com.SocialIQAddUser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class ActivatedDisabled_AdminExe_UserHasBeenCreatedSuccessfully {
	
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
		
		driver.findElement(By.xpath(".//input[@id='firstName']")).sendKeys("kimi");
		driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys("agarwal");
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(string1);
		
		
	//	Select 'authorities' Multiple select box ( Use Name locator to identify the element )
		Select oSelection = new Select(driver.findElement(By.name("authorities")));
		
		List<WebElement> oSize = oSelection.getOptions();
	    int iListSize = oSize.size();
 
	    // Setting up the loop to print all the options
 
	    for(int i =0; i < iListSize ; i++)
	    {
 
		    // Storing the value of the option	
 
		    String sValue = oSelection.getOptions().get(i).getText();
 
		    // Printing the stored value
 
		    System.out.println(sValue);
 
		    // Selecting all the elements one by one
 
		    oSelection.selectByIndex(i);
 
	    	}
	    driver.findElement(By.xpath(".//*[@id='submitCreate']")).click();
	    
	    Thread.sleep(1000);
		   driver.findElement(By.xpath(".//*[@id='navbar-container']/div[2]/ul/li/a/span")).click();
		   driver.findElement(By.xpath(".//a[@href='/logout/index']")).click();
		  
		   driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(string1);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
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

