package steps;

import pages.page.factory.documents.DocumentPage;

public class DocumentsSteps {
	private DocumentPage documentPage;

	public void goToSpecificFolder(String folder) {
		documentPage.goToSpecificFolder("/" + folder);
	}

	public void uploadFile(String fileName) {
		documentPage.uploadFile(fileName);
	}

	public boolean isFileUploaded(String fileName) {
		return documentPage.isFileUploaded(fileName);
	}
}
