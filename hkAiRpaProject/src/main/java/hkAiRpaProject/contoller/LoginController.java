package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.service.login.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping("/login/loginPro")
	public String login( LoginCommand loginCommand, BindingResult result , HttpSession session) {
		loginService.execute(loginCommand, session, result);
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		return "redirect:/";
	}
	@RequestMapping("/login/loginOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}