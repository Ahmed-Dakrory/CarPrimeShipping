/**
 * 
 */
package main.com.carService.containerImage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class containerimageRepositoryImpl implements containerimageRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public containerimage addcontainerimage(containerimage data) {
		try{
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.saveOrUpdate(data);
			tx1.commit();
			session.close(); 
			return data; 
			}
			catch(Exception ex)
			{
				System.out.println(">>>>>>>>>>");
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<containerimage> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("containerimage.getAll");

				 @SuppressWarnings("unchecked")
				List<containerimage> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(containerimage data)throws Exception {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(data);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public containerimage getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("containerimage.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<containerimage> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}



	@Override
	public List<containerimage> getAllByContainerIdAndType(int idContainer, int type) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("containerimage.getAllByContainerIdAndType")
				 .setInteger("id",idContainer)
				 .setInteger("type", type);

		 @SuppressWarnings("unchecked")
		List<containerimage> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public containerimage getByUrl(String url) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("containerimage.getByUrl").setString("url",url);

				 @SuppressWarnings("unchecked")
				List<containerimage> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}



	
	


}
