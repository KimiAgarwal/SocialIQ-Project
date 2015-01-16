package acceptanceTests;

import java.util.List;

import manageWebDriver.InitilaiseWebDriver;
import manageWebDriver.WebDriverOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;

public class CreateResponseTemplates
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
	public void AdminShouldBeAbleToAddResponseTemplate() throws InterruptedException
	{
		operations.navigateToUrl(Config.Login_URL);

		operations.setTextInTextBox(".//*[@id='username']", Config.AdminExecutiveUserName);
		operations.setTextInTextBox(".//*[@id='password']", Config.AdminExecutivePassword);
		operations.clickElementOnPage(".//*[@id='submitForLoginButton']");

		String getUserName = operations.getElementText("//*[@id='navbar-container']/div[2]/ul/li/a/span");	
		Assert.assertEquals(getUserName, "Welcome, Raj Kumar");

		operations.clickElementOnPage("//*[@id='sidebar']/ul/li[3]/a/i");
		operations.clickElementOnPage("//*[@id='cannedResponseListInLi']/a");
		Thread.sleep(2000);

		operations.clickElementOnPage("//*[@id='createCannedResponseLink']");

		String templateName = "TestTemplate" + Config.generateARandomString();
		operations.setTextInTextBox("//*[@id='name']", templateName);
		
		String channel = "TWITTER";
		operations.selectTextByValueFromDropdown("//*[@id='channel']", channel);

		operations.setTextInTextBox("//*[@id='text']", "Whatever");
		operations.clickElementOnPage("//*[@id='submitCreate']");
		Thread.sleep(2000);
		
		List<WebElement> tableRows = operations.getTableControl("//*[@id='sample-table-1']");
		
		WebElement responseTemplateAdded = tableRows.get(tableRows.size() - 1);
		System.out.println("Last Row of the table is : " + responseTemplateAdded.getText());
		
		Assert.assertTrue(responseTemplateAdded.getText().toLowerCase().contains(templateName.toLowerCase()));
		Assert.assertTrue(responseTemplateAdded.getText().toLowerCase().contains(channel.toLowerCase()));
	}
	
	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}
}
