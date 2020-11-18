package stepDefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import steps.PeopleSteps;

public class PeopleStepDefinition {

	@Steps
	private PeopleSteps peopleSteps;

	@Given("^Je connecte avec l'utilisateur'(.*)'$")
	public void connectToUser(String user) {
		peopleSteps.connectToUser(user);
	}
}
