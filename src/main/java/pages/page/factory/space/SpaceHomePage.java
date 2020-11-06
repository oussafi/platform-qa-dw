package pages.page.factory.space;

import elements.BaseElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import pages.GenericPage;

public class SpaceHomePage extends GenericPage {
    public SpaceHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='activityComposer']//i[@class='uiIconEdit']")
    private BaseElementFacade postIcon;

    @FindBy(xpath = "//div[@class='undefinedAction']")
    private BaseElementFacade writeArticleLink;

    public void clickPostIcon() {
        postIcon.clickOnElement();
    }

    public boolean isWriteAnArticleLinkDisplayed() {
       return writeArticleLink.isVisibleAfterWaiting();
    }
}
