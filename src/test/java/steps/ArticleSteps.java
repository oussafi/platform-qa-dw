package steps;

import static steps.GenericSteps.switchToTabByIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.Serenity;
import pages.page.factory.article.ArticleEditorPage;

public class ArticleSteps {
	private ArticleEditorPage articleEditorPage;

	public void addArticle(Map<String, String> expectedArticleValues) {
		switchToTabByIndex(1);
		Serenity.setSessionVariable("expectedArticleValues").to(expectedArticleValues);
		for (String fieldsName : expectedArticleValues.keySet()) {
			articleEditorPage.changeFieldValue(fieldsName, expectedArticleValues.get(fieldsName));
		}
		articleEditorPage.clickPublishButton();
		switchToTabByIndex(0);
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
	}

	public void addArticleWithImage(String imageName, Map<String, String> expectedArticleValues) {
		switchToTabByIndex(1);
		Serenity.setSessionVariable("expectedArticleValues").to(expectedArticleValues);
		for (String fieldsName : expectedArticleValues.keySet()) {
			articleEditorPage.changeFieldValue(fieldsName, expectedArticleValues.get(fieldsName));
		}
		articleEditorPage.clickUploadImageIcone();
		articleEditorPage.uploadImageInContent(imageName);
		articleEditorPage.clickPublishButton();
		switchToTabByIndex(0);
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
	}

	public List<String> checkArticleWithImage() {
		switchToTabByIndex(1);
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		List<String> missingValues = new ArrayList<>();
		for (String fieldsName : expectedArticle.keySet()) {
			if (!articleEditorPage.getFieldContent(fieldsName).equals(expectedArticle.get(fieldsName)))
				missingValues.add(fieldsName);
		}
		if (!articleEditorPage.isImageDislpayedInActivityLoader())
			missingValues.add("No Image displayed");
		switchToTabByIndex(0);
		return missingValues;
	}

	public void typeArticleData(Map<String, String> expectedArticleValues) {
		switchToTabByIndex(1);
		Serenity.setSessionVariable("expectedArticleValues").to(expectedArticleValues);
		for (String fieldsName : expectedArticleValues.keySet()) {
			articleEditorPage.changeFieldValue(fieldsName, expectedArticleValues.get(fieldsName));
		}
		switchToTabByIndex(0);
	}

	public void clickDraftButton() {
		switchToTabByIndex(1);
		articleEditorPage.clickDraftButton();
		switchToTabByIndex(0);
	}

	public boolean checkDraftDetails() {
		switchToTabByIndex(1);
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		String articleTitle = expectedArticle.get("Titre");
		boolean isTitleDraftVisible = articleEditorPage.isgetDraftTitleVisible(articleTitle);
		boolean isResumeIconVisble = articleEditorPage.isResumeIconVisible();
		boolean isDeleateIconVisible = articleEditorPage.isDeleteIconVisible();
		switchToTabByIndex(0);
		return isTitleDraftVisible && isResumeIconVisble && isDeleateIconVisible;

	}

	public void clickResume() {
		switchToTabByIndex(1);
		articleEditorPage.clickResume();
		switchToTabByIndex(0);
	}

	public void clickEdit() {
		articleEditorPage.clickResume();
	}

	public List<String> checkArticleFields() {
		switchToTabByIndex(1);
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		List<String> missingValues = new ArrayList<>();
		for (String fieldsName : expectedArticle.keySet()) {
			if (fieldsName.equals("Contenu") && (!articleEditorPage.isCkEditorVivible())) {
				missingValues.add("Contenu");
			} else if (!fieldsName.equals("Contenu") && !articleEditorPage.isFieldVisible(fieldsName)) {
				missingValues.add(fieldsName);
			}
		}
		switchToTabByIndex(0);
		return missingValues;
	}

	public List<String> checkEditArticleForm() {
		Map<String, String> expectedArticle = Serenity.sessionVariableCalled("expectedArticleValues");
		List<String> missingValues = new ArrayList<>();
		for (String fieldsName : expectedArticle.keySet()) {
			if (fieldsName.equals("Contenu") && (!articleEditorPage.isCkEditorVivible())) {
				missingValues.add("Contenu");
			} else if (!fieldsName.equals("Contenu") && !articleEditorPage.isFieldVisible(fieldsName)) {
				missingValues.add(fieldsName);
			}
		}
		return missingValues;
	}

	public boolean isEditButtonDisabled() {
		return articleEditorPage.isEditButtonDisabled();
	}

	public void editArticleWithImage(String imageName, Map<String, String> expectedArticleValues) {
		Serenity.setSessionVariable("expectedArticleValues").to(expectedArticleValues);
		for (String fieldsName : expectedArticleValues.keySet()) {
			articleEditorPage.changeFieldValue(fieldsName, expectedArticleValues.get(fieldsName));
		}
		articleEditorPage.clickUploadImageIcone();
		articleEditorPage.uploadImageInContent(imageName);
		articleEditorPage.clickUpdateButton();
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
	}

	public List<String> checkArticleEditedWithImage() {
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

	public void clickPin() {
		articleEditorPage.clickPin();
	}

	public void clickShare() {
		articleEditorPage.clickShare();
	}

	public void setEspaceNameToShare(String espaceName) {
		articleEditorPage.setEspaceNameToShare(espaceName);
	}

	public void shareNews(String spaceName, String description) {
		articleEditorPage.setEspaceNameToShare(spaceName);
		articleEditorPage.setDescritionToShare(description);
		articleEditorPage.clickShareButton();

	}

	public boolean isShareButtonEnabled() {
		return articleEditorPage.isShareButtonEnabled();
	}
}
