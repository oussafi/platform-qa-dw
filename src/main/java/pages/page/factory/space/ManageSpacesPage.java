package pages.page.factory.space;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class ManageSpacesPage extends GenericPage {
	public ManageSpacesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(@class,'addNewSpaceButton')]")
	private BaseElementFacade addNewSpaceButton;

	@FindBy(name = "name")
	private TextBoxElementFacade spaceNameInput;

	@FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[1]")
	private BaseElementFacade firstProcessButton;

	@FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[2]")
	private BaseElementFacade secondProcessButton;

	@FindBy(xpath = "(//aside[contains(@class,'spaceFormDrawer')]//button[contains(@class,'btn-primary')])[3]")
	private BaseElementFacade addSpaceButton;

	@FindBy(xpath = "//div[contains(@class,'inputSpacesFilter')]//input")
	private TextBoxElementFacade searchSpaceInput;

	@FindBy(xpath = "(//div[@name='inviteMembers']//input)[1]")
	private TextBoxElementFacade inviteUserInput;

	private BaseElementFacade getSpaceNameInListOfSpace(String spaceName) {
		return findByXpath(String.format("//div[@id='spacesListBody']//a[contains(text(),'%s')]", spaceName));
	}

	private BaseElementFacade getSelectUserInDropDown(String userName) {
		return findByXpath(String.format(
				"//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]", userName));
	}

	public void openSpaceFormDrawer() {
		addNewSpaceButton.clickOnElement();
	}

	public void setSpaceName(String spaceName) {
		StringSelection stringSelection = new StringSelection(spaceName);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		spaceNameInput.sendKeys(Keys.CONTROL + "v");
	}

	public void clickFirstProcessButton() {
		firstProcessButton.clickOnElement();
	}

	public void clickSecondProcessButton() {
		secondProcessButton.clickOnElement();
	}

	public void clickAddSpaceButton() {
		addSpaceButton.clickOnElement();
		addSpaceButton.waitUntilNotVisible();
	}

	public void insertSpaceNameInSearchField(String spaceName) {
		searchSpaceInput.setTextValue(spaceName);
	}

	public void goToSpecificSpace(String spaceName) {
		getSpaceNameInListOfSpace(spaceName).clickOnElement();
	}

	public void inviteUserToSpace(String user) {
		inviteUserInput.setTextValue(user);
		getSelectUserInDropDown(user).clickOnElement();
	}
}
