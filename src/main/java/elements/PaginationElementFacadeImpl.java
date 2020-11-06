package elements;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class PaginationElementFacadeImpl extends BaseElementFacadeImpl implements PaginationElementFacade {

	public PaginationElementFacadeImpl(WebDriver driver, ElementLocator locator, WebElement element,
			long implicitTimeoutInMilliseconds, long waitForTimeoutInMilliseconds) {
		super(driver, locator, element, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
	}

	@SuppressWarnings("unchecked")
	public static <T extends PaginationElementFacade> T wrapWebElementFacadeInPaginationElement(final WebDriver driver,
			final WebElementFacade element, final long implicitTimeoutInMilliseconds,
			final long waitForTimeoutInMilliseconds) {
		return (T) new PaginationElementFacadeImpl(driver, null, element, implicitTimeoutInMilliseconds,
				waitForTimeoutInMilliseconds);
	}

	private BaseElementFacade getPageNumber() {
		return findByXpath(".//input[@class='pagination-input']");
	}

	private BaseElementFacade getNextPage() {
		return findByXpath(".//i[@class='icon-pagination-next']");
	}

	private BaseElementFacade getFirstPage() {
		return findByXpath(".//i[@class='icon-pagination-first']");
	}

	public int getLastPageNumber() {
		return Integer.valueOf(getPageNumber().getAttribute("max"));
	}

	public int getNumberOfFilesPerPage() {
		return Integer.valueOf(getAttribute("ng-reflect-page-size"));
	}

	public int getTotalFilesNumber() {
		return Integer.valueOf(getAttribute("ng-reflect-total-items"));
	}

	public void goToNextPage() {
		getNextPage().clickOnElement();
	}

	public void goToFirstPage() {
		getFirstPage().clickOnElement();
	}

	public int getActualPageNumber() {
		return Integer.valueOf(getAttribute("ng-reflect-page-number"));
	}

}
