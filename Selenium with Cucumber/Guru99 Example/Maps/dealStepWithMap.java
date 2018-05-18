package stepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class dealStepWithMap {
	public static WebDriver driver = null;

	@Given("^user is already on the login page$")
	public void user_is_already_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		driver.get("https://www.freecrm.com/index.html");

	}

	@When("^title of the login page is Free CRM$")
	public void title_of_the_login_page_is_Free_CRM() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String actualTitle = driver.getTitle();
		String expectedTitle = "Free CRM software in the cloud powers sales and customer service";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Then("^user enters the usename and password$")
	public void user_enters_usename_and_password(DataTable credentials) throws Throwable {
		// Map<String,String> data = (Map<String,String>)
		// credentials.asMap(String.class,String.class);
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
			driver.findElement(By.name("username")).sendKeys(data.get("username"));
			driver.findElement(By.name("password")).sendKeys(data.get("password"));
		}

	}

	@Then("^user clicks on the login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).submit();
	}

	@Then("^user is on the home page$")
	public void user_is_on_home_page() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle = "CRMPRO";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Then("^user moves to the new deal page$")
	public void user_moves_to_new_deal_page() throws Throwable {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[5]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[5]/ul/li[1]/a")).click();
	}

	@Then("^user enters deal details$")
	public void user_eneters_deal_details(DataTable dealData) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		for (Map<String, String> data : dealData.asMaps(String.class, String.class)) {
			driver.findElement(By.id("title")).sendKeys(data.get("title"));
			driver.findElement(By.id("amount")).sendKeys(data.get("amount"));
			driver.findElement(By.id("probability")).sendKeys(data.get("probability"));
			driver.findElement(By.id("commission")).sendKeys(data.get("comission"));
		}

	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
