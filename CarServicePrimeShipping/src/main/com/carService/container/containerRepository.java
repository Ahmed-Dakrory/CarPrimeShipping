/**
 * 
 */
package main.com.carService.container;

import java.util.List;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface containerRepository {

	public List<container> getAll();
	public List<container> getAllWithPagination(int start, int number,String searchValue,int col_order_number, String col_ordering);
	public long getAllCountSearch(int start, int number,String searchValue,int col_order_number, String col_ordering);
	
	public container addcontainer(container data);
	public container getById(int id);
	public container getByContainerNumber(String container_number);
	
	public boolean delete(container data)throws Exception;
}
