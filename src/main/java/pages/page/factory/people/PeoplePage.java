package pages.page.factory.people;

import elements.TextBoxElementFacade;
import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class PeoplePage extends GenericPage {

	public PeoplePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//header[@id='peopleListToolbar']//input")
	private TextBoxElementFacade searchPeopleInput;

	private BaseElementFacade getConnectUserButton(String user){
	    return findByXpath(String.format("//a[contains(@href,'%s')]//following::i[contains(@class,'uiIconSocConnectUser')]",user));
    }

    public void connectToUser(String user){
	   searchPeopleInput.setTextValue(user);
	   getConnectUserButton(user).clickOnElement();
        getConnectUserButton(user).waitUntilNotVisible();
    }
}
