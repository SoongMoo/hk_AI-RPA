package hkAiRpaProject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.EmployeeCommand;
import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.mapper.EmployeeMapper;

@Service
public class EmployeesWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(EmployeeCommand employeeCommand) {	
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpAddr(employeeCommand.getEmpAddr());
		vo.setEmpAddr2(employeeCommand.getEmpAddr2());
		vo.setEmpBirth(employeeCommand.getEmpBirth());
		vo.setEmpEmail(employeeCommand.getEmpEmail());
		vo.setEmpGender(employeeCommand.getEmpGender());
		vo.setEmpId(employeeCommand.getEmpId());
		vo.setEmpName(employeeCommand.getEmpName());
		vo.setEmpNum(employeeCommand.getEmpNum());
		vo.setEmpPhone(employeeCommand.getEmpPhone());
		vo.setEmpPost(employeeCommand.getEmpPost());
		vo.setEmpPw( passwordEncoder.encode(employeeCommand.getEmpPw()));
		employeeMapper.employeeInsert(vo);
	}
}