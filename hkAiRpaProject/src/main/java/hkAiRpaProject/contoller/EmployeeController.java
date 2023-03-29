package hkAiRpaProject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkAiRpaProject.command.EmployeeCommand;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@RequestMapping("empList")
	public String empList() {
		return "thymeleaf/employee/empList";
	}
	@RequestMapping("empJoin")
	public String empJioin() {
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping("empWrite")
	public String empWrite(EmployeeCommand employeeCommand) {
		return "redirect:empList";
	}
}
