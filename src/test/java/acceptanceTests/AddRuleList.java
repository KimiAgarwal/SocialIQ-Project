package acceptanceTests;

import manageWebDriver.InitilaiseWebDriver;
import manageWebDriver.WebDriverOperations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;

public class AddRuleList
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
	public void AdminShouldBeAbleToCreateRule() throws InterruptedException
	{
		operations.navigateToUrl(Config.Login_URL);

		operations.setTextInTextBox(".//*[@id='username']", Config.AdminExecutiveUserName);
		operations.setTextInTextBox(".//*[@id='password']", Config.AdminExecutivePassword);
		operations.clickElementOnPage(".//*[@id='submitForLoginButton']");

		String getUserName = operations.getElementText("//*[@id='navbar-container']/div[2]/ul/li/a/span");	
		Assert.assertEquals(getUserName, "Welcome, Raj Kumar");

		operations.clickElementOnPage("//*[@id='sidebar']/ul/li[3]/a/i");
		operations.clickElementOnPage("//*[@id='ruleBuilderListInLi']/a");
		Thread.sleep(2000);
		
		operations.clickElementOnPage("//*[@id='createUserLink']");
		Thread.sleep(2000);
		
		String ruleName = "TestRule" + Config.generateARandomString();
		operations.setTextInTextBox("//*[@id='name']", ruleName);
		
		String businessCategory = "Shipping";
		operations.selectTextByValueFromDropdown("//*[@id='businessCategoryIdsUl']/li/div/button", businessCategory);
		
		operations.setTextInTextBox("//*[@id='createRuleForm']/div[3]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createRuleForm']/div[3]/div/div/input[2]");
		operations.setTextInTextBox("//*[@id='createRuleForm']/div[3]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createRuleForm']/div[3]/div/div/input[2]");
		operations.setTextInTextBox("//*[@id='createRuleForm']/div[3]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createRuleForm']/div[3]/div/div/input[2]");
		
		operations.selectTextByValueFromDropdown("//*[@id='senderIdsUl']/li/div/button", businessCategory);
		
		operations.clickElementOnPage("//*[@id='isValidated']");
		operations.clickElementOnPage("//*[@id='isEnabled']");
		
		//String channel = "TWITTER";
		//operations.selectTextByValueFromDropdown("//*[@id='channelsUl']/li/div/button", channel);
		
		operations.clickElementOnPage("//*[@id='originalMediumsUl']/li/div/button");
		operations.clickElementOnPage("//*[@id='originalMediumsUl']/li/div/ul/li[2]/a/label");
	}

	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}
}
