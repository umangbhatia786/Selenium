package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utility.TestBaseClass;

public class HomePageSteps extends TestBaseClass {
	public LoginPage loginPage = null;
	public HomePage homePage = null;
	@Given("^User opens browser$")
	public void user_opens_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		TestBaseClass.intialization();
	}

	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	}

	@Then("^user logs into app$")
	public void user_enters_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	

	@Then("^validate Home Page title$")
	public void validate_Home_Page_title() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO",homeTitle);
	}

	@Then("^Validate logogged username$")
	public void validate_logogged_username() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}

}
