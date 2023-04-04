package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;
@Service
public class MyPassConfirmService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public boolean execute(String userPw,HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO vo = memberShipMapper.myInfoSelect(authInfo.getUserId());
		if(passwordEncoder.matches(userPw, vo.getMemberPw())) {
			return true;
		}
		return false;
	}
}
