package stepDefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import steps.LoginSteps;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {
    @Steps
    private LoginSteps loginSteps;

    @Given("^Je suis connecté avec l'utilisateur avec les identifiants$")
    public void login(Map<String, String> credentials) {
        loginSteps.authenticate(credentials);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }

    @Given("^Je change l'utilisateur$")
    public void logOutLogin(Map<String, String> credentials) {
        loginSteps.logOutLogin(credentials);
        assertThat(loginSteps.isHomePageDisplayed()).as("The home page should be loaded, but it did not !").isTrue();
    }
}
