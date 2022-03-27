package main.com.carService.bank_account;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="bank_account.getAll",
		     query="SELECT c FROM bank_account c where c.deleted = false"
		     )
	,
	@NamedQuery(name="bank_account.getById",
	query = "from bank_account d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="bank_account.getAllByUserId",
	query = "from bank_account d where d.userId.id = :id and d.deleted = false"
			)
	,
	
	@NamedQuery(name="bank_account.getByBank_account",
	query = "from bank_account d where d.bank_account_number = :bank_account_number and d.deleted = false"
			)
	
	
})

@Entity
@Table(name = "bank_account")
public class bank_account {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "bank_name")
	private String bank_name;
	

	@Column(name = "bank_address")
	private String bank_address;
	

	@Column(name = "bank_tel")
	private String bank_tel;
	

	@Column(name = "bank_account_number")
	private String bank_account_number;
	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private main.com.carService.loginNeeds.user userId;



	@Column(name = "deleted")
	private boolean deleted;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getBank_name() {
		return bank_name;
	}



	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}



	public String getBank_address() {
		return bank_address;
	}



	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}



	public String getBank_tel() {
		return bank_tel;
	}



	public void setBank_tel(String bank_tel) {
		this.bank_tel = bank_tel;
	}



	public String getBank_account_number() {
		return bank_account_number;
	}



	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}



	public main.com.carService.loginNeeds.user getUserId() {
		return userId;
	}



	public void setUserId(main.com.carService.loginNeeds.user userId) {
		this.userId = userId;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
	
	
	
}
