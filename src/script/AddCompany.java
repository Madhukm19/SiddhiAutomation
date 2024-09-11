package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.Lib;
import generic.WebBase;
import pom.AddCompanyPage;

public class AddCompany extends WebBase 
{

	@Test(priority = 1, description = "Add Company")
	public void clickOnCompany() throws InterruptedException {
		try
		{
			AddCompanyPage user = new AddCompanyPage(driver);
			Thread.sleep(2000);
			user.clickUsersetup();
			user.clickAddCompany();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void enterCompanyName() throws InterruptedException {
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		String cname = Lib.getProperty(GETFROMCONFIG, "name");
		user.enterCompanyName(cname);
	}

	@Test(priority = 3)
	public void enterCompanyAbbr() throws InterruptedException {
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		String cabbr = Lib.getProperty(GETFROMCONFIG, "abbr");
		user.enterCompanyAbr(cabbr);
	}

	@Test(priority = 4)
	public void enterGSTNumber() throws InterruptedException {
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		String cgst = Lib.getProperty(GETFROMCONFIG, "gst");
		user.enterGSTNumber(cgst);
	}
	
	@Test(priority = 5)
	public void clickOnSave() throws Throwable {
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll up by executing JavaScript code
		js.executeScript("window.scrollBy(0, -500);");
		Thread.sleep(3000);
		user.clickOnSave();
	}
	
	@Test(priority = 6)
	public void clickOnAddress() throws Throwable  
	{
		try {				
		AddCompanyPage user = new AddCompanyPage(driver);		 	
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='freeze-message-container']")));
   		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll up by executing JavaScript code
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		user.clickOnAddress();
	}	
	catch(Exception e){		
		}
	}	
	
	@Test(priority = 7)
	public void clickOnNewAddress() throws Throwable 
	{
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		user.clickOnNewAddress();
	}	
	
	@Test(priority = 8)
	public void enterPinCode() throws Throwable 
	{
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll up by executing JavaScript code
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		user.enterPincode();
	}	
	
	@Test(priority = 9)
	public void enterAddressLine() throws Throwable 
	{
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		user.enterAddressLine();
	}	
	
	@Test(priority = 10)
	public void enterCity() throws Throwable 
	{
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		user.enterCity();
	}
	
	@Test(priority = 11)
	public void enterState() throws Throwable 
	{
		AddCompanyPage user = new AddCompanyPage(driver);
		user.enterState();
		Thread.sleep(4000);
		
		  List<WebElement> stateOptions = driver.findElements(By.cssSelector("ul#awesomplete_list_53 li a p"));
	        // Loop through the list and select Karnataka
	        for (WebElement option : stateOptions) {
	            if (option.getText().equalsIgnoreCase("Karnataka")) {
	                option.click();
	                break;  // Exit loop once Karnataka is found and clicked
	            }
	        }		  
	}
	
	@Test(priority = 12)
	public void clickOnSaveButton() throws Throwable 
	{
		AddCompanyPage user = new AddCompanyPage(driver);
		Thread.sleep(2000);
		user.clickOnSaveButton();
	}	
}

