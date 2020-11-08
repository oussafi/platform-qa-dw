package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.Serenity;
import pages.page.factory.space.SpaceHomePage;

public class SpaceHomeSteps {

	private SpaceHomePage spaceHomePage;

	public void clickPostIcon() {
		spaceHomePage.clickPostIcon();
	}

	public boolean isWriteArticleLinkDisplayed() {
		return spaceHomePage.isWriteAnArticleLinkDisplayed();
	}

	public void clickWriteArticle() {
		spaceHomePage.clickWriteArticle();
	}

	public List<String> checkArticleDetails() {
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
		List<String> missingValues = new ArrayList<>();
		for (String fieldsName : expectedArticle.keySet()) {
			if (!spaceHomePage.getFieldContent(fieldsName).equals(expectedArticle.get(fieldsName)))
				missingValues.add(fieldsName);
		}
		return missingValues;
	}
}
