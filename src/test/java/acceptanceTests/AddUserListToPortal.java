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

public class AddUserListToPortal
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
	public void AddUsersToUserListPage() throws InterruptedException
	{
		operations.navigateToUrl(Config.Login_URL);
		
		operations.setTextInTextBox(".//*[@id='username']", Config.AdminExecutiveUserName);
		operations.setTextInTextBox(".//*[@id='password']", Config.AdminExecutivePassword);
		operations.clickElementOnPage(".//*[@id='submitForLoginButton']");
		
		Thread.sleep(2000);
		String getUserName = operations.getElementText("//*[@id='navbar-container']/div[2]/ul/li/a/span");		
		Assert.assertEquals(getUserName, "Welcome, Raj Kumar");
		
		operations.clickElementOnPage("//*[@id='sidebar']/ul/li[3]/a/i");
		operations.clickElementOnPage("//*[@id='userList']/a");
		Thread.sleep(2000);
		
		operations.clickElementOnPage("//*[@id='createUserLink']");
		Thread.sleep(2000);

		String firstName = Config.UserListAdminUserFirstName + Config.generateARandomString();
		String lastName = Config.UserListAdminUserLastName + Config.generateARandomString();
		String userName = Config.generateARandomString() + Config.UserListUserName;
		String rights = "Administrator, Executive";
		operations.setTextInTextBox("//*[@id='firstName']", firstName);
		operations.setTextInTextBox("//*[@id='lastName']", lastName);
		operations.setTextInTextBox("//*[@id='username']", userName);
		operations.clickElementOnPage("//*[@id='enabled']");
		operations.clickElementOnPage("//*[@id='authorities']/option[1]");
		operations.clickElementOnPage("//*[@id='authorities']/option[2]");
		operations.clickElementOnPage("//*[@id='submitCreate']");
		Thread.sleep(3000);

		List<WebElement> tableRows = operations.getTableControl("//*[@id='sample-table-1']");

		verifyUserAddedCorrectly(firstName, lastName, userName, rights,tableRows);
	}
	
	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}
	
	private void verifyUserAddedCorrectly(String firstName, String lastName, String userName, String rights, List<WebElement> tableRows)
	{
		WebElement addedUser = tableRows.get(tableRows.size() -1);
		Assert.assertTrue(addedUser.getText().contains(firstName));
		Assert.assertTrue(addedUser.getText().contains(lastName));
		Assert.assertTrue(addedUser.getText().contains(userName));
		Assert.assertTrue(addedUser.getText().contains(rights));
	}
}
