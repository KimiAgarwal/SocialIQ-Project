package com.SocialIQSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;
import com.socialiiq.util.WebDriverUtil;

public class TrialPage {

	@Test
	public void FirstNameValidationTest() throws InterruptedException{
	WebDriver driver = WebDriverUtil.createWebDriver(Config.FreeTrialPage_URL, 30L);
	long time =System.currentTimeMillis();

	String string1 = "kimiagarwal+"+time+"@gmail.com";
	System.out.println(string1);
	driver.findElement(By.xpath(".//*[@id='companyAdminEmail']")).sendKeys(string1);

	driver.findElement(By.xpath(".//*[@id='firstNameOfCompanyAdmin']")).sendKeys("Kimi");
    driver.findElement(By.xpath(".//*[@id='lastNameOfCompanyAdmin']")).sendKeys("Agarwal");
    driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("IG");
    driver.findElement(By.xpath(".//*[@id='website']")).clear();
    driver.findElement(By.xpath(".//*[@id='website']")).sendKeys("www.google.com");
    driver.findElement(By.xpath(".//*[@id='addressInfoCO.streetAddress1']")).sendKeys("A-10");
    driver.findElement(By.xpath("//input[@id='addressInfoCO.streetAddress2']")).sendKeys("A-10");
    driver.findElement(By.xpath(".//*[@id='addressInfoCO.city']")).sendKeys("Noida");
    driver.findElement(By.xpath(".//*[@id='addressInfoCO.state']")).sendKeys("U.P.");
    driver.findElement(By.xpath(".//*[@id='addressInfoCO.zipCode']")).sendKeys("201303");
    driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[11]/div/button")).click();
    driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[11]/div/div/ul/li[111]/a")).click();
    driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[12]/div/button")).click();
    driver.findElement(By.xpath(".//*[@id='createCompanyProfile']/ul/li[12]/div/div/ul/li[4]/a")).click();
           
    String string2 = "g"+time+"com";
	System.out.println(string2);
    driver.findElement(By.xpath(".//*[@id='subDomainName']")).sendKeys(string2);
    driver.findElement(By.xpath(".//*[@id='offerCodeName']")).sendKeys("qwerty");
	driver.findElement(By.xpath(".//*[@id='submit']")).click();
	
	driver.navigate().to("http://app.siq.qa2.intelligrape.net");
	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(string1);
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test");
	driver.findElement(By.xpath(".//*[@id='submitForLoginButton']")).click();
//	driver.quit();
	
	driver.findElement(By.xpath(".//button[@data-role='end']")).click();
   
	
}

}
