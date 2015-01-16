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

public class CreateCategory
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
	public void AdminShouldBeAbleToAddCatergoryToPortal() throws InterruptedException
	{
		operations.navigateToUrl(Config.Login_URL);
		
		operations.setTextInTextBox(".//*[@id='username']", Config.AdminExecutiveUserName);
		operations.setTextInTextBox(".//*[@id='password']", Config.AdminExecutivePassword);
		operations.clickElementOnPage(".//*[@id='submitForLoginButton']");
		
		String getUserName = operations.getElementText("//*[@id='navbar-container']/div[2]/ul/li/a/span");	
		Assert.assertEquals(getUserName, "Welcome, Raj Kumar");
		
		operations.clickElementOnPage("//*[@id='sidebar']/ul/li[3]/a/i");
		operations.clickElementOnPage("//*[@id='categoriesList']/a");
		Thread.sleep(2000);
		
		operations.clickElementOnPage("//*[@id='createCategoryLink']");
		Thread.sleep(2000);
		
		String categoryName = "TestCategory" + Config.generateARandomString();
		operations.setTextInTextBox("//*[@id='name']", categoryName);
		operations.setTextInTextBox("//*[@id='createCategoryForm']/div[4]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createCategoryForm']/div[4]/div/div/input[2]");
		operations.setTextInTextBox("//*[@id='createCategoryForm']/div[4]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createCategoryForm']/div[4]/div/div/input[2]");
		operations.setTextInTextBox("//*[@id='createCategoryForm']/div[4]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createCategoryForm']/div[4]/div/div/input[2]");
		operations.setTextInTextBox("//*[@id='createCategoryForm']/div[4]/div/div/input[2]", Config.generateARandomString());
		operations.PressEnter("//*[@id='createCategoryForm']/div[4]/div/div/input[2]");
		
		//Setting response time for category created
		operations.selectTextByValueFromDropdown("//*[@id='thresholdResponseTimeOnCreateDays']", "1");
		operations.selectTextByValueFromDropdown("//*[@id='thresholdResponseTimeOnCreateHours']","1");
		operations.selectTextByValueFromDropdown("//*[@id='thresholdResponseTimeOnCreateMinutes']","1");
		
		//Setting closure time for category created
		operations.selectTextByValueFromDropdown("//*[@id='thresholdClosureTimeOnCreateDays']", "1");
		operations.selectTextByValueFromDropdown("//*[@id='thresholdClosureTimeOnCreateHours']","1");
		operations.selectTextByValueFromDropdown("//*[@id='thresholdClosureTimeOnCreateMinutes']","1");
		
		//Setting collaboration time for category created
		operations.selectTextByValueFromDropdown("//*[@id='thresholdResponseTimeForInternalCollaborationOnCreateDays']", "1");
		operations.selectTextByValueFromDropdown("//*[@id='thresholdResponseTimeForInternalCollaborationOnCreateHours']","1");
		operations.selectTextByValueFromDropdown("//*[@id='thresholdResponseTimeForInternalCollaborationOnCreateMinutes']","1");

		String collboratorEmail = Config.GenerateUniqueEmailId(Config.CollaboratorEmail);
		operations.setTextInTextBox("//*[@id='redirectionEmail']", collboratorEmail);
		operations.clickElementOnPage("//*[@id='enableEmailAlerts']");

		operations.clickElementOnPage("//*[@id='submitCreateCategory']");
		Thread.sleep(3000);
		
		List<WebElement> tableRows = operations.getTableControl("//*[@id='sample-table-1']");
		
		WebElement categoryAdded = tableRows.get(tableRows.size() -1);
		System.out.println("The last row of the table is : " + categoryAdded.toString());

		Assert.assertTrue(categoryAdded.getText().contains(categoryName));
		Assert.assertTrue(categoryAdded.getText().contains(collboratorEmail));
	}
	
	@AfterMethod
	public void TearDown()
	{
		initializeWebDriver.StopWebrDriver();
	}
}
