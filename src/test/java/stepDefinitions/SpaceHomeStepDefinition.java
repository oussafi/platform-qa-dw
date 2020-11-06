package stepDefinitions;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SpaceHomeSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceHomeStepDefinition {
    @Steps
    private SpaceHomeSteps spaceHomeSteps;

    @When("je clique sur poster dans l'espace")
    public void clickPostIcon() {
        spaceHomeSteps.clickPostIcon();
    }

    @When("le lien 'écrire un article' est affiché dans le drawer")
    public void checkWriteAnArticleLink() {
        assertThat(spaceHomeSteps.isWriteArticleLinkDisplayed()).as("The write an article link should be displayed but it is not").isTrue();
    }
}
