package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.DocumentsSteps;

public class DocumentsStepDefinition {
	@Steps
	DocumentsSteps documentsSteps;

	@Then("^je selectionne le repertoire '(.*)'$")
	public void goToFolder(String folder) {
		documentsSteps.goToSpecificFolder(folder);
	}

	@Then("^je télécharge le fichier '(.*)'$")
	public void uploadFile(String fileName) {
		documentsSteps.uploadFile(fileName);
	}

	@Then("^Le fichier '(.*)' est téléchargé$")
	public void isFileUploaded(String fileName) {
		assertThat(documentsSteps.isFileUploaded(fileName)).as("Le fichier doit être téléchargé").isTrue();
	}
}
