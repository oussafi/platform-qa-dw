package pages.page.factory.space;

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

	private BaseElementFacade getSpaceNameInListOfSpace(String spaceName) {
		return findByXpath(String.format("//div[@id='spacesListBody']//a[contains(text(),'%s')]", spaceName));
	}

	public void openSpaceFormDrawer() {
		addNewSpaceButton.clickOnElement();
	}

	public void setSpaceName(String spaceName) {
		spaceNameInput.setTextValue(spaceName);
	}

	public void clickFirstProcessButton() {
		firstProcessButton.clickOnElement();
	}

	public void clickSecondProcessButton() {
		secondProcessButton.clickOnElement();
	}

	public void clickAddSpaceButton() {
		addSpaceButton.clickOnElement();
	}

	public void insertSpaceNameInSearchField(String spaceName) {
		searchSpaceInput.setTextValue(spaceName);
	}

	public void goToSpecificSpace(String spaceName) {
		getSpaceNameInListOfSpace(spaceName).clickOnElement();
	}
}
