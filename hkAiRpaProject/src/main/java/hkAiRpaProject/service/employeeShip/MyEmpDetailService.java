package hkAiRpaProject.service.employeeShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.mapper.EmployeeShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MyEmpDetailService {
	@Autowired
	EmployeeShipMapper employeeShipMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		EmployeeVO vo = 	employeeShipMapper.myInfoSelect(authInfo.getUserId());
		model.addAttribute("employeeCommand", vo);
	}
}