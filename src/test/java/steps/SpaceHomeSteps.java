package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.Serenity;
import pages.page.factory.article.ArticleEditorPage;
import pages.page.factory.space.SpaceHomePage;

public class SpaceHomeSteps {

	private SpaceHomePage spaceHomePage;
	private ArticleEditorPage articleEditorPage;

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

	public void clickArticleTitle() {
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		String articleTitle = expectedArticle.get("Titre");
		spaceHomePage.clickArticleTitle(articleTitle);
	}

	public List<String> checkArticleWithImage() {
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		List<String> missingValues = new ArrayList<>();
		for (String fieldsName : expectedArticle.keySet()) {
			if (!articleEditorPage.getFieldContent(fieldsName).equals(expectedArticle.get(fieldsName)))
				missingValues.add(fieldsName);
		}
		if (!articleEditorPage.isImageDislpayedInActivityLoader())
			missingValues.add("No Image displayed");
		return missingValues;
	}

	public void clickReadMore() {
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		String articleTitle = expectedArticle.get("Titre");
		spaceHomePage.clickReadMore(articleTitle);
	}

	public void addActicity(String activity) {
		spaceHomePage.addActivity(activity);
	}

	public void publishActicity() {
		spaceHomePage.publishActivity();
	}

	public boolean isActivityVisible(String activity) {
		return spaceHomePage.isActivityVisible(activity);
	}

	public boolean isSwitchToArticleLinkDisplayed() {
		return spaceHomePage.isSwitchToArticleLinkDisplayed();
	}

	public void clickSwitchToArticleLink() {
		spaceHomePage.clickSwitchToArticleLink();
	}

	public void attachFile(String fileName) {
		Serenity.setSessionVariable("fileName").to(fileName);
		spaceHomePage.attachFile(fileName);
		spaceHomePage.clickApplyDownload();
	}

	public boolean isSharedVideoDisplayed(String videoLink) {
		return spaceHomePage.isSharedVideoDisplayed(videoLink);
	}

	public boolean isLinkPreviewVisible() {
		return spaceHomePage.isLinkPreviewVisible();
	}

	public boolean isSharedFileVisible(String fileName) {
		return spaceHomePage.isSharedFileVisible(fileName);
	}

	public void goToSpecificTab(String tabName) {
		spaceHomePage.goToSpecificTab(tabName);
	}

	public void selectFileExiste(String fileName) {
		spaceHomePage.selectExistFile(fileName);
		spaceHomePage.clickSelectFileButton();
		spaceHomePage.clickApplyDownload();
	}
	
	public void openEditActivityMenu(String activity){
		spaceHomePage.openEditActivityMenu(activity);
	}
	public void clickSpace(String spaceName){
		spaceHomePage.clickSpace(spaceName);
	}
}
