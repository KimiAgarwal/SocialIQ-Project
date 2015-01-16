package acceptanceTests;

import manageWebDriver.InitilaiseWebDriver;
import manageWebDriver.WebDriverOperations;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;

public class LoginPage
{
	InitilaiseWebDriver initializeWebDriver;
	WebDriverOperations operations;
	WebDriver webDriver;

	@BeforeMethod
	public void Setup()
	{
		initializeWebDriver = new InitilaiseWebDriver();
		webDriver = initializeWebDriver.StartWebDriver("firefox");
		operations = new WebDriverOperations(webDriver);
	}

	@Test
	public void RegisteredUserWithAdminExecutiveRightsShouldBeAbleToLoginSuccessfully()
	{
		operations.navigateToUrl(Config.Login_URL);
		
		operations.setTextInTextBox(".//*[@id='username']", Config.AdminExecutiveUserName);
		operations.setTextInTextBox(".//*[@id='password']", Config.AdminExecutivePassword);
		operations.clickElementOnPage(".//*[@id='submitForLoginButton']");
		
		String getUserName = operations.getElementText("//*[@id='navbar-container']/div[2]/ul/li/a/span");		
		Assert.assertEquals(getUserName, "Welcome, Raj Kumar");

		String[] tabControls = new String[]
				{"//*[@id='activeTicketsSpan']","//*[@id='inbox-tabs']/li[2]/a/span",
				"//*[@id='inbox-tabs']/li[3]/a/span","//*[@id='inbox-tabs']/li[4]/a/span",
				"//*[@id='inbox-tabs']/li[5]/a/span","//*[@id='inbox-tabs']/li[6]/a/span",
				"//*[@id='inbox-tabs']/li[7]/a/span"};
		
		for(int i=0; i< tabControls.length; i++)
		{
			Boolean isEnabled = operations.checkIfControlEnabled("//*[@id='activeTicketsSpan']");
			Assert.assertTrue(isEnabled);
		}
	}

	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}
}
