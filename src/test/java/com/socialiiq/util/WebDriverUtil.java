package com.socialiiq.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

	
	public static WebDriver createWebDriver(String url, Long seconds ){
		WebDriver driver = new FirefoxDriver();
		driver. manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		return driver;
	}
}
