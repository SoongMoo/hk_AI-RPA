package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.service.login.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@RequestMapping(value="/login/loginPro", method=RequestMethod.GET)
	public String login() {
		return "thymeleaf/login";
	}
	@Autowired
	LoginService loginService;
	@RequestMapping(value="/login/loginPro", method=RequestMethod.POST)
	public String login(LoginCommand loginCommand,HttpSession session) {
		loginService.execute(loginCommand, session);
		return "redirect:/";
	}
	@RequestMapping("login/loginOut")
	public String logOut(HttpSession session) {
		session.invalidate(); // 모든 seesion 삭제
		return "redirect:/";
	}
}
