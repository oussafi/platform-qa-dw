package steps;

import pages.page.factory.space.ManageSpacesPage;

public class ManageSpaceSteps {
	private ManageSpacesPage manageSpacesPage;

	public void addSimpleSpace(String spaceName) {
		manageSpacesPage.openSpaceFormDrawer();
		manageSpacesPage.setSpaceName(spaceName);
		manageSpacesPage.clickFirstProcessButton();
		manageSpacesPage.clickSecondProcessButton();
		manageSpacesPage.clickAddSpaceButton();
	}

	public void goToSpeceficSpace(String space) {
		manageSpacesPage.insertSpaceNameInSearchField(space);
		manageSpacesPage.goToSpecificSpace(space);
	}

	public void addSpaceWithInviteUser(String spaceName, String user) {
		manageSpacesPage.openSpaceFormDrawer();
		manageSpacesPage.setSpaceName(spaceName);
		manageSpacesPage.clickFirstProcessButton();
		manageSpacesPage.clickSecondProcessButton();
		manageSpacesPage.inviteUserToSpace(user);
		manageSpacesPage.clickAddSpaceButton();
	}
}
