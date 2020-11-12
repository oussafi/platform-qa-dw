package stepDefinitions;

import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.ArticleSearchSteps;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchArticleStepDefinition {
	@Steps
	private ArticleSearchSteps articleSearchSteps;

	@When("je je cherche l'article '(.*)'")
	public void searchArticle(String articleData) {
		articleSearchSteps.searchArticle(articleData);
	}

    @When("l'article recherché est affiché")
    public void checkSearchedArticle() {
        Map<String,String> expectedArticleValues=Serenity.sessionVariableCalled("expectedArticleValues");
	    String article= expectedArticleValues.get("Titre");
        assertThat(articleSearchSteps.isSearchedArticleVisible(article)).as("The searched article is not displayed").isTrue();
    }

    @When("aucun article trouvé")
    public void checkNoArticle() {
        assertThat(articleSearchSteps.isNoArticleMessageDiplayed()).as("No article found should be displayed").isTrue();
    }
}
