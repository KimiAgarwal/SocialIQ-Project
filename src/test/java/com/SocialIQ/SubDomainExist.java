package com.SocialIQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SubDomainExist {

	@Test
	public void FirstNameValidationTest() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		driver. manage().window().maximize();
		driver.get(com.SocialIQ.config.Config.APP_URL);
		
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
        String string2 = "g"+time+"com";
    	System.out.println(string2);
        driver.findElement(By.xpath(".//*[@id='subDomainName']")).sendKeys(string2);
        driver.findElement(By.xpath(".//*[@id='offerCodeName']")).sendKeys("qwerty");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		
		driver.quit();
		
}
}