package com.SocialIQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OfferCodeNtValid {
	@Test
	public void FirstNameValidationTest() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		driver. manage().window().maximize();
		driver.get(com.SocialIQ.config.Config.APP_URL);
		long time =System.currentTimeMillis();
		String string1 = "kimiagarwal+"+time+"@gmail.com";
		System.out.println(string1);
		driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys(string1);
		driver.findElement(By.xpath(".//*[@id='firstNameOfCompanyAdmin']")).sendKeys("Kimi");
        driver.findElement(By.xpath(".//*[@id='lastNameOfCompanyAdmin']")).sendKeys("Agarwal");
        driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("IGSoftware");
        driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[12]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[12]/div/div/ul/li[4]/a")).click();
        String string2 = "g"+time+"com";
    	System.out.println(string2);
        driver.findElement(By.xpath(".//*[@id='subDomainName']")).sendKeys(string2);
        driver.findElement(By.xpath(".//*[@id='offerCodeName']")).sendKeys("fst");;
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		WebElement myDElement = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='top']/section/div/div[1]/div/div/ul/li")));
        System.out.println(myDElement.getText());
		String expectedResult = "Offer Code is not valid." ;
		String actualResult = (myDElement.getText());
		Assert.assertEquals(actualResult, expectedResult);
		driver.quit();
		
}
}