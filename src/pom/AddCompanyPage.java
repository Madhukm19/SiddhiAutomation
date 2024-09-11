package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;

public class AddCompanyPage extends WebBase

{

	@FindBy(xpath = "//span[text()='User Setup']")
	WebElement usersetup;

	@FindBy(xpath = "//span[@title=\"Add Company\"]")
	WebElement clickcompany;
	
	@FindBy(xpath = "(//input[@class='input-with-feedback form-control bold'])[1]")
	WebElement entercompany;
	
	@FindBy(xpath = "(//input[@class='input-with-feedback form-control bold'])[2]")
	WebElement enterabbr;
	
	@FindBy(xpath = "(//input[@class='input-with-feedback form-control bold'])[5]")
	WebElement entergstnumber;
	
	@FindBy(xpath = "//button[@data-label=\"Save\"]//span[text()='ve']")
	WebElement clickonsave;
	
	@FindBy(xpath = "//button[@class='btn btn-default ellipsis']")
	WebElement clickonmanage;
	
	@FindBy(xpath = "//div[contains(text(), 'Address & Contact')]")
	WebElement clickonaddress;
	
	@FindBy(xpath = "//button[contains(text(), 'New Address')]")
	WebElement clickonnewaddress;
	
	@FindBy(xpath = "//input[@data-fieldname='_pincode']")
	WebElement enterpincode;
	
	@FindBy(xpath = "//input[@data-fieldname='address_line1']")
	WebElement enteraddressline;
	
	@FindBy(xpath = "//input[@data-fieldname='city']")
	WebElement entercity;
	
	@FindBy(xpath = "//div/input[@data-fieldname='state']")
	WebElement selectstate;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement clickonsavebutton;	
			
	public AddCompanyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickUsersetup() throws InterruptedException
	{
	  usersetup.click();
		Thread.sleep(2000);
	}
	
	public void  clickAddCompany() throws InterruptedException {
		clickcompany.click();
		Thread.sleep(2000);
	}
	
	public void enterCompanyName(String name)
	{
	  entercompany.sendKeys(name);
	}
	
	public void enterCompanyAbr(String abbr)
	{
	  enterabbr.sendKeys(abbr);
	}
	
	public void enterGSTNumber(String gst)
	{
	  entergstnumber.sendKeys(gst);
	}
	
	public void clickOnSave() throws Throwable 
	{
		clickonsave.click();
		Actions actions = new Actions(driver);
        // Perform a double-click on the element
        actions.doubleClick(clickonsave).perform();
    }
	
	public void clickOnAddress() throws Throwable
	{
	  clickonaddress.click();
	  Thread.sleep(2000);
	}
		
	public void clickOnNewAddress()
	{
		clickonnewaddress.click();
	}
	
	public void enterPincode()
	{
		enterpincode.sendKeys("571313");
	}
	
	public void enterAddressLine()
	{
		enteraddressline.sendKeys("Street road");;
	}
	
	public void enterCity()
	{
		entercity.sendKeys("Bangalore");
	}
	
	public void enterState() 
	{
		selectstate.click();
	}
		
	public void clickOnSaveButton()
	{
		clickonsavebutton.click();
		Actions actions = new Actions(driver);

        // Perform a double-click on the element
        actions.doubleClick(clickonsavebutton).perform();
	}
}
