package stepDefinitions;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;

public class HomeStepDefinition {
	@Steps
	private HomeSteps homeSteps;

	@When("je navigue vers la page actualité")
    public void goToNewsApp(){
	    homeSteps.goToNewsApp();
    }
}
