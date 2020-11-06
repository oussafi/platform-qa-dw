package pages.page.factory;

import elements.ButtonElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GenericPage;

@DefaultUrl("https://baseUrl/")
public class LoginPage extends GenericPage {
    public LoginPage() {
        url = "firstPage";
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private TextBoxElementFacade loginTextBox;

    @FindBy(id = "password")
    private TextBoxElementFacade passwordTextbox;

    @FindBy(tagName = "button")
    private ButtonElementFacade loginButton;

    public void login(String login, String password) {
        loginTextBox.setTextValue(login);
        passwordTextbox.setTextValue(password);
        loginButton.clickOnElement();
    }

}
