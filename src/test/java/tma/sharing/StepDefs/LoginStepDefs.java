package tma.sharing.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tma.sharing.PageObjects.LoginPageObject;
import tma.sharing.Utils.BrowserHandler;
import tma.sharing.Utils.PropertiesHandler;

import java.util.Properties;


public class LoginStepDefs extends BrowserHandler {

    Properties properties = PropertiesHandler.loadCredentialProperties();
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");

    @Given("User enters a valid username in the username input")
    public void userEntersAValidUsernameInTheUsernameInput() {
        LoginPageObject.enterUsername(username);
    }

    @And("User enter a valid password in the password input")
    public void userEnterAValidPasswordInThePasswordInput() {
        LoginPageObject.enterPassword(password);
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        LoginPageObject.clickLoginButton();
    }

    @Then("User is logged successfully")
    public void userIsLoggedSuccessfully() {
        LoginPageObject.validateLoginSuccess();
    }

    @Given("^User enters an invalid (.*) in the username input$")
    public void userEntersAnInvalidUsernameInTheUsernameInput(String username) {
        LoginPageObject.enterUsername(username);
    }

    @And("^User enter an invalid (.*) in the password input$")
    public void userEnterAnInvalidPasswordInThePasswordInput(String password) {
        LoginPageObject.enterPassword(password);
    }

    @Then("User not logged successfully")
    public void userNotLoggedSuccessfully() {
        LoginPageObject.validateLoginFail();
    }

}
