package steps;

import java.util.Map;

import pages.page.factory.HomePage;
import pages.page.factory.LoginPage;

public class LoginSteps {
	private LoginPage loginPage;
	private HomePage homePage;

	public void authenticate(Map<String, String> credentials) {
		loginPage.open();
		loginPage.login(credentials.get("login"), credentials.get("password"));
	}

	public boolean isHomePageDisplayed() {
		return homePage.isHomePageDisplayed();
	}

	public void logOutLogin(Map<String, String> credentials) {
		homePage.logout();
		loginPage.login(credentials.get("login"), credentials.get("password"));
	}
}
