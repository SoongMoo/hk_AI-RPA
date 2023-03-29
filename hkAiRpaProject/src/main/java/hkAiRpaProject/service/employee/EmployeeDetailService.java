package hkAiRpaProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.mapper.EmployeeMapper;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper employeeMapper ;
	public void execute(String empNum, Model model) {
		EmployeeVO vo = employeeMapper.employeeOneSelect(empNum);
		model.addAttribute("employeeVO", vo);
	}
}
