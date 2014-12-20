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

public class SubDomainInvalid {

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
        driver.findElement(By.xpath(".//*[@id='subDomainName']")).sendKeys("kf)%*)%*");
        driver.findElement(By.id("offerCodeName")).sendKeys("fird");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		WebElement myDElement = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='red freeTrialError']/ul[1]/li")));
        System.out.println(myDElement.getText());
		String expectedResult = "Sub Domain name includes any letter, numbers between 0 and 9, and the symbol \"-\". The symbol \"-\" neither start nor end with the character \"-\"." ;
		String actualResult = (myDElement.getText());
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
}
}