package stepDefinition;
import java.util.List;
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

public class dealsStep {
	public static WebDriver driver = null;
	
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver_win32\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
	    driver= new ChromeDriver(options);						
	    driver.get("https://www.freecrm.com/index.html");	
	    
	}

	@When("^Title of the login page is Free CRM$")
	public void title_of_the_login_page_is_Free_CRM() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver.getTitle();
		String expectedTitle = "Free CRM software in the cloud powers sales and customer service";
		Assert.assertEquals(actualTitle,expectedTitle);
	    
	}

	@Then("^user enters usename and password$")
	public void user_enters_usename_and_password(DataTable credentials) throws Throwable {
		List<List<String>> data = credentials.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).submit();
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle = "CRMPRO";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deal_page() throws Throwable {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[5]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[5]/ul/li[1]/a")).click();
	}

	@Then("^user eneters deal details$")
	public void user_eneters_deal_details(DataTable dealData) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> dealValues = dealData.raw();
		
		driver.findElement(By.id("title")).sendKeys(dealValues.get(0).get(0));
		driver.findElement(By.id("amount")).sendKeys(dealValues.get(0).get(1));
		driver.findElement(By.id("probability")).sendKeys(dealValues.get(0).get(2));
		driver.findElement(By.id("commission")).sendKeys(dealValues.get(0).get(3));
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
