package steps;

import pages.page.factory.article.ArticleSearchPage;

public class ArticleSearchSteps {
	private ArticleSearchPage articleSearchPage;

	public void searchArticle(String article) {
		articleSearchPage.setTextInSearchField(article);
	}

	public boolean isSearchedArticleVisible(String article) {
		return articleSearchPage.isSearchedArticleVisible(article);
	}

	public boolean isNoArticleMessageDiplayed(){
        return articleSearchPage.isNoArticleMessageDiplayed();
    }
}
