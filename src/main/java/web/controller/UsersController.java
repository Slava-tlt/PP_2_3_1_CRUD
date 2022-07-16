package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DAO.UserDAO;

@Controller
@RequestMapping("/users")
public class UsersController {

	private final UserDAO userDAO;

	public UsersController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping()
	public String allUsers(Model model){

		model.addAttribute("users", userDAO.allUsers());

		return "users";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model){

		model.addAttribute("user", userDAO.show(id));

		return "users/show";
	}
	
}