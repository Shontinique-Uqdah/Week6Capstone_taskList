/**
 * 
 */
package co.grandcircus.taskList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Shontinique Uqdah
 *
 */
@Entity
@Table(name="task")
public class Task {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	//Will have to fix
	@ManyToOne
	User user;
	
	String description;
	String dueDate;
	boolean complete;
	
	public Task(User user, String description, String dueDate, boolean complete) {
		this.user = user;
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
	}
	
	public Task() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	
	
	
}
