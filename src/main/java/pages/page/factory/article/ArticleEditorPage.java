package pages.page.factory.article;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class ArticleEditorPage extends GenericPage {
	public ArticleEditorPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "newsTitle")
	private TextBoxElementFacade newsTileTextBox;
	@FindBy(id = "newsSummary")
	private TextBoxElementFacade newsSummaryTextBox;
	@FindBy(xpath = "//body[contains(@class,'newsContent')]")
	private TextBoxElementFacade newsContentTextBox;
	@FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
	private BaseElementFacade ckEditorFrame;

	@FindBy(xpath = "//a[contains(@class,'cke_button__selectimage')]//span")
	private BaseElementFacade uploadImageIcon;

	@FindBy(id = "newsPost")
	private BaseElementFacade publishButton;

	@FindBy(xpath = "//a[@title='OK' and @disabled='disabled']")
	private BaseElementFacade validateUploadButtonDisabled;

	@FindBy(xpath = "//a[@title='OK']")
	private BaseElementFacade validateUploadButton;

	Map<String, TextBoxElementFacade> MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH = new HashMap<String, TextBoxElementFacade>() {
		{
			put("Titre", newsTileTextBox);
			put("Résumé", newsSummaryTextBox);
			put("Contenu", newsContentTextBox);

		}
	};

	public void changeFieldValue(String fieldType, String fieldValue) {
		if (fieldType.equals("Contenu")) {
			Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrame);
			newsContentTextBox.setTextValue(fieldValue);
			Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
		} else {
			MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH.get(fieldType).setTextValue(fieldValue);
		}
	}

	public void clickPublishButton() {
		publishButton.clickOnElement();
	}

	public void clickUploadImageIcone() {
		uploadImageIcon.clickOnElement();
	}

	public void uploadImageInContent(String imageName) {
		WebElement elem = getDriver().findElement(By.xpath("//div[@class='dropFileArea']//input[@class='file']"));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) getDriver()).executeScript(js, elem);
		upload(UPLOAD_DIRECTORY_PATH + imageName).fromLocalMachine().to(elem);
		clickValidateUpload();
	}

	public void clickValidateUpload() {
		if (validateUploadButtonDisabled.isNotVisibleAfterWaiting())
			validateUploadButton.clickOnElement();
	}
}
