package pages.page.factory.space;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
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

}
