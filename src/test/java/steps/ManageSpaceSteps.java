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
}
