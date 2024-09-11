package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.Lib;
import generic.WebBase;
import pom.UsersCreationPage;

public class UsersCreation extends WebBase {
	@Test(priority=1)
	public void addUser() throws InterruptedException {
		
		UsersCreationPage user=new UsersCreationPage(driver);
		Thread.sleep(2000);
		user.clickOnUserSetUP();
		Thread.sleep(2000);
		user.clickOnAddUser();
	}
		@Test(priority=2)
		public void User() throws InterruptedException {
		UsersCreationPage user=new UsersCreationPage(driver);
		Thread.sleep(2000);
		String emailID=Lib.getProperty(GETFROMCONFIG, "email");
		user.enterEmailId(emailID);
		String NAME=Lib.getProperty(GETFROMCONFIG, "Name");
		user.enterFirstName(NAME);
		Thread.sleep(2000);
		user.saveUserdetailes();
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement close=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/div[1]/div[2]/button[2]/svg")));
		close.click();
		Thread.sleep(2000);
		//user.clickOnCloseIcon();
		
		
		
	}
	@Test(priority=3)
	public void userRolePermission() throws InterruptedException {
		UsersCreationPage user=new UsersCreationPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-roles_permissions_tab-tab")));
		element.click();
		Thread.sleep(2000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement checkBox=driver.findElement(By.xpath("//input[@data-unit=\"Siddhi\"]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
//		element.click();
//		
		
		//user.selectSidhiCheckBox();
		Thread.sleep(2000);
		//user.saveUserdetailes();
		
		
	}

}
