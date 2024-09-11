package script;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.WebBase;
import generic.WriteToExcel;
import pom.SiddhiDataImportPage;

public class SiddhiDataImport extends WebBase {

	@Test(priority = 1)
	public void siddhi1() throws InterruptedException, IOException, InvalidFormatException {
		Thread.sleep(3000);
		SiddhiDataImportPage data = new SiddhiDataImportPage(driver);
		data.typeCommand("new data");
		Thread.sleep(2000);
		data.selectNewDataType();
		Thread.sleep(2000);
		data.clickOnSelectNewDocumentType();
		Thread.sleep(2000);
		data.selectCustomerFromDropDown();
		data.clickOnImportType();
		Thread.sleep(2000);
		data.selectImportTypeFromDropDown();
		Thread.sleep(2000);
		data.clickOnSave();
		Thread.sleep(2000);
		data.clickOnDowanlodtemplate();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@data-fieldname=\"file_type\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()=\"Excel\"]")).click();
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class=\"checkbox unit-checkbox\"]/label/span"));

		String excelPath = ".\\dataFiles\\Data.xlsx";
		WriteToExcel ex = new WriteToExcel(excelPath);
		int rows = ex.getRowCount("Sheet1");
		int columns = ex.getCellCount("Sheet1", 0);

		
		for (int i = 0; i < elements.size(); i++) {
			WebElement filed = elements.get(i);
			String filedText = filed.getText();
			

			
			for (int r = 0; r <=rows; r++) {
				for (int c = 0; c < columns; c++) {
					String cellValue = ex.getCellData("Sheet1", r, c);
					

					
					if (cellValue.equals(filedText)) {
						WebElement checkbox = driver.findElement(
								By.xpath("(//div[@class=\"checkbox unit-checkbox\"]/label/input)[" + (i + 1) + "]"));
						boolean isSelected = checkbox.isSelected();

						if (!isSelected) {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
						}

					}
				}
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Export\"]")).click();
		Thread.sleep(2000);

		//String sourceExcelPath = ".\\dataFiles\\Data.xlsx";
        String destinationExcelPath = "C:\\Users\\knagaratna\\sidhi\\Customer.xlsx.crdownload";
        WriteToExcel ex1 = new WriteToExcel(destinationExcelPath);
		int rows1 = ex.getRowCount("Sheet1");
		int columns1 = ex.getCellCount("Sheet1", rows1);
		

			
			for (int r = 0; r <=rows1; r++) {
				for (int c = 0; c < columns1; c++) {
					String cellValue = ex.getCellData("Sheet1", r, c);
					ex1.setCellData("Customer", r, c, cellValue);

	}
}
	}
}