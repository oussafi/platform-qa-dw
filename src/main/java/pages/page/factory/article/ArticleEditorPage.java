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

	@FindBy(xpath = "//div[contains(@class,'progress-striped')]")
	private BaseElementFacade uploadProgressBar;

	@FindBy(xpath = "//a[contains(@class,'newsTitleLink')]")
	private BaseElementFacade titleLinkInActivityLoader;

	@FindBy(xpath = "//div[@id='newsSummary']//span")
	private BaseElementFacade SummaryInActivityLoader;

	@FindBy(xpath = "//div[@id='newsBody']//span//p")
	private BaseElementFacade bodyInActivityLoader;

	@FindBy(xpath = "//img[@data-plugin-name='selectImage']")
	private BaseElementFacade imageInActivityLoader;

	@FindBy(id = "newsDraftButton")
	private TextBoxElementFacade newsDraftButton;

	@FindBy(className = "draftModifiedTime")
	private TextBoxElementFacade draftModifiedTime;

	@FindBy(xpath = "//i[@class='uiIconEdit']")
	private TextBoxElementFacade resumeIcon;

	@FindBy(xpath = "//i[@class='uiIconDelete']")
	private TextBoxElementFacade deleteIcon;

	@FindBy(xpath = "//button[@id='newsEdit']")
	private TextBoxElementFacade editButton;

	@FindBy(id = "newsPinButton")
	private TextBoxElementFacade pinArticleButton;

	@FindBy(id = "newsShareButton")
	private BaseElementFacade newsShareButton;

	@FindBy(xpath = "//div[contains(@class,'selectize-input')]//input")
	private TextBoxElementFacade selectEspaceToShare;

	@FindBy(className = "newsShareDescription")
	private TextBoxElementFacade selectDescriptionToShare;

	@FindBy(xpath = "//div[@class='shareButtons']//button[1]")
	private BaseElementFacade shareButtonInDrawer;

	private BaseElementFacade getDraftTitle(String draftTitle) {
		return findByXpath(String.format("//p[@class='draftTitle']//b[contains(text(),'%s')]", draftTitle));
	}

	private BaseElementFacade getSelectSpaceInDropDown(String spaceName) {
		return findByXpath(String.format("//div[@class='optionItem' and @data-value='%s']", spaceName));
	}

	Map<String, TextBoxElementFacade> MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH = new HashMap<String, TextBoxElementFacade>() {
		{
			put("Titre", newsTileTextBox);
			put("Résumé", newsSummaryTextBox);
			put("Contenu", newsContentTextBox);

		}
	};

	Map<String, BaseElementFacade> MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, BaseElementFacade>() {
		{
			put("Titre", titleLinkInActivityLoader);
			put("Résumé", SummaryInActivityLoader);
			put("Contenu", bodyInActivityLoader);

		}
	};

	public void changeFieldValue(String fieldType, String fieldValue) {
		if (fieldType.equals("Contenu")) {
			ckEditorFrame.clickOnElement();
			Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrame);
			newsContentTextBox.setTextValue(fieldValue);
			Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
		} else {
			MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH.get(fieldType).setTextValue(fieldValue);
		}
	}

	public boolean isFieldVisible(String fieldType) {
		return MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH.get(fieldType).isVisibleAfterWaiting();

	}

	public boolean isCkEditorVivible() {
		return ckEditorFrame.isVisibleAfterWaiting();
	}

	public void clickPublishButton() {
		publishButton.clickOnElement();
		publishButton.waitUntilNotVisible();
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
		if (uploadProgressBar.isNotVisibleAfterWaiting())
			validateUploadButton.clickOnElement();
	}

	public String getFieldContent(String contentType) {
		try {
			return MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH.get(contentType).getText();
		} catch (Exception e) {
			return "No value to return";
		}
	}

	public boolean isImageDislpayedInActivityLoader() {
		return imageInActivityLoader.isVisibleAfterWaiting();
	}

	public void clickDraftButton() {
		newsDraftButton.clickOnElement();
	}

	public boolean isgetDraftTitleVisible(String title) {
		return getDraftTitle(title).isVisibleAfterWaiting();
	}

	public boolean isResumeIconVisible() {
		return resumeIcon.isVisibleAfterWaiting();
	}

	public boolean isDeleteIconVisible() {
		return deleteIcon.isVisibleAfterWaiting();
	}

	public void clickResume() {
		resumeIcon.clickOnElement();
	}

	public boolean isEditButtonDisabled() {
		return editButton.isDisabledAfterWaiting();
	}

	public void clickUpdateButton() {
		editButton.clickOnElement();
	}

	public void clickPin() {
		pinArticleButton.clickOnElement();
	}

	public void clickShare() {
		newsShareButton.clickOnElement();
	}

	public void setEspaceNameToShare(String spaceName) {
		selectEspaceToShare.setTextValue(spaceName);
		getSelectSpaceInDropDown(spaceName).clickOnElement();
	}

	public void setDescritionToShare(String description) {
		selectDescriptionToShare.setTextValue(description);
	}

	public void clickShareButton(){
		shareButtonInDrawer.clickOnElement();
	}

	public boolean isShareButtonEnabled() {
		return shareButtonInDrawer.isEnabledAfterWaiting();
	}
}
