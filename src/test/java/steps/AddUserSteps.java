package steps;

import pages.page.factory.administration.AddUserPage;

import java.util.Map;

public class AddUserSteps {

    private AddUserPage addUserPage;

    public void addUser(Map<String,String> userDetails){
        addUserPage.clickAddUserButton();
        for (String fieldsName : userDetails.keySet()) {
            addUserPage.setUserDetails(fieldsName, userDetails.get(fieldsName));
        }
        addUserPage.saveAddUserButton();
    }
}
