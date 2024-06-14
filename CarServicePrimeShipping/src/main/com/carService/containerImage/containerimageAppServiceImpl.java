/**
 * 
 */
package main.com.carService.containerImage;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("containerimageFacadeImpl")
public class containerimageAppServiceImpl implements IcontainerimageAppService{

	@Autowired
	containerimageRepository containerimageDataRepository;
	
	
	@Override
	public List<containerimage> getAll() {
		try{
			List<containerimage> course=containerimageDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public containerimage addcontainerimage(containerimage data) {
		try{
			containerimage existData = containerimageDataRepository.getByUrl(data.getUrl());
			if(existData==null) {
				containerimage data2=containerimageDataRepository.addcontainerimage(data);
				return data2;
			}else {
				existData.setDeleted(data.isDeleted());
				containerimageDataRepository.addcontainerimage(existData);
				return existData;
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(containerimage data)throws Exception {
		// TODO Auto-generated method stub
		try{
			containerimageDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public containerimage getById(int id) {
		// TODO Auto-generated method stub
		try{
			containerimage so=containerimageDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	

	@Override
	public List<containerimage> getAllByContainerIdAndType(int idContainer, int type) {
		try{
			List<containerimage> course=containerimageDataRepository.getAllByContainerIdAndType(idContainer, type);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public containerimage getByUrl(String url) {
		try{
			containerimage so=containerimageDataRepository.getByUrl(url);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	
	
	
}
		
		

	
		
	


