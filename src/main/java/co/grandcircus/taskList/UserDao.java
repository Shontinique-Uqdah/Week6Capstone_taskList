package co.grandcircus.taskList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<User> findAll() {
				return em.createQuery("FROM User", User.class).getResultList();
		
	}
	
	public User findByID(Long id) {
		return em.find(User.class, id);
	}
	
	
	public void create(User user) {
		em.persist(user);
	}
	
	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}
	
	public void update(User user) {
		em.merge(user);
		
	}

}
