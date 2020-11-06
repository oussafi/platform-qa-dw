package elements;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.Properties;

public class GridElementFacadeImpl extends BaseElementFacadeImpl implements GridElementFacade {

	public static final String ASCENDING_CLASSNAME = "asc";
	public static final String DESCENDING_CLASSNAME = "desc";
	private Properties translationsProperties;

	public GridElementFacadeImpl(WebDriver driver, ElementLocator locator, WebElement element,
			long timeoutInMilliseconds, long waitForTimeoutInMilliseconds) {
		super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
		translationsProperties = Serenity.sessionVariableCalled("translationsProperties");
	}

	@SuppressWarnings("unchecked")
	public static <T extends GridElementFacade> T wrapWebElementFacadeInGridElement(final WebDriver driver,
			final WebElementFacade element, final long implicitTimeoutInMilliseconds,
			final long waitForTimeoutInMilliseconds) {
		return (T) new GridElementFacadeImpl(driver, null, element, implicitTimeoutInMilliseconds,
				waitForTimeoutInMilliseconds);
	}

	private TextElementFacade getCompanyByLineAndColoumn(int line, int column) {
		return findTextElementByXpath(String.format(
				".//div [contains(@class,'adp-advance-datagrid__body-row')][%d]/adp-datagrid-cell[@ng-reflect-index='%d']",
				line, column));
	}

	private BaseElementFacade getSortIcon(int column, String validClassName, String invalidClassName) {
		return findByXpath(String.format(
				".//adp-datagrid-header[@ng-reflect-index='%d']//i[contains(@class,'fa-sort-%s') and not(contains(@class,'fa-sort-%s'))]",
				column, validClassName, invalidClassName));
	}

	private TextElementFacade getHeaderColumn(int column) {
		return findTextElementByXpath(String.format(".//adp-datagrid-header [@ng-reflect-index='%d']", column));
	}

	private TextElementFacade getHeaderColumnByIndex(String columnName) {
		return findTextElementByXpath(
				String.format("//adp-datagrid-header//span[text()='%s']/ancestor::adp-datagrid-header",
						translationsProperties.get(columnName)));
	}

	public boolean isAscendingSortIconDisplayed(int headerColumnIndex) {
		return getSortIcon(headerColumnIndex, ASCENDING_CLASSNAME, DESCENDING_CLASSNAME).isVisibleAfterWaiting();
	}

	public boolean isDescendingSortIconDisplayed(int headerColumnIndex) {
		return getSortIcon(headerColumnIndex, DESCENDING_CLASSNAME, ASCENDING_CLASSNAME).isVisibleAfterWaiting();
	}

	public String getCellTextByLineAndColumn(int line, int column) {
		return getCompanyByLineAndColoumn(line, column).getContent();
	}

	public void sortDataGridByColumn(int columnIndex) {
		getHeaderColumn(columnIndex).clickOnElement();
	}

	public int getHeaderColumnIndex(String columnName) {
		return Integer.valueOf(getHeaderColumnByIndex(columnName).getAttribute("ng-reflect-index"));
	}
}
