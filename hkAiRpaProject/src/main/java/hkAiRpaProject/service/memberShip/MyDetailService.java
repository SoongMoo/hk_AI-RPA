package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MyDetailService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(HttpSession session,Model model) {
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("authInfo");
		MemberVO vo = memberShipMapper.myInfoSelect(authInfo.getUserId());
		model.addAttribute("memberCommand", vo);
	}
}
