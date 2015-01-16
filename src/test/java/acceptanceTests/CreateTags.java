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

public class CreateTags
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
	public void AdminShouldBeAbleToCreateTags() throws InterruptedException
	{
		operations.navigateToUrl(Config.Login_URL);

		operations.setTextInTextBox(".//*[@id='username']", Config.AdminExecutiveUserName);
		operations.setTextInTextBox(".//*[@id='password']", Config.AdminExecutivePassword);
		operations.clickElementOnPage(".//*[@id='submitForLoginButton']");

		String getUserName = operations.getElementText("//*[@id='navbar-container']/div[2]/ul/li/a/span");	
		Assert.assertEquals(getUserName, "Welcome, Raj Kumar");

		operations.clickElementOnPage("//*[@id='sidebar']/ul/li[3]/a/i");
		operations.clickElementOnPage("//*[@id='tagsList']/a");
		Thread.sleep(2000);

		operations.clickElementOnPage("//*[@id='createCategoryLink']");
		Thread.sleep(2000);

		String tagName = "TestTag" + Config.generateARandomString();
		operations.setTextInTextBox("//*[@id='name']", tagName);

		String tagType = "LOCATION";
		operations.selectTextByValueFromDropdown("//*[@id='tagType']", tagType);
		operations.setTextInTextBox("//*[@id='createTagForm']/div[2]/div[4]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createTagForm']/div[2]/div[4]/div/div/input[2]");
		operations.setTextInTextBox("//*[@id='createTagForm']/div[2]/div[4]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createTagForm']/div[2]/div[4]/div/div/input[2]");
		
		operations.clickElementOnPage("//*[@id='submitCreate']");
		Thread.sleep(2000);

		List<WebElement> tableRows = operations.getTableControl("//*[@id='sample-table-1']");
		
		WebElement tagAdded = tableRows.get(tableRows.size() - 1);
		System.out.println("The last row of the table is : " + tagAdded.getText());

		Assert.assertTrue(tagAdded.getText().contains(tagName));
		Assert.assertTrue(tagAdded.getText().toLowerCase().contains(tagType.toLowerCase()));
	}

	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}
}
