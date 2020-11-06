package elements;

import net.serenitybdd.core.annotations.ImplementedBy;

@ImplementedBy(PaginationElementFacadeImpl.class)
public interface PaginationElementFacade extends BaseElementFacade {

	/**
	 * this method will return the last page number
	 * 
	 * @return the number of the last page
	 */
	int getLastPageNumber();

	/**
	 * this method will return the number of files per page
	 * 
	 * @return the number of files per page
	 */
	int getNumberOfFilesPerPage();

	/**
	 * this method will return the total number of files
	 * 
	 * @return the total number of files in the grid
	 */
	int getTotalFilesNumber();

	/**
	 * this method will let you go to the next page of a table or grid
	 */
	void goToNextPage();

	/**
	 * this method will let you go to the first page of a table or grid
	 */
	void goToFirstPage();

	/**
	 * this method will return the actual page number
	 * 
	 * @return actual page number in the grid
	 */
	int getActualPageNumber();
}
