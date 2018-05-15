package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;	
import cucumber.api.java.en.Then;	
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;

public class dealSteps {
	public static WebDriver driver = null;
	
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\UBS\\Dev\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
	    driver= new ChromeDriver(options);						
	    driver.get("https://www.freecrm.com/index.html");	
	    throw new PendingException();
	}
	
	@When("^Title of the login page is Free CRM$")
	public void title_of_the_login_page_is_Free_CRM() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver.getTitle();
		String expectedTitle = "Free CRM software in the cloud powers sales and customer service";
		Assert.assertEquals(actualTitle,expectedTitle);
	    throw new PendingException();
	}

	@Then("^user enters usename and password$")
	public void user_enters_usename_and_password(DataTable credentials) throws Throwable {
		List<List<String>> data = credentials.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	    throw new PendingException();
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
	    throw new PendingException();
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver.getTitle();
		String expectedTitle = "CRMPRO";
		Assert.assertEquals(actualTitle, expectedTitle);
	    throw new PendingException();
	}

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_contact_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[5]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[5]/ul/li[1]/a")).click();
	    throw new PendingException();
	}

	@Then("^user eneters deal details$")
	public void user_eneters_deal_details(DataTable dealData) throws Throwable {
		List<List<String>> dealValues = dealData.raw();
		
		driver.findElement(By.id("title")).sendKeys(dealValues.get(0).get(0));
		driver.findElement(By.id("amount")).sendKeys(dealValues.get(0).get(1));
		driver.findElement(By.id("probability")).sendKeys(dealValues.get(0).get(2));
		driver.findElement(By.id("commission")).sendKeys(dealValues.get(0).get(3));
	    throw new PendingException();
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	    throw new PendingException();
	}
}
