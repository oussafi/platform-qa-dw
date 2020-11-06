package steps;

import net.thucydides.core.annotations.Steps;
import pages.page.factory.space.SpaceHomePage;

public class SpaceHomeSteps {

    private SpaceHomePage spaceHomePage;

    public void clickPostIcon() {
        spaceHomePage.clickPostIcon();
    }

    public boolean isWriteArticleLinkDisplayed() {
        return spaceHomePage.isWriteAnArticleLinkDisplayed();
    }
}
