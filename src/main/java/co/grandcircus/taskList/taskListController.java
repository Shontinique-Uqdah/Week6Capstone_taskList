package co.grandcircus.taskList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class taskListController {
	
	@Autowired
	private TaskDao taskDao;

	@RequestMapping("/")
	public ModelAndView showHome() {
		List<Task> tasks;
		try {
			tasks = taskDao.findAll();
		}
		catch(Exception ex) {
			tasks = null;
		}
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("tasks", tasks);
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView showAddForm() {
		ModelAndView mav = new ModelAndView("add");
		return mav;
	}
	
	@RequestMapping("/addTask")
	//Will need to change user parameter
	public ModelAndView addTask(/*@RequestParam("user") User user,*/@RequestParam("description") String description,
			@RequestParam("dueDate") String dueDate) {
		
		Task task = new Task();
		
		task.setComplete(false);
		task.setDescription(description);
		task.setDueDate(dueDate);
		
		//Will need to change
//		task.setUser(null);
		
		taskDao.create(task);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView showAddForm(@PathVariable("id") Long id) {
		taskDao.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}
