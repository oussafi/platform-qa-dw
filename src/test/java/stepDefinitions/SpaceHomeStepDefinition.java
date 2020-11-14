package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
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

	@When("^je saisie une activité '(.*)'$")
	public void addActivity(String activity) {
		spaceHomeSteps.addActicity(activity);
	}

	@When("je saisie une activité plus de 1300 caractères")
	public void addActivityExceed() {
		String activity = StringUtils.repeat("activity to add", 90);
		spaceHomeSteps.addActicity(activity);
		Serenity.setSessionVariable("activity").to(activity);
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

	@Then("Un lien qui permet de basculer vers un article est affiché")
	public void checkSwitchToArticleLink() {
		assertThat(spaceHomeSteps.isSwitchToArticleLinkDisplayed())
				.as("Switch to article link should be displayed but it is not").isTrue();
	}

	@Then("je clique sur basculer vers un article")
	public void clickSwitchToArticleLink() {
		spaceHomeSteps.clickSwitchToArticleLink();
	}

	@Then("j'atache le fichier '(.*)'")
	public void attachFile(String fileName) {
		spaceHomeSteps.attachFile(fileName);
	}

	@Then("le video '(.*)' est affiché dans l'activity stream")
	public void checkDisplayVideo(String videoLink) {
		assertThat(spaceHomeSteps.isSharedVideoDisplayed(videoLink))
				.as("shared video link should be displayed but it is not").isTrue();
	}

	@Then("Le lien est affiché avec le preview")
	public void checkPreviewLink() {
		assertThat(spaceHomeSteps.isLinkPreviewVisible()).as("The link preview is not displayed").isTrue();
	}

	@Then("le fichier '(.*)' est partagé dans l'activity stream")
	public void checkFileShared(String fileName) {
		assertThat(spaceHomeSteps.isSharedFileVisible(fileName)).as("shared file should be displayed but it is not")
				.isTrue();
	}

	@Then("^je navigue vars '(.*)' tab$")
	public void goToTab(String tabName) {
		spaceHomeSteps.goToSpecificTab(tabName);
	}

	@Then("^je selectionne le fichier existant '(.*)'$")
	public void selectExistFile(String fileName) {
		spaceHomeSteps.selectFileExiste(fileName);
	}

	@When("^je clique sur modifier l'activité$")
	public void openEditActivityMenu() {
		String oldActiviyy = Serenity.sessionVariableCalled("activity");
		spaceHomeSteps.openEditActivityMenu(oldActiviyy);
	}

}
