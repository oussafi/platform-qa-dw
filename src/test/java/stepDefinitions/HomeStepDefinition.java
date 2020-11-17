package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;

public class HomeStepDefinition {
	@Steps
	private HomeSteps homeSteps;

	@When("je navigue vers la page actualité")
	public void goToNewsApp() {
		homeSteps.goToNewsApp();
	}

	@When("les sections suivants sont affiché")
	public void checkSections(List<String> sliderList) {
		assertThat(homeSteps.checkSections(sliderList))
				.as(String.format("The section %s is not visible", homeSteps.checkSections(sliderList))).isEmpty();
	}

	@When("le slider est affiché dans la page d'acceuil")
	public void checkSlider() {
		assertThat(homeSteps.checkSlider()).as("The slider is not visible", homeSteps.checkSlider()).isTrue();
	}

	@When("je navigue vers la page d'acceuil")
	public void goToHomePage() {
		homeSteps.goToHomePage();
	}

	@When("les news sont affiché dans le widget")
	public void checkNews() {
		assertThat(homeSteps.isNewsDisplayedInWidget()).as("News are not displayed in widget").isTrue();
	}

	@When("le button voir plus est affiché")
	public void checkSeeMore() {
		assertThat(homeSteps.isSeeMoreNewsButtonVisible()).as("See more News button is not displayed in widget")
				.isTrue();
	}

	@When("je clique sur wallet label")
	public void clickWallet() {
		homeSteps.clickWalletWidget();
	}

	@When("la page wallet est ouverte")
	public void checkWalletPage() {
		assertThat(homeSteps.checkWalletPage()).as("Wallet page is not opened").isTrue();
	}

	@Then("^Le nombre '(.*)' est '(.*)'$")
	public void checkWidgetContent(String widget, String number) {
		assertThat(homeSteps.isWidgetWithNumberVisible(widget, number))
				.as(String.format("La widget %s doit avoir le nombre %s", widget, number)).isTrue();
	}

	@Then("^le nombre d'invitation pour un espace est '(.*)'$")
	public void checkBagde(String number) {
		assertThat(homeSteps.isBadgeWithNumberVisible(number))
				.as(String.format("La badge doit avoir le nombre %s", number)).isTrue();
	}

	@When("je clique sur le badge '(.*)'")
	public void clickBadge(String badgeNumber) {
		homeSteps.clickBadge(badgeNumber);
	}

	@Then("^le drawer contient '(.*)' espaces est ouvert$")
	public void checkSpaceDrawer(String number) {
		assertThat(homeSteps.isNumberOfSpacesInDrawer(number))
				.as(String.format("Le nombre d'espace dans le drawer n'est pas égale à %s", number)).isTrue();
	}

	@When("j'accepte l'invitation des espaces suivant")
	public void acceptSpaces(List<String> listOfSpace) {
		homeSteps.acceptSpaceInvitation(listOfSpace);
	}

	@When("je rejecte l'invitation des espaces suivant")
	public void rejectSpaces(List<String> listOfSpace) {
		homeSteps.rejectSpaceInvitation(listOfSpace);
	}
}
