package main.com.carService.container;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.google.gson.JsonObject;




/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="container.getAll",
		     query="SELECT c FROM container c where c.deleted = false"
		     )
	,
	@NamedQuery(name="container.getById",
	query = "from container d where d.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="container.getByContainerNumber",
	query = "from container d where d.container_number = :container_number and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "container")
public class container {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "date")
	private Calendar date;
	
	
	@Column(name = "container_number")
	private String container_number;
	
	
	@Column(name = "description_of_container")
	private String description_of_container;



	@Column(name = "mainUrl")
	private String mainUrl;
	
	
	@Column(name = "deleted")
	private boolean deleted;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public String getContainer_number() {
		return container_number;
	}


	public void setContainer_number(String container_number) {
		this.container_number = container_number;
	}


	public String getDescription_of_container() {
		return description_of_container;
	}


	public void setDescription_of_container(String description_of_container) {
		this.description_of_container = description_of_container;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public String getMainUrl() {
		return mainUrl;
	}






	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}



	
	


	public String getFormatedDate(Calendar c) {
		String dateTime="";
		if(c!=null) {
			String[] monthNames = {"Jan", "Feb", "Mar", "April", "May", "Jun", "Jul", "Aug", "Sep", "Octo", "Nov", "Dec"};
		    
		dateTime = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) +"/"+
				   String.valueOf(monthNames[c.get(Calendar.MONTH)]) +"/"+
				   String.valueOf(c.get(Calendar.YEAR));
		}
		return dateTime;
	}
	
	
	public JsonObject toJson() {
    	JsonObject obj=new JsonObject();
    	  obj.addProperty("id", String.valueOf(this.id));
    	  obj.addProperty("description_of_container", String.valueOf(this.description_of_container));
	      obj.addProperty("container_number", String.valueOf(this.container_number));
	      obj.addProperty("mainImage", String.valueOf(this.mainUrl));
	      obj.addProperty("formatedDate", String.valueOf(getFormatedDate(this.date)));
	      
	      return obj;
    	
    }
	
}
