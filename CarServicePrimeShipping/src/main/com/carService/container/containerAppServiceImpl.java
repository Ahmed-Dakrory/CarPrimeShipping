/**
 * 
 */
package main.com.carService.container;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Dakrory
 *
 */
@Service("containerFacadeImpl")
public class containerAppServiceImpl implements IcontainerAppService{

	@Autowired
	containerRepository containerDataRepository;
	
	
	@Override
	public List<container> getAll() {
		try{
			List<container> course=containerDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<container> getAllWithPagination(int start, int number, String searchValue,int col_order_number, String col_ordering) {
		try{
			List<container> course=containerDataRepository.getAllWithPagination( start,  number,  searchValue,col_order_number,  col_ordering);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
	@Override
	public long getAllCountSearch(int start, int number, String searchValue,int col_order_number, String col_ordering) {
		try{
			long course=containerDataRepository.getAllCountSearch( start,  number,  searchValue, col_order_number,  col_ordering);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return 0;
			}
	}

	@Override
	public container addcontainer(container data) {
		try{
			container data2=containerDataRepository.addcontainer(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(container data)throws Exception {
		// TODO Auto-generated method stub
		try{
			containerDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public container getById(int id) {
		// TODO Auto-generated method stub
		try{
			container so=containerDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
	@Override
	public container getByContainerNumber(String id) {
		// TODO Auto-generated method stub
		try{
			container so=containerDataRepository.getByContainerNumber(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	

	
}
		
		

	
		
	


