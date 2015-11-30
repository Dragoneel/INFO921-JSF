package dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.User;
 
@Stateless
public class UserDao {
    // Injected database connection:
    @PersistenceContext 
    private EntityManager em;
 
    // Stores a new client
    public void add(User client) {
        em.persist(client);
    }
    
    // Remove a client
    public void remove(User client) {
    	User inRemoveProcess = em.merge(client);
        em.remove(inRemoveProcess);
    }
    
    // Update a client
    public void update(User client) {
        em.merge(client);
    }
 
    // Retrieves all the users
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery(
            "SELECT c FROM User c", User.class);
        return query.getResultList();
    }
    
    // Return client according to username and id
    public List<User> verifyUser(Object username, Object password) {
        return em.createQuery("SELECT c FROM User c WHERE c.name = :name and c.password = :pass", User.class)
        		 .setParameter("name", username)
        		 .setParameter("pass", password)
        		 .getResultList();
    }
}