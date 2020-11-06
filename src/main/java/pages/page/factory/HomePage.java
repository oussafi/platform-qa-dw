package pages.page.factory;

import elements.BaseElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import pages.GenericPage;

public class HomePage extends GenericPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='HamburgerNavigationMenuLink']")
    private BaseElementFacade hamburgerNavigationMenuLink;

    @FindBy(xpath = "//a[@href='/portal/dw/spaces']")
    private BaseElementFacade openSpacesPageLink;

    public void goToSpacesPage() {
        hamburgerNavigationMenuLink.clickOnElement();
        openSpacesPageLink.clickOnElement();
    }

    public boolean isHomePageDisplayed(){
        return hamburgerNavigationMenuLink.isVisibleAfterWaiting();
    }
}
