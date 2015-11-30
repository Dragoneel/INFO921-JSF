package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agence database table.
 * 
 */
@Entity
@NamedQuery(name="Agence.findAll", query="SELECT a FROM Agence a")
public class Agence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String name;

	//bi-directional many-to-one association to Backlog
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id_agence", insertable=false, updatable=false)
	private Backlog backlog;

	public Agence() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Backlog getBacklog() {
		return this.backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

}