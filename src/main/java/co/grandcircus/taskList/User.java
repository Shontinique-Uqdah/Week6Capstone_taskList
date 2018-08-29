package co.grandcircus.taskList;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	String email;
	String password;

//	private Long githubId;

//	private String name;
	
	@OneToMany(mappedBy="user")
	private Set<Task> tasks;	
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public void setGithubId(Long id2) {
//		this.githubId = id2;
//		
//	}
//
//	public void setName(String name) {
//		this.name = name;
//		
//	}
//
//	public Long getGithubId() {
//		return githubId;
//	}
//
//	public String getName() {
//		return name;
//	}
	
	
	

}
