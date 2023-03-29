package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.command.EmployeeCommand;
import hkAiRpaProject.service.employee.EmployeeAutoNumService;
import hkAiRpaProject.service.employee.EmployeeDetailService;
import hkAiRpaProject.service.employee.EmployeeListService;
import hkAiRpaProject.service.employee.EmployeesWriteService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeListService employeeListService ;
	@RequestMapping("empList")
	public String empList(Model model) {
		employeeListService.execute(model);
		return "thymeleaf/employee/empList";
	}
	@Autowired
	EmployeeAutoNumService employeeAutoNumService;
	@RequestMapping("empJoin")
	public String empJioin(Model model) {
		employeeAutoNumService.execute(model);
		return "thymeleaf/employee/empForm";
	}
	@Autowired
	EmployeesWriteService employeesWriteService; 
	@RequestMapping("empWrite")
	public String empWrite(EmployeeCommand employeeCommand) {
		employeesWriteService.execute(employeeCommand);
		return "redirect:empList";
	}
	@Autowired
	EmployeeDetailService employeeDetailService;
	@RequestMapping("employeeDetail")
	public String memberDetail(
			@RequestParam(value="empNum")String empNum,
			Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/empDetail";
	}
}
