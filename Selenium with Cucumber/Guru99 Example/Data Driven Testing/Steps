package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

public class Steps {
	public static WebDriver driver = null;
	
	@Given("^Open the Firefox and launch the application$")
	public void open_the_chrome_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\UBS\\Dev\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
	    driver= new ChromeDriver(options);					
	    //driver.manage().window().maximize();			
	    driver.get("http://demo.guru99.com/v4");	
	}
	
	@When("^Enter the Username user(\\d+) and Password password(\\d+)$")
	public void enter_username_and_password(String arg1,String arg2) {
		driver.findElement(By.name("uid")).sendKeys("user" + arg1);							
	    driver.findElement(By.name("password")).sendKeys("password" + arg2);	
	}
	
	@Then("^Reset the credential$")
	public void reset_the_credentials() {
		driver.findElement(By.name("btnReset")).click();	
		driver.quit();
	}
}
