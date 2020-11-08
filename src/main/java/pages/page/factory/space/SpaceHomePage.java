package pages.page.factory.space;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
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
}
