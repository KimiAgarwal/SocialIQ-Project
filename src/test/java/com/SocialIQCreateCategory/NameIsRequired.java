package com.SocialIQCreateCategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NameIsRequired {
	@Test
	public void AddUserNameValidationTest() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver. manage().window().maximize();
		driver.get("http://app.siq.qa2.intelligrape.net");
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		long time =System.currentTimeMillis();
		
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("raj@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a/i"));
		action.moveToElement(we).build().perform();
		WebElement we1 = driver.findElement(By.xpath(".//*[@id='categoriesList']/a"));
		action.moveToElement(we1).click().perform();
		driver.findElement(By.xpath(".//*[@id='createCategoryLink']")).click();		
		
		//Catch words
		WebElement input = driver.findElement(By.xpath(".//*[@id='createCategoryForm']/div[4]/div/div/input[2]"));
		String email[] = {"de"+time+"ad","re"+time+"ad"};
		for(int i=0; i<email.length; i++){
		input.clear();
		input.sendKeys(email[i]); // the value we want to set to input"
		input.sendKeys(Keys.RETURN);}
				
		//Assignee
		Select oSelection = new Select(driver.findElement(By.xpath(".//*[@id='assigneeId']")));
		oSelection.selectByVisibleText("Raj Kumar");
		
		driver.findElement(By.xpath(".//*[@id='redirectionEmail']")).sendKeys("match@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='enableEmailAlerts']")).click();
		driver.findElement(By.xpath(".//*[@id='businessCategoryKPISettings.thresholdResponseTime']")).sendKeys("10");
		driver.findElement(By.xpath(".//*[@id='businessCategoryKPISettings.thresholdClosureTime']")).sendKeys("10");
		driver.findElement(By.xpath(".//*[@id='businessCategoryKPISettings.thresholdResponseTimeForInternalCollaboration']")).sendKeys("10");
		driver.findElement(By.id("submitCreateCategory")).click();
		
		WebElement myDElement = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='error']")));
		System.out.println(myDElement.getText());
		String expectedResult = "Name is required" ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
	}
}
