package pages.page.factory.space;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
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

	private BaseElementFacade getArticleTitle(String title) {
		return findByXpath(String.format("//div[@class='newsTitle']//a[contains(text(),'%s')]", title));
	}

	private BaseElementFacade getReadMoreArticle(String title) {
		return findByXpath(String.format("//a[contains(text(),'%s')]//following::div[@class='readMore']//a", title));
	}

	private BaseElementFacade getActivityText(String activity) {
		return findByXpath(String.format("//div[@id='boxContainer']//p[contains(text(),'%s')]", activity));
	}

	@FindBy(xpath = "//div[@class='newsBody']")
	private BaseElementFacade articleBody;
	Map<String, BaseElementFacade> MAPPING_FIELD_Name_TO_BASEELEMENTFACADE_XPATH = new HashMap<String, BaseElementFacade>() {
		{
			put("Titre", articleTitle);
			put("Contenu", articleBody);

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
		newsContentTextBox.setTextValue(activity);
		Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
	}

	public void publishActivity() {
		publishActivityButton.clickOnElement();
	}

	public boolean isActivityVisible(String activity) {
		return getActivityText(activity).isVisibleAfterWaiting();
	}
}
