package elements;

import net.serenitybdd.core.annotations.ImplementedBy;

@ImplementedBy(TableElementFacadeImpl.class)
public interface TableElementFacade extends BaseElementFacade {

	/**
	 * This method returns the number of table rows
	 * 
	 * @return number of rows
	 */
	public int getRowsCount();

	/**
	 * This method returns the text of a cell based on lineIndex and columnIndex
	 * 
	 * @return text of the cell based on lineIndex and columnIndex
	 */
	public String getCellTextByLineAndColumn(int line, int column);

	/**
	 * This method returns the visibility of the right sort icon
	 * 
	 * @return true: if the right Ascending sort icon is displayed ,false: if not
	 */
	public boolean isAscendingSortIconDisplayed(int headerColumnIndex);

	/**
	 * This method returns the visibility of the right sort icon
	 * 
	 * @return true: if the right Descending sort icon is displayed ,false: if not
	 */
	public boolean isDescendingSortIconDisplayed(int headerColumnIndex);
}
