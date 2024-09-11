package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiddhiDataImportPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id=\"navbar-search\"]")
	WebElement search;

	@FindBy(xpath = "//ul[@id=\"awesomplete_list_1\"]/li[1]")
	WebElement selectNewData;

	@FindBy(xpath = "//input[@data-target=\"DocType\"]")
	WebElement selectNewDocument;

	@FindBy(xpath = "//ul[@id=\"awesomplete_list_2\"]/div[1]")
	WebElement selectCustomer;

	@FindBy(xpath = "//select[@data-fieldname=\"import_type\"]")
	WebElement importType;

	@FindBy(xpath = "//option[@value=\"Insert New Records\"]")
	WebElement insertRecord;

	@FindBy(xpath = "//button[@data-label=\"Save\"]")
	WebElement save;

	@FindBy(xpath = "//button[text()=\"Download Template\"]")
	WebElement template;
	
	@FindBy(xpath = "//button[text()='Export']")
	WebElement export;


	public SiddhiDataImportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void typeCommand(String name) {
		search.sendKeys(name);
	}

	public void selectNewDataType() {
		selectNewData.click();
	}

	public void clickOnSelectNewDocumentType() {
		selectNewDocument.sendKeys("cus");
	}

	public void selectCustomerFromDropDown() {
		selectCustomer.click();
	}

	public void clickOnImportType() {
		importType.click();
	}

	public void selectImportTypeFromDropDown() {
		insertRecord.click();
	}

	public void clickOnSave() {
		save.click();
	}

	public void clickOnDowanlodtemplate() {
		template.click();
	}
	
	public void clickOnExportData() {
		export.click();
	}
	

}
