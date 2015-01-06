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

public class FieldsAreMandatory {

	@Test
	public void AddUserNameValidationTest(){
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 20L);
	//	long time =System.currentTimeMillis();
		
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("raj@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		
		
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a/i"));
		action.moveToElement(we).build().perform();
		WebElement we1 = driver.findElement(By.xpath(".//*[@id='userList']/a"));
		action.moveToElement(we1).click().perform();
		
		driver.findElement(By.xpath(".//*[@id='createUserLink']")).click();
		
	    driver.findElement(By.xpath(".//*[@id='submitCreate']")).click();
	    WebElement myDElement = new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createUserForm']/div[1]/div[2]/div/label")));
        System.out.println(myDElement.getText());
        WebElement myDElement1 = new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createUserForm']/div[1]/div[4]/div/label")));
        System.out.println(myDElement1.getText());
	    WebElement myDElement2 = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createUserForm']/div[1]/div[8]/div/label")));
        System.out.println(myDElement2.getText());
		
		//Thread.sleep(3000);
        String expectedResult = "First Name is mandatory" ;
		String actualResult = (myDElement.getText());
		String expectedResult1 = "User Name is mandatory" ;
		String actualResult1 = (myDElement1.getText());
		String expectedResult2 = "It is mandatory to select atleast one role." ;
		String actualResult2 = (myDElement2.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		Assert.assertEquals(actualResult1, expectedResult1);
		Assert.assertEquals(actualResult2, expectedResult2);
		driver.quit();
	}
}
