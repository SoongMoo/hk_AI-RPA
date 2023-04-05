package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hkAiRpaProject.service.employeeShip.MyEmpDetailService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("myEmployee")
public class EmployeeMyPageController {
	@Autowired
	MyEmpDetailService myEmpDetailService;
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		myEmpDetailService.execute(session,model );
		return "thymeleaf/employeeShip/empInfo";
	}
}
