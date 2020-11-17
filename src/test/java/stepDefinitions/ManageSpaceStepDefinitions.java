package stepDefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;
import steps.ManageSpaceSteps;

public class ManageSpaceStepDefinitions {
	@Steps
	private ManageSpaceSteps manageSpaceSteps;

	@Steps
	private HomeSteps homeSteps;

	@Given("^l'espace '(.*)' est crée$")
	public void addNewSpace(String spaceName) {
		homeSteps.goToManageSpacesPage();
		manageSpaceSteps.addSimpleSpace(spaceName);
	}

	@Given("^je navigue vers l'espace '(.*)'$")
	public void goToSpace(String spaceName) {
		homeSteps.goToManageSpacesPage();
		manageSpaceSteps.goToSpeceficSpace(spaceName);
	}

	@Given("^Je créé l'espace '(.*)' en invitant l'utilisateur '(.*)'$")
	public void addNewSpaceWithUser(String spaceName,String user) {
		homeSteps.goToManageSpacesPage();
		manageSpaceSteps.addSpaceWithInviteUser(spaceName,user);
	}
}
