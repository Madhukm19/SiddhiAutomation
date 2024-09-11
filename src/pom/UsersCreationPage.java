package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersCreationPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()=\"Add User\"]")
	WebElement addUser;

	@FindBy(xpath = "//span[text()=\"User Setup\"]")
	WebElement userSetUP;

	@FindBy(xpath = "//input[@data-fieldname=\"email\"]")
	WebElement email;
	
	@FindBy(xpath = "//input[@data-fieldname=\"first_name\"]")
	WebElement Name;
	
	@FindBy(xpath = "//button[@data-label=\"Save\"]")
	WebElement save;
	
	@FindBy(id="user-roles_permissions_tab-tab")
	WebElement UserRolePermission;
	
	@FindBy(xpath="//button[@class=\"btn btn-modal-close btn-link\"]")
	WebElement close;
	
	@FindBy(xpath="//input[@data-unit=\"Siddhi\"]")
	WebElement selectSidhi;

	public UsersCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddUser() {
		addUser.click();
	}

	public void clickOnUserSetUP() {
		userSetUP.click();
	}

	public void enterEmailId(String mailID) {
		email.sendKeys(mailID);
	}
	

	public void enterFirstName(String name) {
		Name.sendKeys(name);
	}
	
	public void saveUserdetailes() {
		save.click();
	}
	
	public void clickOnUserRoleAndPermission() {
		UserRolePermission.click();
	}
	
	public void clickOnCloseIcon() {
		close.click();
	}
	
	public void selectSidhiCheckBox() {
		selectSidhi.click();
	}
	
	
	

}
