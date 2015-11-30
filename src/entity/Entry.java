package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the entry database table.
 * 
 */
@Entity
@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e")
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Lob
	private String description;

	private int estimation;

	@Lob
	private String name;

	private int priority;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="entry")
	private List<Comment> comments;

	//bi-directional many-to-one association to Backlog
	@ManyToOne
	@JoinColumn(name="id_backlog")
	private Backlog backlog;

	public Entry() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEstimation() {
		return this.estimation;
	}

	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setEntry(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setEntry(null);

		return comment;
	}

	public Backlog getBacklog() {
		return this.backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

}