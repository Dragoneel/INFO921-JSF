package managed_bean;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.richfaces.component.SortOrder;

import dao.UserDao;
import entity.User;


@ManagedBean
@SessionScoped
public class InscribeUserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private SortOrder idOrder = SortOrder.unsorted;
    private SortOrder nameOrder = SortOrder.unsorted;
    private SortOrder adressOrder = SortOrder.unsorted;
    private int currentIndex = -1;
    private User editedUser;

    private User       user;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UserDao    userDao;

    // Initialisation de l'entité user
    public InscribeUserBean() {
        user = new User();
    }

    public void inscrire() {
        userDao.add( user );
        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }
    
    public void remove() {
    	userDao.remove( editedUser );
    }
    
    public void update() {
    	System.out.println("Edited user: "+editedUser.getName());
    	userDao.update( editedUser );
    }

    public User getuser() {
        return user;
    }
    
    public List<User> getUsersList() {
    	return userDao.findAll();
    }
    
    
    
    // Custom sorting method    
//    public void sortByName(){
//    	System.out.println("Sort debug");
//    	System.out.println(nameOrder.toString());
//        if (nameOrder.equals(SortOrder.ascending)) {
//        	setNameOrder(SortOrder.descending);
//        	System.out.println("Desc: "+nameOrder.toString());
//        } else {
//        	setNameOrder(SortOrder.descending);
//        	System.out.println("Asc: "+nameOrder.toString());
//        }
//    }

	public SortOrder getNameOrder() {
		return nameOrder;
	}

	public void setNameOrder(SortOrder nameOrder) {
		this.nameOrder = nameOrder;
	}

	public SortOrder getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(SortOrder idOrder) {
		this.idOrder = idOrder;
	}

	public SortOrder getAdressOrder() {
		return adressOrder;
	}

	public void setAdressOrder(SortOrder adressOrder) {
		this.adressOrder = adressOrder;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public User getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(User editedUser) {
		this.editedUser = editedUser;
	}
	
    
    

}