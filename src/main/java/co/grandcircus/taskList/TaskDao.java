package co.grandcircus.taskList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class TaskDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Task> findAll() {
				return em.createQuery("FROM Task", Task.class).getResultList();
		
	}
	
	public Task findByID(Long id) {
		return em.find(Task.class, id);
	}
	
	public List<Task> findByUser(User user) {
		return em.createQuery("FROM Task WHERE user = :user", Task.class)
				.setParameter("user", user)
				.getResultList();
	}
	
	public void create(Task task) {
		em.persist(task);
	}
	
	public void delete(Long id) {
		Task task = em.getReference(Task.class, id);
		em.remove(task);
	}
	
	public void update(Task task) {
		em.merge(task);
		
	}

}
