package acceptanceTests;

import manageWebDriver.InitilaiseWebDriver;
import manageWebDriver.WebDriverOperations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SocialIQ.config.Config;

public class TrialPage
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
	public void AddUserOnTrialPage() throws Exception
	{
		operations.navigateToUrl(Config.FreeTrialPage_URL);
		String emailId = Config.GenerateUniqueEmailId(Config.testmailid);

		operations.setTextInTextBox(".//*[@id='companyAdminEmail']", Config.testmailid);
		operations.setTextInTextBox(".//*[@id='firstNameOfCompanyAdmin']", Config.firstName);
		operations.setTextInTextBox(".//*[@id='lastNameOfCompanyAdmin']", Config.lastName);
		operations.setTextInTextBox(".//*[@id='name']", Config.companyName);

		operations.setTextInTextBox(".//*[@id='website']", "www.google.com");

		operations.setTextInTextBox(".//*[@id='addressInfoCO.streetAddress1']", "A-10");
		operations.setTextInTextBox(".//*[@id='addressInfoCO.city']", "Noida");
		operations.setTextInTextBox(".//*[@id='addressInfoCO.state']", "U.P.");
		operations.setTextInTextBox(".//*[@id='addressInfoCO.zipCode']", "201303");
		operations.clickElementOnPage(".//*[@id='createCompanyProfile']/ul/li[11]/div/button");
		operations.clickElementOnPage(".//*[@id='createCompanyProfile']/ul/li[11]/div/div/ul/li[111]/a");	
		operations.clickElementOnPage(".//*[@id='createCompanyProfile']/ul/li[12]/div/button");
		operations.clickElementOnPage(".//*[@id='createCompanyProfile']/ul/li[12]/div/div/ul/li[4]/a");
           
		String domain = emailId.substring(0, 2);
		System.out.println(domain);

		operations.setTextInTextBox(".//*[@id='subDomainName']", domain);
		operations.setTextInTextBox(".//*[@id='offerCodeName']", Config.offerCode);
		operations.clickElementOnPage(".//*[@id='submit']");
	}
	
	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}

}
