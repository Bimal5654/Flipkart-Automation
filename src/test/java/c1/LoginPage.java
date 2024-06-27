package c1;
import Pages.FbLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	
	FbLoginPage fblogin=new FbLoginPage();
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
		fblogin.setUp();
	}
	@When("user enters valid username and valid password and click login")
	public void user_enters_valid_username_and_valid_password_and_click_login()
	{
		fblogin.login();
	}
	@Then("user should login successfully")
	public void user_should_login_successfully()
	{
		fblogin.validatesuccess();
	}
	
	
}
