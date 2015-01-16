package manageWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitilaiseWebDriver
{
	WebDriver webDriver;
	
	public WebDriver StartWebDriver()
	{
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		return webDriver;
	}
	
	public WebDriver StartWebDriver(String browserType)
	{
		switch(browserType)
		{
		case "firefox":
			webDriver = new FirefoxDriver();
			webDriver.manage().window().maximize();
			return webDriver;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "G:/SocialIQ/socialiq-testing/src/test/java/com/socialiiq/util/chromedriver.exe");
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			return webDriver;
			
		case "ie":
			System.setProperty("webdriver.ie.driver", "G:/SocialIQ/socialiq-testing/src/test/java/com/socialiiq/util/IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();
			webDriver.manage().window().maximize();
			return webDriver;
			
			default:
				webDriver = new FirefoxDriver();
				webDriver.manage().window().maximize();
				return webDriver;
		}
	}
	
	public void StopWebrDriver()
	{
		webDriver.quit();
	}
}
