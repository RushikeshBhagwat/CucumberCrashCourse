package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LoginPage;

public class LoginPageStepDef {

	//Declaring globally
	public WebDriver driver;
	LoginPage lp;
    
	@Before
	public void setup() {
		driver=new ChromeDriver();
	}
	
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Given("I am on the opencart login page")
	public void i_am_on_the_opencart_login_page() {
	    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	    driver.manage().window().maximize();
	    lp=new LoginPage(driver);
	}

	@Given("I have entered valid username and password")
	public void i_have_entered_valid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.enterEmail("uio@gmail.com");
	    lp.enterPassword("uio@gmail");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.clickLogin();
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(lp.successfullLogin());
	}

	@Given("I have entered a invalid {string} and {string}")
	public void i_have_entered_a_invalid_and(String username, String password) {
	   
		lp.enterEmail(username);
		lp.enterPassword(password);
	}

	@Then("I should see error message indicating {string}")
	public void i_should_see_error_message_indicating(String error_msg ) {
	    
		String actualErrormsg=lp.checkErrorMsgDisplayed();
		Assert.assertEquals(actualErrormsg, error_msg);
	    
	}

	@When("I click on forgot password link")
	public void i_click_on_link() {
	    lp.clickForgotpasslink();
	   
	}

	@Then("I should be navigated to password reset page")
	public void i_should_be_navigated_to_password_reset_page() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(lp.checkForgotPassPage());
	}
}
