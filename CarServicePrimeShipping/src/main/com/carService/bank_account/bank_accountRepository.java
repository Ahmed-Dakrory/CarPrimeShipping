/**
 * 
 */
package main.com.carService.bank_account;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface bank_accountRepository {

	public List<bank_account> getAll();
	public List<bank_account> getAllByUserId(int userId);
	public bank_account addbank_account(bank_account data);
	public bank_account getByBank_account(String account_number);
	public bank_account getById(int id);
	public boolean delete(bank_account data)throws Exception;
}
