package com.SocialIQLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class InvalidEmailIdPassword {

	@Test
	public void LoginNameValidationTest(){
		WebDriver driver = WebDriverUtil.createWebDriver(Config.Login_URL, 30L);
		boolean result=false;
		String email[] = {"raj@pepsi.com","raj@pepsi.com","raj@com","raj.com","raj.com","","","","&^^%^$&^$$&%$%$","112123"};
		String pass[] = {"est","","","367","test","yuy","test","","&^^%^$&^$$&%$%$","skakkj"};
		System.out.println(driver.findElement(By.xpath(".//*[@id='username']")));
		System.out.println(driver.findElement(By.xpath(".//*[@id='password']")));
		for(int i = 0 ; i < email.length ; i++){
			
			
				driver.findElement(By.xpath(".//*[@id='username']")).clear();
				driver.findElement(By.xpath(".//*[@id='password']")).clear();
				driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(email[i]);
				
				driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(pass[i]);
				driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
		
				System.out.println( driver.findElement(By.xpath(".//*[@id='flashErrorMessage']")).getText());
				String expectedResult = "Sorry, we were not able to find a user with that username and password.";
				String actualResult = driver.findElement(By.xpath(".//*[@id='flashErrorMessage']")).getText();
		
				if(expectedResult.equals(actualResult)){
					result = true;
					System.out.println("Case Passed for: "+ email[i]);
					System.out.println("Case Passed for: "+ pass[i]);
				}else{
					result = false;
					System.out.println("Case Failed for: "+ email[i]);
					break;
				}
			//}
			Assert.assertEquals(true, result);
		}
		driver.quit();
		
	}
}
