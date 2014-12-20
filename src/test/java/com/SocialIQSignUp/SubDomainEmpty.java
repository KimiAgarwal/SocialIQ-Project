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

public class SubDomainEmpty {

	@Test
	public void FirstNameValidationTest() throws InterruptedException{
		
		WebDriver driver = WebDriverUtil.createWebDriver(Config.FreeTrialPage_URL, 30L);
		
		long time =System.currentTimeMillis();
		//driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys("kimi.agarwal@intelligrape.com");
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys(string1);

		driver.findElement(By.xpath(".//*[@id='firstNameOfCompanyAdmin']")).sendKeys("Kimi");
        driver.findElement(By.xpath(".//*[@id='lastNameOfCompanyAdmin']")).sendKeys("Agarwal");
        driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("IG");
        driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[12]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[12]/div/div/ul/li[4]/a")).click();
        
     //   driver.findElement(By.xpath(".//*[@id='subDomainName']")).click();
        driver.findElement(By.xpath(".//*[@id='offerCodeName']")).sendKeys("qwertyjhjvhjjj");
        
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		WebElement myDElement = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@class='red']")));
        System.out.println(myDElement.getText());
		String expectedResult = "Sub Domain Name is empty." ;
		String actualResult = (myDElement.getText());
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
		
	
}
}
