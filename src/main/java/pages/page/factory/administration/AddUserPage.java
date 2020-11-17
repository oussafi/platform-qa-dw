package pages.page.factory.administration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class AddUserPage extends GenericPage {
	public AddUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(@class,'addNewUserButton')]")
	private BaseElementFacade addUserButton;
    @FindBy(xpath = "//aside[@id='userFormDrawer']//button[contains(@class,'btn-primary')]")
    private BaseElementFacade saveAddUserButton;

	private TextBoxElementFacade getUserField(String classField) {
		return findTextBoxElementByXpath(String.format("//div[contains(@class,'%s')]//input", classField));
	}

	Map<String, TextBoxElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, TextBoxElementFacade>() {
		{
			put("Utilisateur", getUserField("userNameField"));
			put("Prénom", getUserField("firstNameField"));
			put("Nom", getUserField("lastNameField"));
			put("Email", getUserField("emailField "));
			put("Mot de passe", getUserField("newPasswordField"));
			put("Confirmer le mot de passe", getUserField("confirmPasswordField"));

		}
	};

	public void clickAddUserButton() {
		addUserButton.clickOnElement();
	}

	public void setUserDetails(String userDetails, String fieldValue) {
		MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(userDetails).setTextValue(fieldValue);
	}

	public void saveAddUserButton(){
        saveAddUserButton.clickOnElement();
    }
}
