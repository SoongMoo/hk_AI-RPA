package hkAiRpaProject.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.mapper.EmployeeMapper;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(Model model) {
		List<EmployeeVO> list = employeeMapper.employeeAllSelect();
		model.addAttribute("list", list);
	}
}
