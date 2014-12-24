package com.SocialIQCreateCategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllFieldsAreMandatory {
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
	
		driver.findElement(By.id("submitCreateCategory")).click();
		
		WebElement myDElement = new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createCategoryForm']/div[2]/div/label")));
	    System.out.println(myDElement.getText());
	    WebElement myDElement1 = new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createCategoryForm']/div[4]/label[2]")));
	    System.out.println(myDElement1.getText());
		WebElement myDElement2 = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createCategoryForm']/div[12]/div/label")));
	    System.out.println(myDElement2.getText());
	    WebElement myDElement3 = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createCategoryForm']/div[14]/div/label")));
	    System.out.println(myDElement3.getText());
	    WebElement myDElement4 = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createCategoryForm']/div[16]/div/label")));
	    System.out.println(myDElement4.getText());
			//Thread.sleep(3000);
	    String expectedResult = "Name is required" ;
		String actualResult = (myDElement.getText());
		String expectedResult1 = "Catch words are required" ;
		String actualResult1 = (myDElement1.getText());
		String expectedResult2 = "Threshold Response Time is required" ;
		String actualResult2 = (myDElement2.getText());
		String expectedResult3 = "Threshold Closure Time is required" ;
		String actualResult3 = (myDElement3.getText());
		String expectedResult4 = "Threshold Response Time For Internal Collaboration is required" ;
		String actualResult4 = (myDElement4.getText());
			
		Assert.assertEquals(actualResult, expectedResult);
		Assert.assertEquals(actualResult1, expectedResult1);
		Assert.assertEquals(actualResult2, expectedResult2);
		Assert.assertEquals(actualResult3, expectedResult3);
		Assert.assertEquals(actualResult4, expectedResult4);
		driver.quit();
		
	}
}
