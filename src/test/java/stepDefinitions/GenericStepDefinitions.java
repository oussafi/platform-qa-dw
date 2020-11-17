package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.GenericSteps;

public class GenericStepDefinitions {
	@Steps
	GenericSteps genericSteps;

	@When("un message de confirmation est affiché '(.*)'")
    public void checkConfirmMessage(String message) {
        assertThat(genericSteps.inConfirmMessageDisplayed(message)).as(String.format("Confirm message %s should be displayed but it is not",message)).isTrue();
    }

    @When("un message de succès est affiché")
    public void checkSuccessMessage() {
        assertThat(genericSteps.isSuccessMessageDisplayed()).as(String.format("Success message should be displayed but it is not")).isTrue();
    }

    @When("un button '(.*)' est affiché")
    public void checkButton(String button) {
        assertThat(genericSteps.isButtonDisplayed(button)).as(String.format("The button %s should be displayed but it is not",button)).isTrue();
    }

    @When("^je confirme$")
    public void clickConfirm() {
        genericSteps.clickConfirm();
    }
}
