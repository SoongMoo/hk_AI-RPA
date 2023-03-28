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
	public String empJoin(EmployeeCommand employeeCommand) {
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping(value = "empWrite", method = RequestMethod.POST)
	public String empWrite(@Validated EmployeeCommand employeeCommand,
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/employee/empForm";
		}
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("empPwCon", "employeeCommand.empPwCon", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/employee/empList";
		}
		return "redirect:empList";
	}
}
