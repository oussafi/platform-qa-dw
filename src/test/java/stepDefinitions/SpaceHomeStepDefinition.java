package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SpaceHomeSteps;

public class SpaceHomeStepDefinition {
	@Steps
	private SpaceHomeSteps spaceHomeSteps;

	@When("^je clique sur poster dans l'espace$")
	public void clickPostIcon() {
		spaceHomeSteps.clickPostIcon();
	}

	@When("^le lien 'écrire un article' est affiché dans le drawer$")
	public void checkWriteAnArticleLink() {
		assertThat(spaceHomeSteps.isWriteArticleLinkDisplayed())
				.as("The write an article link should be displayed but it is not").isTrue();
	}

	@When("^je clique sur 'écrire un article'$")
	public void clickWriteAnArticle() {
		spaceHomeSteps.clickWriteArticle();
	}

	@Then("L'article est affiché dans l'activity stream de l'espace")
	public void checkArticleVisible() {
		assertThat(spaceHomeSteps.checkArticleDetails()).as("The article details should be displayed but it is not")
				.isEmpty();
	}

	@Then("je clique sur le titre de l'article dans l'activity stream")
	public void clickArticleTitle() {
		spaceHomeSteps.clickArticleTitle();
	}

	@When("l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace")
	public void checkArticleWithImage() {
		assertThat(spaceHomeSteps.checkArticleWithImage()).as("l'article n'est pas ajouté").isEmpty();
	}

	@Then("je clique sur 'lire la suite' de l'article dans l'activity stream")
	public void clickReadMore() {
		spaceHomeSteps.clickReadMore();
	}

	@When("je saisie une activité '(.*)'")
	public void addActivity(String activity) {
		spaceHomeSteps.addActicity(activity);
	}

	@When("^je publie l'activité$")
	public void publishActivity() {
		spaceHomeSteps.publishActicity();
	}

	@Then("l'activité '(.*)' est affiché dans l'activity stream")
	public void checkActivity(String activity) {
		assertThat(spaceHomeSteps.isActivityVisible(activity))
				.as("L'activité n'est pas affichée dans l'activity stream").isTrue();
	}
}
