package steps;

import java.util.Map;

import net.serenitybdd.core.Serenity;
import pages.page.factory.article.ArticleEditorPage;

import static steps.GenericSteps.switchToTabByIndex;

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
	}

	public void addArticleWithImage(String imageName,Map<String, String> expectedArticleValues){
		switchToTabByIndex(1);
		Serenity.setSessionVariable("expectedArticleValues").to(expectedArticleValues);
		for (String fieldsName : expectedArticleValues.keySet()) {
			articleEditorPage.changeFieldValue(fieldsName, expectedArticleValues.get(fieldsName));
		}
		articleEditorPage.clickUploadImageIcone();
		articleEditorPage.uploadImageInContent(imageName);
		articleEditorPage.clickPublishButton();
		switchToTabByIndex(0);
	}
}
