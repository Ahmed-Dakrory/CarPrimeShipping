/**
 * 
 */
package main.com.carService.container;


import java.util.ArrayList;
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
public class containerRepositoryImpl implements containerRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public container addcontainer(container data) {
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
	public List<container> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("container.getAll");

				 @SuppressWarnings("unchecked")
				List<container> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	

	@Override
	public long getAllCountSearch(int start, int number,String searchValue,int col_order_number, String col_ordering) {
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			
			Query query =null;
			
			
			String searchQuery = "";
			searchQuery = " ( box.container_number like '%"+searchValue+"%' or "
					+ " box.id like '%"+searchValue+"%' ) ";
			
			
			String ordering_Quer="";
			if(col_order_number==1) {
				//Year
				ordering_Quer = "  order by box.container_number "+col_ordering;
			}else if(col_order_number==2) {
				// Cargo Received
				ordering_Quer = "  order by box.date "+col_ordering;
				
			}else {
				ordering_Quer = "  order by box.date desc";
				
			}
			if(searchValue.equalsIgnoreCase("")) {
				 query = session.createQuery("select count(*) FROM container box  where  box.deleted = false"+ordering_Quer);
					
			}else {
				 query = session.createQuery("select count(*) FROM container box  where ("+searchQuery+")  and box.deleted = false"+ordering_Quer);
					
			}

			System.out.println("-----------------------------------");
			System.out.println(query.getQueryString());
			

			
			Number results=(Number) (query).uniqueResult();

			tx1.commit();
			session.close();
			return (long) results;
		} catch (Exception ex) {
			return 0;
		}
		

	}

	
	
	
	@Override
	public List<container> getAllWithPagination(int start, int number,String searchValue,int col_order_number, String col_ordering) {
		
			 
			 try {
					session = sessionFactory.openSession();
					Transaction tx1 = session.beginTransaction();
					
					
					Query query =null;
					
					String searchQuery = "";
					searchQuery = " ( box.container_number like '%"+searchValue+"%' or "
							+ " box.id like '%"+searchValue+"%' ) ";
					
					
					String ordering_Quer="";
					if(col_order_number==1) {
						//Year
						ordering_Quer = "  order by box.container_number "+col_ordering;
					}else if(col_order_number==2) {
						// Cargo Received
						ordering_Quer = "  order by box.date "+col_ordering;
						
					}else {
						ordering_Quer = "  order by box.date desc";
						
					}
					if(searchValue.equalsIgnoreCase("")) {
						 query = session.createQuery("select box FROM container box  where  box.deleted = false"+ordering_Quer);
							
					}else {
						 query = session.createQuery("select box FROM container box  where ("+searchQuery+")  and box.deleted = false"+ordering_Quer);
						
					}
					System.out.println("-----------------------------------");
					System.out.println(query.getQueryString());
					
					 query.setFirstResult(start);
					 query.setMaxResults(number);
					 
					 @SuppressWarnings("unchecked")
					List<container> results=query.list();

					tx1.commit();
					session.close();
					return results;
				} catch (Exception ex) {
					return new ArrayList<container>();
				}
		
	}


	
	@Override
	public boolean delete(container data)throws Exception {
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
	public container getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("container.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<container> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	
	
	@Override
	public container getByContainerNumber(String id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("container.getByContainerNumber").setString("container_number",id);

		 @SuppressWarnings("unchecked")
		List<container> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	


}
