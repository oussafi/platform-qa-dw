package steps;

import pages.page.factory.HomePage;
import pages.page.factory.people.PeoplePage;

public class PeopleSteps {

    private PeoplePage peoplePage;
    private HomePage homePage;

    public void connectToUser(String user){
        homePage.goToPeoplePage();
        peoplePage.connectToUser(user);
    }
}
