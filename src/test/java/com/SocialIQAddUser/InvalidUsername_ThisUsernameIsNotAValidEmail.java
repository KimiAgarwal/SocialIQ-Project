package com.SocialIQAddUser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class InvalidUsername_ThisUsernameIsNotAValidEmail {

//	private String expectedResult;

	@Test
	public void AddUserNameValidationTest() throws InterruptedException{
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 30L);
		
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("raj@pepsi.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a/i"));
		action.moveToElement(we).build().perform();
		WebElement we1 = driver.findElement(By.xpath(".//*[@id='userList']/a"));
		action.moveToElement(we1).click().perform();
		
		driver.findElement(By.xpath(".//*[@role='button']")).click();
		
		driver.findElement(By.xpath(".//input[@name='firstName']")).sendKeys("kimi");
		driver.findElement(By.xpath(".//input[@id='lastName']")).sendKeys("agarwal");
		
		driver.findElement(By.xpath(".//input[@id='username']")).sendKeys("intelligrape.com");
		driver.findElement(By.xpath(".//input[@id='enabled']")).click();
		
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

	    Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath(".//div[@style='display: block;'][contains(text(),'This username is not a valid email.')]")).getText());
	//	System.out.println(driver.findElement(By.xpath(".//form[@id='editUserForm']/div[1]/div[1]")).getText());
       
        @SuppressWarnings("unused")
		String expectedResult = "This username is not a valid email.";
		

		driver.close();
	}
}
