package info.inaltostudy.inaltoschool.web;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.inaltostudy.inaltoschool.domain.Login;
import info.inaltostudy.inaltoschool.domain.User;
import info.inaltostudy.inaltoschool.service.LoginService;
import info.inaltostudy.inaltoschool.service.RoleService;
import info.inaltostudy.inaltoschool.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private RoleService roleService;
	@Autowired  
    private MessageSource messageSource;
	
	private User user;
	private Login login;
	private String message = "";

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String listUsers(Map<String, Object> map) {

		map.put("userList", userService.listUser());
		map.put("loginService", loginService);
		map.put("roleService", roleService);
		map.put("loginName", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("message",message);

		return "home";
	}
	
	@RequestMapping("/new")
	public String newUser(Map<String, Object> map) {
		LoginUser loginuser = new LoginUser();
		user = new User();
		login = new Login();
		loginuser.setLoginUser(user,login,null);
		map.put("loginuser", loginuser);
		map.put("roleList", roleService.listRole());
		map.put("message",message);

		return "user";
	}
	
	@RequestMapping("/edit/{userId}")
	public String editUser(Map<String, Object> map, @PathVariable("userId") Integer userId) {
		LoginUser loginuser = new LoginUser();
		user = userService.getUser(userId);
		login =loginService.getLogin(user.getLogin_id());
		loginuser.setLoginUser(user,login,roleService.getRole(login.getRole_id()).getRole_name());
		map.put("loginuser", loginuser);
		map.put("roleList", roleService.listRole());
		map.put("message",message);

		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("loginuser") LoginUser loginuser, BindingResult result,
			HttpServletRequest request) {
		if (valid(loginuser)) {
			loginuser.getLoginUser(user,login,roleService.getByName(loginuser.getRole_name()).getRole_id());
			System.out.println(login.getLogin_name());
			loginService.addLogin(login);
			login = loginService.getByName(login.getLogin_name());
			user.setLogin_id(login.getLogin_id());
			userService.addUser(user);
			message = user.getUser_firstname()+" "+user.getUser_lastname()+messageSource.getMessage("message.added",null,Locale.getDefault());
		}
		else {
			message = messageSource.getMessage("message.notvalid",null,Locale.getDefault());
			return "redirect:"+request.getHeader("Referer");
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/edit/add", method = RequestMethod.POST)
	public String setUser(@ModelAttribute("loginuser") LoginUser loginuser, BindingResult result,
			HttpServletRequest request) {
		if (valid(loginuser)) {
			loginuser.getLoginUser(user,login,roleService.getByName(loginuser.getRole_name()).getRole_id());
			loginService.setLogin(login);
			userService.setUser(user);
			message = user.getUser_firstname()+" "+user.getUser_lastname()+messageSource.getMessage("message.updated",null,Locale.getDefault());
		}
		else {
			message = messageSource.getMessage("message.notvalid",null,Locale.getDefault());
			return "redirect:"+request.getHeader("Referer");
		}
		return "redirect:/index";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		message = userService.getUser(userId).getUser_firstname()+" "+userService.getUser(userId).getUser_lastname()+messageSource.getMessage("message.deleted",null,Locale.getDefault());
		loginService.removeLogin(userService.getUser(userId).getLogin_id());
//		userService.removeUser(userId);
		return "redirect:/index";
	}
	
	private boolean valid(LoginUser loginuser) {
		@SuppressWarnings("unused")
		Date date;
		if ((loginuser.getRole_name().equals("NONE")) || 
				(loginuser.getLogin_name().equals("")) ||
				(loginuser.getUser_firstname().equals("")))
			return false;
		System.out.println(user);
		if (user.getUser_id() != null)
			if (((user.getUser_id() > 0) && 
				(!loginuser.getLogin_password().equals(loginuser.getLogin_password_repeat()))) ||
				((user.getUser_id() == 0) && ((loginuser.getLogin_password().equals("")) ||
				(loginuser.getLogin_password_repeat().equals("")) ||
				(!loginuser.getLogin_password().equals(loginuser.getLogin_password_repeat())) ||
				(loginuser.getLogin_answer().equals("")))))
			return false;
		try {
			if (!loginuser.getUser_birthday().equals(""))
				date = new Date(new SimpleDateFormat("dd.MM.yyyy").parse(loginuser.getUser_birthday()).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
