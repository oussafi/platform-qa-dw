package stepDefinitions;

import java.util.Map;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ArticleSteps;
import steps.GenericSteps;

import static steps.GenericSteps.switchToTabByIndex;

public class ArticleStepDefinitions {
	@Steps
	private ArticleSteps articleSteps;

	@When("j'ajoute un article avec les données suivants")
	public void addArticle(Map<String, String> expectedValues) {
        articleSteps.addArticle(expectedValues);
	}
	@When("j'ajoute un article contenant une image <(.*)>")
	public void addArticleWithImage(String imageName,Map<String, String> expectedValues) {
		articleSteps.addArticleWithImage(imageName,expectedValues);
	}
}
