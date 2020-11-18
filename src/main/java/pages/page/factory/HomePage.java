package pages.page.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.GenericPage;

public class HomePage extends GenericPage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='HamburgerNavigationMenuLink']")
	private BaseElementFacade hamburgerNavigationMenuLink;

	@FindBy(xpath = "//a[@href='/portal/dw/spaces']")
	private BaseElementFacade openSpacesPageLink;

	@FindBy(xpath = "//a[@href='/portal/dw/home']")
	private BaseElementFacade homePageLink;

	@FindBy(xpath = "//i[contains(@class,'uiIconPeople')]")
	private BaseElementFacade personnePageLink;

	@FindBy(id = "appcenterLauncherButton")
	private BaseElementFacade appCenterButton;

	@FindBy(id = "5")
	private BaseElementFacade newsMenuButton;
	@FindBy(id = "eventAlAUne")
	private BaseElementFacade newsSlider;
	@FindBy(id = "LatestNewsContainer")
	private BaseElementFacade LatestNewsContainer;
	@FindBy(id = "profile-stats-portlet")
	private BaseElementFacade profileStatsPortlet;
	@FindBy(id = "tasks")
	private BaseElementFacade tasksContainer;
	@FindBy(id = "DocumentsContainer")
	private BaseElementFacade DocumentsContainer;
	@FindBy(id = "walletBalance")
	private BaseElementFacade walletBalance;
	@FindBy(xpath = "//div[@id='latestNewsDetails']//div[contains(@class,'v-responsive__content')]")
	private BaseElementFacade newsInWidget;
	@FindBy(xpath = "//div[@id='latestNewsDetails']//button[contains(@class,'caption ')]")
	private BaseElementFacade seeMoreNewsButton;
	@FindBy(xpath = "//i[contains(@class,'uiAdministrationIcon')]")
	private BaseElementFacade addministrationMenu;

	@FindBy(xpath = "//i[contains(@class,'logoutIcon')]")
	private BaseElementFacade logOutMenu;

	@FindBy(xpath = "//a[@href='/portal/g/:platform:administrators/usersManagement']")
	private BaseElementFacade addUserLink;

	private BaseElementFacade getProfileWidgetContent(String widget, String number) {
		return findByXpath(String.format(
				"//div[contains(@class,'profileCard')]//div[contains(@class,'mx-0')]//span[text()='%s']/../..//span[text()='%s']",
				widget, number));
	}

	private List<WebElementFacade> getListSpaceInDrawer() {
		return findAll(
				"//aside[contains(@class,'spaceDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
	}

	private List<WebElementFacade> getListConnectionInDrawer() {
		return findAll(
				"//aside[contains(@class,'connectionsDrawer ')]//div[@role='list']//descendant::div[@role='listitem']");
	}

	private BaseElementFacade getBadgeWithNumber(String number) {
		return findByXpath(
				String.format("//div[contains(@class,'profileCard')]//button//span[contains(text(),'%s')]", number));
	}

	private BaseElementFacade getRejectIconSpaceFromDrawer(String spaceName) {
		return findByXpath(String.format(
				"//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
				spaceName));
	}

	private BaseElementFacade getAcceptIconSpaceFromDrawer(String spaceName) {
		return findByXpath(String.format(
				"//aside[contains(@class,'spaceDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
				spaceName));
	}

	private BaseElementFacade getAcceptIconConnexionFromDrawer(String spaceName) {
		return findByXpath(String.format(
				"//aside[contains(@class,'connectionsDrawer ')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-checkbox-marked')]",
				spaceName));
	}

	private BaseElementFacade getRejectIconConnexionFromDrawer(String spaceName) {
		return findByXpath(String.format(
				"//aside[contains(@class,'connectionsDrawer')]//descendant::div[contains(text(),'%s')]//following::i[contains(@class,'mdi-close-circle')]",
				spaceName));
	}

	Map<String, BaseElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, BaseElementFacade>() {
		{
			put("Article", newsSlider);
			put("Dernières actualités", LatestNewsContainer);
			put("Statistique", profileStatsPortlet);
			put("Taches", tasksContainer);
			put("Documents", DocumentsContainer);
			put("Wallet", walletBalance);

		}
	};

	public void goToSpacesPage() {
		hamburgerNavigationMenuLink.clickOnElement();
		openSpacesPageLink.clickOnElement();
	}

	public void goToNewsApp() {
		appCenterButton.clickOnElement();
		newsMenuButton.clickOnElement();
	}

	public void goToAddUser() {
		hamburgerNavigationMenuLink.clickOnElement();
		addministrationMenu.clickOnElement();
		addUserLink.clickOnElement();
	}

	public boolean isHomePageDisplayed() {
		return hamburgerNavigationMenuLink.isVisibleAfterWaiting();
	}

	public boolean isElementVisible(String elementName) {
		return MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(elementName).isVisibleAfterWaiting();
	}

	public void goToHomePage() {
		hamburgerNavigationMenuLink.clickOnElement();
		homePageLink.clickOnElement();
	}

	public void goToPeoplePage() {
		hamburgerNavigationMenuLink.clickOnElement();
		personnePageLink.clickOnElement();
	}

	public boolean isNewsDisplayedInWidget() {
		return newsInWidget.isVisibleAfterWaiting();
	}

	public boolean isSeeMoreNewsButtonVisible() {
		return seeMoreNewsButton.isVisibleAfterWaiting();
	}

	public void clickWalletWidget() {
		walletBalance.clickOnElement();
	}

	public boolean isWalletPageOpened() {
		return Serenity.getWebdriverManager().getCurrentDriver().getTitle().equals("Portefeuille");
	}

	public void logout() {
		hamburgerNavigationMenuLink.clickOnElement();
		logOutMenu.clickOnElement();
	}

	public boolean isWidgetWithNumberVisible(String widget, String number) {
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
		return getProfileWidgetContent(widget, number).isVisibleAfterWaiting();
	}

	public boolean isBadgeWithNumberVisible(String number) {
		return getBadgeWithNumber(number).isVisibleAfterWaiting();
	}

	public void clickBagde(String badgeNumber) {
		getBadgeWithNumber(badgeNumber).clickOnElement();
	}

	public boolean isNumberOfSpacesInDrawer(int expectedNumber) {
		int listOfSpaces = getListSpaceInDrawer().size();
		return listOfSpaces == expectedNumber;
	}

	public boolean isNumberOfConnectionsInDrawer(int expectedNumber) {
		int listOfSpaces = getListConnectionInDrawer().size();
		return listOfSpaces == expectedNumber;
	}

	public void rejectSpaceInvitation(String spaceName) {
		getRejectIconSpaceFromDrawer(spaceName).clickOnElement();
	}

	public void acceptSpaceInvitation(String spaceName) {
		getAcceptIconSpaceFromDrawer(spaceName).clickOnElement();
	}

	public void acceptConnexionInvitation(String userName) {
		getAcceptIconConnexionFromDrawer(userName).clickOnElement();
	}

	public void rejectConnexionInvitation(String userName) {
		getRejectIconConnexionFromDrawer(userName).clickOnElement();
	}
}
