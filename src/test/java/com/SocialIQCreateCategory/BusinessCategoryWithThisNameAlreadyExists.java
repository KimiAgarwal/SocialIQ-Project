package com.SocialIQCreateCategory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessCategoryWithThisNameAlreadyExists {
	@Test
	public void AddUserNameValidationTest() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver. manage().window().maximize();
		driver.get("http://app.siq.qa2.intelligrape.net");
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("raj@pepsi.com");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("submitForLoginButton")).click();
		
		
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a/i"));
		action.moveToElement(we).build().perform();
		WebElement we1 = driver.findElement(By.xpath(".//*[@id='categoriesList']/a"));
		action.moveToElement(we1).click().perform();
		
		driver.findElement(By.id("createCategoryLink")).click();
		driver.findElement(By.id("name")).sendKeys("un-categorized");
		
		
		WebElement input = driver.findElement(By.xpath(".//*[@id='createCategoryForm']/div[4]/div/div/input[2]"));
		String email[] = {"stage"};
		for(int i=0; i<email.length; i++){
		input.clear();
		input.sendKeys(email[i]); // the value we want to set to input"
		input.sendKeys(Keys.RETURN);}		
		
		WebElement myDElement = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//label[@class='error']")));
		System.out.println(myDElement.getText());
		String expectedResult = "Business Category with this name already exists." ;
		String actualResult = (myDElement.getText());
		//Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
	}
}
