package StepsDefinitions;

import java.io.IOException;

import org.junit.runner.RunWith;
import Ressources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

@RunWith(Cucumber.class)

public class StepsDefinition extends Base {


		@Given("Initiliaze browser with chrome")
		public void initiliaze_browser_with_chrome() throws IOException {
		    // Write code here that turns the phrase above into concrete actions
			driver=initializeDriver();
		}


		@And("Navigate to {string} site")
		public void navigate_to_site(String string) {
		    // Write code here that turns the phrase above into concrete actions
			driver.get(string);
		}
		
		@And("Click on Login botton")
		public void click_on_login_botton() {
		    // Write code here that turns the phrase above into concrete actions
			LandingPage lap = new LandingPage(driver);
			if(lap.getNoThanksSize().size()!=0)
			{
				lap.getPopUp().click();
			}
			LoginPage lop = lap.getLogin();
		}
		
		@When("^User enters (.*) and (.*) and logs in$")
		public void user_enters_and_and_logs_in(String string, String string2) {
		    // Write code here that turns the phrase above into concrete actions
			LoginPage lop = new LoginPage(driver);
			lop.email().sendKeys(string);
			lop.password().sendKeys(string2);
			lop.comit().click();
		}
		
		@Then("Verify that user is successfully logged in")
		public void verify_that_user_is_successfully_logged_in() {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Test complet secssufelly");
			driver.quit();
		}



		
		



	
}
