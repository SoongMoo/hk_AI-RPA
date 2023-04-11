package hkAiRpaProject.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.service.login.LoginService;
import jakarta.servlet.http.HttpServletResponse;
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
	@RequestMapping(value="/login/item.login",method= RequestMethod.GET)
	public String item() {
		return "thymeleaf/login";
	}
	@RequestMapping(value="/login/item.login",method= RequestMethod.POST)
	public String item( LoginCommand loginCommand, BindingResult result , HttpSession session,
			HttpServletResponse response) {
		loginService.execute(loginCommand, session, result);
		if(result.hasErrors()) {
			return "thymeleaf/login";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "<script language='javascript'>"
				   + " opener.location.reload();"
				   + " window.self.close();"
				   + " </script>"; 
		out.print(str);
		out.close();		
		return null;
	}
}
