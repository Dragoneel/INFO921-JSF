package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the backlog database table.
 * 
 */
@Entity
@NamedQuery(name="Backlog.findAll", query="SELECT b FROM Backlog b")
public class Backlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int name;

	//bi-directional many-to-one association to Agence
	@OneToMany(mappedBy="backlog")
	private List<Agence> agences;

	//bi-directional many-to-one association to Entry
	@OneToMany(mappedBy="backlog")
	private List<Entry> entries;

	public Backlog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return this.name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public List<Agence> getAgences() {
		return this.agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	public Agence addAgence(Agence agence) {
		getAgences().add(agence);
		agence.setBacklog(this);

		return agence;
	}

	public Agence removeAgence(Agence agence) {
		getAgences().remove(agence);
		agence.setBacklog(null);

		return agence;
	}

	public List<Entry> getEntries() {
		return this.entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public Entry addEntry(Entry entry) {
		getEntries().add(entry);
		entry.setBacklog(this);

		return entry;
	}

	public Entry removeEntry(Entry entry) {
		getEntries().remove(entry);
		entry.setBacklog(null);

		return entry;
	}

}