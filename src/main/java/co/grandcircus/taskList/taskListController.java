package co.grandcircus.taskList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.taskList.github.GithubService;




@Controller
public class taskListController {
	
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	GithubService githubService;
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationForm() {
		return new ModelAndView("register");
	}
	
	
	
	
	@PostMapping("/register")
	public ModelAndView registerUser(@RequestParam("email") String email, @RequestParam("password1") String password1,
			@RequestParam("password2") String password2) {
		
		//Check database for existence of this user! Add this in later
//		List<User> users = userDao.findAll();
		
		
		String passwordTest;
		
		if (password1.matches(password2)) {
			
			passwordTest = "";
			
			User user = new User();
			user.setEmail(email);
			user.setPassword(password1);
			
			userDao.create(user);
			return new ModelAndView("redirect:/login");
			
		}
		
		else {
			passwordTest = "Passwords entered do not match. Please try again.";
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("email", email);
			mav.addObject("passwordTest", passwordTest);
			return mav;
		}
			
		
	}
	
	@RequestMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLoginForm(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, RedirectAttributes redir) {
		// Find the matching user.
		User user = userDao.findByEmail(email);
		if (user == null || !password.equals(user.getPassword())) {
			// If the user or password don't match, display an error message.
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Incorrect username or password.");
			return mav;
		}
		
		// On successful login, add the user to the session.
		session.setAttribute("user", user);
		
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Logged in.");
		return new ModelAndView("redirect:/showTasks");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		// invalidate clears the current user session and starts a new one.
		session.invalidate();
		
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Logged out.");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/showTasks")
	public ModelAndView showHome(@SessionAttribute("user") User user) {
		List<Task> tasks = taskDao.findByUser(user);
		ModelAndView mav = new ModelAndView("taskList");
		mav.addObject("tasks", tasks);
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView showAddForm() {
		ModelAndView mav = new ModelAndView("add");
		return mav;
	}
	
	@PostMapping("/add")
	//Will need to change user parameter
	public ModelAndView addTask(@SessionAttribute("user") User user, @RequestParam("description") String description,
			@RequestParam("dueDate") String dueDate, @RequestParam("complete") boolean complete) {
		
		Task task = new Task();
		
		task.setComplete(complete);
		task.setDescription(description);
		task.setDueDate(dueDate);
		
		task.setUser(user);
		
		taskDao.create(task);
		return new ModelAndView("redirect:/showTasks");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView showAddForm(@PathVariable("id") Long id) {
		taskDao.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/showTasks");
		return mav;
	}
	
	@RequestMapping("/complete/{id}")
	public ModelAndView completeTask(@PathVariable("id") Long id) {
		Task task = taskDao.findByID(id);
		task.setComplete(true);
		taskDao.update(task);
		ModelAndView mav = new ModelAndView("redirect:/showTasks");
		return mav;
	}
	
	// This is the second step in OAuth. After the user approves the login on the github site, it redirects back
		// to our site with a temporary code.
//		@RequestMapping("/oauth-github-callback")
//		public ModelAndView handleGithubCallback(@RequestParam("code") String code, HttpSession session) {
//			// First we must exchange that code for an access token.
//			String accessToken = githubService.getGithubAccessToken(code);
//			// Then we can use that access token to get information about the user and other things.
//			User githubUser = githubService.getUserFromGithubApi(accessToken);
//
//			// Check to see if the user is already in our database.
//			User user = userDao.findByGithubId(githubUser.getGithubId());
//			if (user == null) {
//				// if not, add them.
//				user = githubUser;
//				userDao.save(user);
//			}
//
//			// Set the user on the session, just like the other type of login.
//			session.setAttribute("user", user);
//			// In some apps, you need the access token later, so throw that on the session, too.
//			session.setAttribute("githubAccessToken", accessToken);
//
//			return new ModelAndView("redirect:/");
//		}

}
