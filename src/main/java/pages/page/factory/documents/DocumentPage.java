package pages.page.factory.documents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class DocumentPage extends GenericPage {
	public DocumentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='address']")
	private TextBoxElementFacade adressFolderInput;

	@FindBy(xpath = "//div[@class='bar']")
	private TextBoxElementFacade progressDownloadBar;

	private BaseElementFacade getFileNameInListOfDocuments(String fileName) {
		return findByXpath(
				String.format("//div[@class='actionIconBox']//div[contains(@data-original-title,'%s')]", fileName));
	}

	public void goToSpecificFolder(String folder) {
		adressFolderInput.setTextValue(folder, Keys.ENTER);
	}

	public void uploadFile(String fileName) {
		WebElement elem = getDriver().findElement(By.xpath("//input[@id='MultiUploadInputFiles']"));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) getDriver()).executeScript(js, elem);
		upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
		progressDownloadBar.waitUntilNotVisible();
		Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
	}

	public boolean isFileUploaded(String fileName){
	    return getFileNameInListOfDocuments(fileName).isVisibleAfterWaiting();
    }
}
