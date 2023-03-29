package hkAiRpaProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.mapper.EmployeeMapper;

@Service
public class EmployeeAutoNumService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(Model model) {
		String empNum = employeeMapper.autoNum(); 
		model.addAttribute("empNum", empNum);
	}
}
