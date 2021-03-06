/**
 * 
 */
package main.com.carService.bank_account;

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
public class bank_accountRepositoryImpl implements bank_accountRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public bank_account addbank_account(bank_account data) {
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
	public List<bank_account> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("bank_account.getAll");

				 @SuppressWarnings("unchecked")
				List<bank_account> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(bank_account data)throws Exception {
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
	public bank_account getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("bank_account.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<bank_account> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}



	

	

	@Override
	public List<bank_account> getAllByUserId(int userId) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("bank_account.getAllByUserId")
				 .setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		List<bank_account> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public bank_account getByBank_account(String account_number) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("bank_account.getByBank_account").setString("bank_account_number",account_number);

		 @SuppressWarnings("unchecked")
		List<bank_account> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
}



	
	


}
