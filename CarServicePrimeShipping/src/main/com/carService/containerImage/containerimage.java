package main.com.carService.containerImage;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.carService.container.container;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="containerimage.getAll",
		     query="SELECT c FROM containerimage c where c.deleted = false"
		     )
	,
	@NamedQuery(name="containerimage.getById",
	query = "from containerimage d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="containerimage.getAllByContainerIdAndType",
	query = "from containerimage d where d.containerId.id = :id and d.type = :type and d.deleted = false"
			)
	,
	
	@NamedQuery(name="containerimage.getByUrl",
	query = "from containerimage d where d.url = :url and d.deleted = false"
			)
	
	
})

@Entity
@Table(name = "containerimage")
public class containerimage {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "url")
	private String url;
	
	
	@ManyToOne
	@JoinColumn(name = "containerId")
	private container containerId;



	@Column(name = "deleted")
	private boolean deleted;
	
	
	
	
	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public static int TYPE_PIC=0;
	public static int TYPE_DOC=1;
	public static int TYPE_PDFS=2;
	public static int TYPE_Loading=3;
	public static int TYPE_3D=4;
	
	@Column(name = "type")
	private Integer type;

	
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public container getContainerId() {
		return containerId;
	}


	public void setContainerId(container containerId) {
		this.containerId = containerId;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}
	
	
	

	
	
}
