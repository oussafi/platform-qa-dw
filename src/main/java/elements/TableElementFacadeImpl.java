package elements;

import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.List;

public class TableElementFacadeImpl extends BaseElementFacadeImpl implements TableElementFacade {

	static final Logger LOGGER = LogManager.getLogger();
	public static final String ASCENDING_CLASSNAME = "asc";
	public static final String DESCENDING_CLASSNAME = "desc";

	public TableElementFacadeImpl(WebDriver driver, ElementLocator locator, WebElement element,
			long timeoutInMilliseconds, long waitForTimeoutInMilliseconds) {
		super(driver, locator, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
	}

	@SuppressWarnings("unchecked")
	public static <T extends TableElementFacade> T wrapWebElementFacadeInTableElement(final WebDriver driver,
			final WebElementFacade element, final long implicitTimeoutInMilliseconds,
			final long waitForTimeoutInMilliseconds) {
		return (T) new TableElementFacadeImpl(driver, null, element, implicitTimeoutInMilliseconds,
				waitForTimeoutInMilliseconds);
	}

	private List<WebElementFacade> getRowElementsList() {
		return thenFindAll(".//tbody/tr");
	}

	public int getRowsCount() {
		return getRowElementsList().size();
	}

	private TextElementFacade getCompanyByLineAndColoumn(int line, int column) {
		return findTextElementByXpath(String.format(".//tbody/tr[%d]/td[%d]", line, column));
	}

	public String getCellTextByLineAndColumn(int line, int column) {
		return getCompanyByLineAndColoumn(line, column).getContent();
	}

	private BaseElementFacade getSortIcon(int headerColumn, String validClassName, String InvalidClassName) {
		return findByXpath(String.format(
				".//thead/tr/th[%d]//i[contains(@class, 'fa-sort-%s') and not(contains(@class,'fa-sort-%s'))]",
				headerColumn, validClassName, InvalidClassName));
	}

	public boolean isAscendingSortIconDisplayed(int headerColumnIndex) {
		try {
			return getSortIcon(headerColumnIndex, ASCENDING_CLASSNAME, DESCENDING_CLASSNAME).isVisibleAfterWaiting();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDescendingSortIconDisplayed(int headerColumnIndex) {
		try {
			return getSortIcon(headerColumnIndex, DESCENDING_CLASSNAME, ASCENDING_CLASSNAME).isVisibleAfterWaiting();
		} catch (Exception e) {
			return false;
		}
	}

}
