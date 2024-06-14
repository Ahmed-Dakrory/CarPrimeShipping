/**
 * 
 */
package main.com.carService.containerImage;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IcontainerimageAppService {

	public List<containerimage> getAll();
	public List<containerimage> getAllByContainerIdAndType(int idContainer,int type);
	public containerimage addcontainerimage(containerimage data);
	public containerimage getByUrl(String url);
	public containerimage getById(int id);
	public boolean delete(containerimage data)throws Exception;
}
