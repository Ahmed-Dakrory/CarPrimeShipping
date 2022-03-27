/**
 * 
 */
package main.com.carService.bank_account;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("bank_accountFacadeImpl")
public class bank_accountAppServiceImpl implements Ibank_accountAppService{

	@Autowired
	bank_accountRepository bank_accountDataRepository;
	
	
	@Override
	public List<bank_account> getAll() {
		try{
			List<bank_account> course=bank_accountDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public bank_account addbank_account(bank_account data) {
		try{
				bank_account data2=bank_accountDataRepository.addbank_account(data);
				return data2;
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(bank_account data)throws Exception {
		// TODO Auto-generated method stub
		try{
			bank_accountDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public bank_account getById(int id) {
		// TODO Auto-generated method stub
		try{
			bank_account so=bank_accountDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	

	



	


	@Override
	public List<bank_account> getAllByUserId(int userId) {
		try{
			List<bank_account> course=bank_accountDataRepository.getAllByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public bank_account getByBank_account(String account_number) {
		// TODO Auto-generated method stub
				try{
					bank_account so=bank_accountDataRepository.getByBank_account(account_number);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}




	
	
	
}
		
		

	
		
	


