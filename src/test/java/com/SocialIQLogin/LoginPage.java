package com.SocialIQLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginPage {

	@Test
	public void FirstNameValidationTest1() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://app.siq.qa2.intelligrape.net/");
	
}
}