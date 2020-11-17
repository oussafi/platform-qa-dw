package stepDefinitions;

import java.util.Map;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import steps.AddUserSteps;
import steps.HomeSteps;

public class AddUserStepDefinition {
	@Steps
	HomeSteps homeSteps;
	@Steps
	AddUserSteps addUserSteps;

	@Given("^L'utilisateur suivant est crée$")
	public void adduser(Map<String, String> userDetails) {
		homeSteps.goToAddUser();
		addUserSteps.addUser(userDetails);
	}
}
