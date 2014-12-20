package com.SocialIQAddUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class ItIsMandatoryToSelectAtLeastOneRole {

	@Test
	public void AddUserNameValidationTest(){
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 30L);
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
		
		driver.findElement(By.xpath(".//*[@id='firstName']")).sendKeys("kimi");
		driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys("agarwal");
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(string1);
		driver.findElement(By.xpath(".//*[@id='enabled']")).click();
		
	
	    driver.findElement(By.xpath(".//*[@id='submitCreate']")).click();
	    WebElement myDElement = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='error']")));
        System.out.println(myDElement.getText());
		
		//Thread.sleep(3000);
		String expectedResult = "It is mandatory to select atleast one role." ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
	}
}
