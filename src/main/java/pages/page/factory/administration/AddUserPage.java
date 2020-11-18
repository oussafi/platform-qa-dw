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

	@FindBy(xpath = "//div[contains(@class,'userNameField')]//input")
	private TextBoxElementFacade userNameField;
	@FindBy(xpath = "//div[contains(@class,'firstNameField')]//input")
	private TextBoxElementFacade firstNameField;
	@FindBy(xpath = "//div[contains(@class,'lastNameField')]//input")
	private TextBoxElementFacade lastNameField;
	@FindBy(xpath = "//div[contains(@class,'emailField')]//input")
	private TextBoxElementFacade emailField;
	@FindBy(xpath = "//div[contains(@class,'newPasswordField')]//input")
	private TextBoxElementFacade newPasswordField;
	@FindBy(xpath = "//div[contains(@class,'confirmPasswordField')]//input")
	private TextBoxElementFacade confirmPasswordField;

	private TextBoxElementFacade getUserField(String classField) {
		return findTextBoxElementByXpath(String.format("//div[contains(@class,'%s')]//input", classField));
	}

	Map<String, TextBoxElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, TextBoxElementFacade>() {
		{
			put("Utilisateur", userNameField);
			put("Prénom", firstNameField);
			put("Nom", lastNameField);
			put("Email", emailField);
			put("Mot de passe", newPasswordField);
			put("Confirmer le mot de passe", confirmPasswordField);

		}
	};

	public void clickAddUserButton() {
		addUserButton.clickOnElement();
	}

	public void setUserDetails(String userDetails, String fieldValue) {
		MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(userDetails).setTextValue(fieldValue);
	}

	public void saveAddUserButton() {
		saveAddUserButton.clickOnElement();
	}
}
