package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ArticleSteps;

public class ArticleStepDefinitions {
	@Steps
	private ArticleSteps articleSteps;

	@When("j'ajoute un article avec les données suivants")
	public void addArticle(Map<String, String> expectedValues) {
		articleSteps.addArticle(expectedValues);
	}

	@When("j'ajoute un article contenant une image <(.*)>")
	public void addArticleWithImage(String imageName, Map<String, String> expectedValues) {
		articleSteps.addArticleWithImage(imageName, expectedValues);
	}

	@When("l'article est affiché avec l'image ajoutée")
	public void checkArticleWithImage() {
		assertThat(articleSteps.checkArticleWithImage()).as("l'article n'est pas ajouté").isEmpty();
	}

	@When("je saisie les données de l'article")
	public void typeArticleData(Map<String, String> expectedValues) {
		articleSteps.typeArticleData(expectedValues);
	}

	@When("je clique sur 'Brouillons'")
	public void clickDraftButton() {
		articleSteps.clickDraftButton();
	}

	@When("Les détails du brouillons sont affichés")
	public void checkDraft() {
		assertThat(articleSteps.checkDraftDetails()).as("Draft details should be displayed but it is not").isTrue();
	}

	@When("je clique sur 'resume'")
	public void clickResume() {
		articleSteps.clickResume();
	}

	@When("La formulaire ajouter un article est affichée")
	public void checkArticleForm() {
		assertThat(articleSteps.checkArticleFields())
				.as(String.format("La formulaire n'est pas affichée", articleSteps.checkArticleFields())).isEmpty();
	}

	@When("je clique sur 'edit'")
	public void clickEdit() {
		articleSteps.clickEdit();
	}

	@When("La page 'modifier un article' est affichée")
	public void checkEditForm() {
		assertThat(articleSteps.checkEditArticleForm())
				.as(String.format("La formulaire n'est pas affichée", articleSteps.checkArticleFields())).isEmpty();
	}

	@When("le button est désactivé par défaut")
	public void checkEditButton() {
		assertThat(articleSteps.isEditButtonDisabled())
				.as("Le button modifier n'est pas désactivée par default").isTrue();
	}

	@When("je modifie l'article contenant une image <(.*)>")
	public void editArticle(String imageName, Map<String, String> expectedValues) {
		articleSteps.editArticleWithImage(imageName, expectedValues);
	}

	@When("l'article modifié est affiché avec l'image ajoutée")
	public void checkArticleEditedWithImage() {
		assertThat(articleSteps.checkArticleEditedWithImage()).as("l'article n'est pas ajouté").isEmpty();
	}

	@When("je clique sur 'Pin un article'")
	public void clickPinArticle() {
		articleSteps.clickPin();
	}

	@When("je clique sur 'Partager'")
	public void clickShare() {
		articleSteps.clickShare();
	}
	@When("je choisis l'espace '(.*)' pour partager l'article")
	public void clickShare(String espaceName) {
		articleSteps.setEspaceNameToShare(espaceName);
	}
	@Then("le button partager est activé")
	public void checkShareButton(){
		assertThat(articleSteps.isShareButtonEnabled()).as("Share button should be enabled but it is not").isTrue();
	}

	@Then("je partage l'article avec l'espace '(.*)' et la description'(.*)'")
	public void shareNew(String spaceName,String description){
		articleSteps.shareNews(spaceName,description);
	}
}
