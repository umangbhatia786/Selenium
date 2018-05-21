package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public TestBaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Umang Bhatia\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\config\\config.properties");
			prop.load(fis);

		}

		catch (IOException ex) {
			ex.getMessage();
		}
	}

	public static void intialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestUtil.CHROMEDRIVER_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			driver = new ChromeDriver(options);
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", TestUtil.IEDRIVER_PATH);
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
	}
}
