package steps;

import pages.page.factory.HomePage;

public class HomeSteps {

    private HomePage homePage;

    public void goToManageSpacesPage() {
        homePage.goToSpacesPage();
    }


}
