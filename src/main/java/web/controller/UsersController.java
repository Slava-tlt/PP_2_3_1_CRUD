package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DAO.UserDAO;
import web.DAO.UserDAOImp;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private final UserDAOImp userDAO;

	public UsersController(UserDAOImp userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping()
	public String showAllUsers(Model model){

		model.addAttribute("allUsers", userDAO.getAllUsers());

		return "all-users";
	}
//
//	@GetMapping("/{id}")
//	public String show(@PathVariable("id") int id, Model model){
//
//		model.addAttribute("user", userDAO.show(id));
//
//		return "users/show";
//	}
	
}