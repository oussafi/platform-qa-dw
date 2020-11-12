package pages.page.factory.article;

import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class ArticleSearchPage extends GenericPage {
	public ArticleSearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[contains(@class,'searchNewsInput')]")
	private TextBoxElementFacade searchInput;

	@FindBy(className = "iconNotFound")
	private BaseElementFacade articleNotFoundIcon;

	private BaseElementFacade getSearchedArticle(String article) {
		return findByXpath(String.format("//div[@id='newsListItems']//a[contains(text(),'%s')]", article));
	}

	public void setTextInSearchField(String article) {
		searchInput.setTextValue(article);
	}

	public boolean isSearchedArticleVisible(String article) {
		return getSearchedArticle(article).isVisibleAfterWaiting();
	}

	public boolean isNoArticleMessageDiplayed() {
		return articleNotFoundIcon.isVisibleAfterWaiting();
	}
}
