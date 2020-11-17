package pages.page.factory.space;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Map;

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

public class SpaceHomePage extends GenericPage {
	public SpaceHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='activityComposer']//i[@class='uiIconEdit']")
	private BaseElementFacade postIcon;

	@FindBy(xpath = "//div[@class='undefinedAction']")
	private BaseElementFacade writeArticleLink;

	@FindBy(xpath = "//div[@class='newsTitle']//a")
	private BaseElementFacade articleTitle;

	@FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
	private BaseElementFacade ckEditorFrame;

	@FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
	private TextBoxElementFacade newsContentTextBox;

	@FindBy(xpath = "//button[contains(@class,'ignore-vuetify-classes')]")
	private BaseElementFacade publishActivityButton;

	@FindBy(xpath = "//div[@class='attachActions']//button[contains(@class,'ignore-vuetify-classes')]")
	private BaseElementFacade selectFileExistButton;

	@FindBy(xpath = "//a[@class='message']/..//i[contains(@class,'colorIcon')]")
	private BaseElementFacade switchToArticleLink;

	@FindBy(xpath = "//div[contains(@class,'attachmentsFooter')]//a")
	private BaseElementFacade applyDownloadButton;

	@FindBy(xpath = "//div[@class='newsBody']")
	private BaseElementFacade articleBody;

	@FindBy(xpath = "//div[@class='progress']")
	private BaseElementFacade progressDownloadBar;

	@FindBy(xpath = "//div[@class='attachmentsSelectorAction']")
	private BaseElementFacade attachFileLink;

	@FindBy(xpath = "//div[@class='linkPreview']")
	private BaseElementFacade linkPreview;

	@FindBy(xpath = "//a[contains(@href,'documents') and @tabindex='0']")
	private BaseElementFacade documentTab;

	@FindBy(xpath = "//div[@id='MiddleToolBar']//a[@tabindex='0'][1]")
	private BaseElementFacade activityTab;

	@FindBy(xpath = "//i[contains(@class,'iconCloud')]")
	private BaseElementFacade selectFromDocument;

	private BaseElementFacade getArticleTitle(String title) {
		return findByXpath(String.format("//div[@class='newsTitle']//a[contains(text(),'%s')]", title));
	}

	private BaseElementFacade getSpaceName(String spaceName) {
		return findByXpath(String.format("//div[@class='newsSpace']//a[contains(text(),'%s')]", spaceName));
	}

	private BaseElementFacade getReadMoreArticle(String title) {
		return findByXpath(String.format("//a[contains(text(),'%s')]//following::div[@class='readMore']//a", title));
	}

	private BaseElementFacade getActivityText(String activity) {
		return findByXpath(String.format("//div[@id='boxContainer']//p[contains(text(),'%s')]", activity));
	}

	private BaseElementFacade getSharedVideoPreview(String link) {
		return findByXpath(String.format("//div[@class='EmbedHtml']//iframe[@src='%s']", link));
	}

	private BaseElementFacade getSharedFile(String fileName) {
		return findByXpath(String.format("//div[@class='fileShare']//a[contains(text(),'%s')]", fileName));
	}

	private BaseElementFacade getExistFileToShare(String fileName) {
		return findByXpath(String.format("//div[@class='fileNameLabel' and text()='%s']", fileName));
	}

	private BaseElementFacade getDropDownActivityMenu(String activity) {
		return findByXpath(String.format(
				"//div[@id='boxContainer']//p[contains(text(),'%s')]//preceding::i[contains(@class,'uiIconActivityAction')][1]",
				activity));
	}

	private BaseElementFacade geEditActivityIcon(String activity) {
		return findByXpath(String.format(
				"//div[@id='boxContainer']//p[contains(text(),'%s')]//preceding::i[contains(@class,'uiIconEdit')][1]",
				activity));
	}

	Map<String, BaseElementFacade> MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, BaseElementFacade>() {
		{
			put("Titre", articleTitle);
			put("Contenu", articleBody);
			put("Documents", documentTab);
			put("Activité", activityTab);

		}
	};

	public void clickPostIcon() {
		postIcon.clickOnElement();
	}

	public boolean isWriteAnArticleLinkDisplayed() {
		return writeArticleLink.isVisibleAfterWaiting();
	}

	public void clickWriteArticle() {
		writeArticleLink.clickOnElement();
	}

	public String getFieldContent(String contentType) {
		try {
			return MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH.get(contentType).getText();
		} catch (NullPointerException e) {
			return "No value to return";
		}
	}

	public void clickArticleTitle(String articleTitle) {
		getArticleTitle(articleTitle).clickOnElement();
	}

	public void clickReadMore(String articleTitle) {
		getReadMoreArticle(articleTitle).clickOnElement();
	}

	public void addActivity(String activity) {
		ckEditorFrame.clickOnElement();
		Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrame);
		if (activity.contains("https")) {
			StringSelection stringSelection = new StringSelection(activity);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			newsContentTextBox.sendKeys(Keys.CONTROL + "v");
		} else if (activity.contains("lien")) {
			newsContentTextBox.clickOnElement();
			newsContentTextBox.sendKeys(Keys.PAGE_UP);
			newsContentTextBox.sendKeys(activity);
		}

		else {
			newsContentTextBox.setTextValue(activity);
			Serenity.setSessionVariable("activity").to(activity);
		}

		Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
	}

	public void publishActivity() {
		publishActivityButton.clickOnElement();
	}

	public boolean isActivityVisible(String activity) {
		return getActivityText(activity).isVisibleAfterWaiting();
	}

	public boolean isSwitchToArticleLinkDisplayed() {
		return switchToArticleLink.isVisibleAfterWaiting();
	}

	public void clickSwitchToArticleLink() {
		switchToArticleLink.clickOnElement();
	}

	public void attachFile(String fileName) {
		attachFileLink.clickOnElement();
		WebElement elem = getDriver()
				.findElement(By.xpath("//div[@class='multiploadFilesSelector']//input[@name='file']"));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) getDriver()).executeScript(js, elem);
		upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
		progressDownloadBar.waitUntilNotVisible();
	}

	public void clickApplyDownload() {
		applyDownloadButton.clickOnElement();
	}

	public boolean isSharedVideoDisplayed(String videoLink) {
		return getSharedVideoPreview(videoLink).isVisibleAfterWaiting();
	}

	public boolean isLinkPreviewVisible() {
		return linkPreview.isVisibleAfterWaiting();
	}

	public boolean isSharedFileVisible(String fileName) {
		return getSharedFile(fileName).isVisibleAfterWaiting();
	}

	public void goToSpecificTab(String tabName) {
		switch (tabName) {
		case "Documents":
			documentTab.clickOnElement();
			break;
		case "Activité":
			activityTab.sendKeys(Keys.ENTER);
			break;
		}
	}

	public void selectExistFile(String fileName) {
		attachFileLink.clickOnElement();
		selectFromDocument.clickOnElement();
		getExistFileToShare(fileName).clickOnElement();
	}

	public void clickSelectFileButton() {
		selectFileExistButton.clickOnElement();
	}

	public void openEditActivityMenu(String activity) {
		getDropDownActivityMenu(activity).clickOnElement();
		geEditActivityIcon(activity).clickOnElement();
	}

	public void clickSpace(String spaceName) {
		getSpaceName(spaceName).clickOnElement();
	}
}
