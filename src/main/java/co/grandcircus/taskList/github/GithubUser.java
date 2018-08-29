package co.grandcircus.taskList.github;

import co.grandcircus.taskList.User;

/**
 * Used internally by GithubService.
 */
class GithubUser {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public void copyToUser(User user) {
//		user.setGithubId(id);
//		user.setName(name);
//	}

}