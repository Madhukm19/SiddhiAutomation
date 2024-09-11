package generic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class WebBase implements AutoConst {

	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	public static WebDriver driver;
	@Parameters({ "Url", "userName", "password" })
	@BeforeClass
	public void openApplication(String url, String name, String pwd) throws InterruptedException {
		try {
			runHeadless(false);
			SiddhiLogin(url, name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void runHeadless(boolean headless) throws InterruptedException {
		if (headless) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
			chromeOptions.addArguments("--start-maximized");

		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		
		}
	}

    public void SiddhiLogin(String url, String un, String pwd) throws InterruptedException, IOException {
        driver.get(url);
        driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys(un);
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary btn-block btn-login']")).click();
    }

//    @AfterClass
//    public void closeApplication() {
//        if (driver != null) {
//            driver.quit();
//        }
 //   }
}
