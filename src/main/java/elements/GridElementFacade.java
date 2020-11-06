package elements;

import net.serenitybdd.core.annotations.ImplementedBy;

@ImplementedBy(GridElementFacadeImpl.class)
public interface GridElementFacade extends BaseElementFacade {

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

	/**
	 * This method will sort the DataGrid based on the Column Index
	 * 
	 * 
	 */
	void sortDataGridByColumn(int columnIndex);

	/**
	 * this method will return the index of the header column based on the
	 * ColumnName
	 * 
	 * @return the index of the header Column based on the columnName
	 */
	int getHeaderColumnIndex(String columnName);
}
