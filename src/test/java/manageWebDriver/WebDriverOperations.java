package manageWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class WebDriverOperations
{
	WebDriver webDriver;
	
	public WebDriverOperations(WebDriver webDriver)
	{
		this.webDriver = webDriver;
	}
	
	public void setTextInTextBox(String xpath, String textToEnter)
	{
		try
		{
			WebElement textBoxToTarget = webDriver.findElement(By.xpath(xpath));
			System.out.println("Element Found : " + textBoxToTarget);
			textBoxToTarget.sendKeys(textToEnter);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public void clickElementOnPage(String xpath) 
	{
		try
		{
			WebElement buttonToTarget = webDriver.findElement(By.xpath(xpath));
			System.out.println("Element Found : " + buttonToTarget);
			buttonToTarget.click();		
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	public void moveMouseToAndClick(String xpath)
	{
		Actions action = new Actions(webDriver);
		WebElement elementToClick = webDriver.findElement(By.xpath(xpath));
		System.out.println("Element Found : " + elementToClick);
		action.moveToElement(elementToClick).build().perform();
	}

	public WebElement waitForExpectedElement(long waitTime, String xpathOfElement)
	{
		WebElement expectedElement = null;
		try
		{
			expectedElement = new WebDriverWait(webDriver,waitTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathOfElement)));
			System.out.println("Element Found : " + expectedElement);
			System.out.println(expectedElement.getText());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return expectedElement;
	}

	public void clearTextBox(String xpath)
	{
		WebElement textBoxToTarget = webDriver.findElement(By.xpath(".//*[@id='website']"));
		textBoxToTarget.clear();
	}

	public void navigateToUrl(String loginURL)
	{
		webDriver.navigate().to(loginURL);
	}

	public String getElementText(String xpath)
	{
		WebElement findElement;
		try
		{
			findElement = webDriver.findElement(By.xpath(xpath));
			System.out.println("Element Found : " + findElement);
			return findElement.getText();
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public Boolean checkIfControlEnabled(String xpath)
	{
		WebElement checkControl = webDriver.findElement(By.xpath(xpath));
		System.out.println("Element Found : " + checkControl);
		return checkControl.isEnabled();
	}

	public WebElement getTabControl(String xpath)
	{
		WebElement getControl = webDriver.findElement(By.xpath(xpath));
		System.out.println("Element Found : " + getControl);
		return getControl;
	}

	public List<WebElement> getTableControl(String xpath)
	{
		WebElement getControl = webDriver.findElement(By.xpath(xpath));

		List<WebElement> tableRows = getControl.findElements(By.tagName("tr"));
		for(int i=0; i<tableRows.size(); i++)
		{
			System.out.println(tableRows.get(i).getText());
		}

		return tableRows; 
	}

	public void selectTextByValueFromDropdown(String xpath, String value)
	{
		Select dropdown = new Select(webDriver.findElement(By.xpath(xpath)));
		System.out.println("Element Found : " + dropdown);
		dropdown.selectByValue(value);
	}

	public void PressEnter(String xpath)
	{
		WebElement element = webDriver.findElement(By.xpath(xpath));
		element.sendKeys(Keys.ENTER);
	}

	public String getPageSource()
	{
		return webDriver.getPageSource();
	}

	public List<WebElement> getAllListItems(String xpath)
	{
		WebElement  list = webDriver.findElement(By.xpath(xpath));
		
		List<WebElement> listItems = list.findElements(By.tagName("li"));
		for(int i =0;i<listItems.size();i++)
		{
			System.out.println(listItems.get(i).getText());
		}
		
		return listItems;
	}

	public void selectTextByVisibleTextFromDropdown(String xpath, int category)
	{
		Select dropdown = new Select(webDriver.findElement(By.id(xpath)));
		System.out.println("Element Found : " + dropdown);
		dropdown.selectByIndex(category);
	}
}