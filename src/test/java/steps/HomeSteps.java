package steps;

import java.util.ArrayList;
import java.util.List;

import pages.page.factory.HomePage;

public class HomeSteps {

	private HomePage homePage;

	public void goToManageSpacesPage() {
		homePage.goToSpacesPage();
	}

	public void goToNewsApp() {
		homePage.goToNewsApp();
	}

	public List<String> checkSections(List<String> elementList) {
		List<String> missingValues = new ArrayList<>();
		for (String elementName : elementList) {
			if (!homePage.isElementVisible(elementName))
				missingValues.add(elementName);
		}
		return missingValues;
	}

	public boolean checkSlider() {
		return homePage.isElementVisible("Article");
	}

	public void goToHomePage() {
		homePage.goToHomePage();
	}

	public boolean isNewsDisplayedInWidget() {
		return homePage.isNewsDisplayedInWidget();
	}

	public boolean isSeeMoreNewsButtonVisible() {
		return homePage.isSeeMoreNewsButtonVisible();
	}

	public void clickWalletWidget() {
		homePage.clickWalletWidget();
	}

	public boolean checkWalletPage() {
		return homePage.isWalletPageOpened();
	}

	public void goToAddUser() {
		homePage.goToAddUser();
	}

	public boolean isWidgetWithNumberVisible(String widget, String number) {
		return homePage.isWidgetWithNumberVisible(widget, number);
	}

	public boolean isBadgeWithNumberVisible(String number) {
		return homePage.isBadgeWithNumberVisible(number);
	}

	public void clickBadge(String badgeNumber) {
		homePage.clickBagde(badgeNumber);
	}

	public boolean isNumberOfSpacesInDrawer(String number) {
		return homePage.isNumberOfSpacesInDrawer(Integer.valueOf(number));
	}

	public boolean isNumberOfConnectionsInDrawer(String number) {
		return homePage.isNumberOfConnectionsInDrawer(Integer.valueOf(number));
	}

	public void rejectSpaceInvitation(List<String> listOfSpaces) {
		for (String spaceName : listOfSpaces)
			homePage.rejectSpaceInvitation(spaceName);
	}

	public void acceptSpaceInvitation(List<String> listOfSpaces) {
		for (String spaceName : listOfSpaces)
			homePage.acceptSpaceInvitation(spaceName);
	}

	public void acceptConnexionInvitation(List<String> listOfPeople){
		for (String peopleName : listOfPeople)
			homePage.acceptConnexionInvitation(peopleName);
	}

	public void rejectConnexionInvitation(List<String> listOfPeople){
		for (String peopleName : listOfPeople)
			homePage.rejectSpaceInvitation(peopleName);
	}
}
