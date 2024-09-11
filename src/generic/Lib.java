package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lib extends WebBase {
	public static void writeProperties(String key, String value) throws IOException {
		Path path = Paths.get(WRITEFILEPATH);

		// Check if the file exists; if not, create a new file
		if (!path.toFile().exists()) {
			try {
				path.toFile().createNewFile();
			} catch (FileAlreadyExistsException e) {
				// log stackTrace details
				e.printStackTrace();
			}
		}

		Properties properties = new Properties();

		// Load existing properties
		try (FileInputStream input = new FileInputStream(WRITEFILEPATH)) {
			properties.load(input);
		}

		// Check key and value
		if (key != null && value != null) {
			properties.setProperty(key, value);
		}

		// Write the properties back to the file
		try (FileOutputStream output = new FileOutputStream(WRITEFILEPATH)) {
			properties.store(output, "Test Data");
		}
	}

	public static String getProperty(String path, String key) {
		String value = "";
		try (InputStream input = new FileInputStream(path)) {
			Properties properties = new Properties();
			properties.load(input);
			value = properties.getProperty(key);
		} catch (IOException e) {
			// Log the exception message using a logging framework or print to console
			System.err.println("Error reading property file: " + e.getMessage());
		}
		return value;
	}

	public static String readFromExcel(String xlPath, String sheetName, int rowPosition, int colPosition) {
		try (FileInputStream fis = new FileInputStream(xlPath)) {
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet != null) {
				Row row = sheet.getRow(rowPosition);
				if (row != null) {
					Cell cell = row.getCell(colPosition);
					if (cell != null) {
						return cell.getStringCellValue();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void writeToExcel(String xlPath, String sheetName, int rowPosition, int colPosition, String data) {
		try (FileInputStream fis = new FileInputStream(xlPath)) {
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				sheet = workbook.createSheet(sheetName);
			}

			Row row = sheet.getRow(rowPosition);
			if (row == null) {
				row = sheet.createRow(rowPosition);
			}

			Cell cell = row.createCell(colPosition);
			cell.setCellValue(data);

			try (FileOutputStream fos = new FileOutputStream(xlPath)) {
				workbook.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
