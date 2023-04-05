package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkAiRpaProject.contoller.MembershipController;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MyPassConService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public Boolean execute(String userPw, HttpSession session) { // 피호출메서드
		AuthInfoVO vo = (AuthInfoVO)session.getAttribute("authInfo");
		String dbPw = memberShipMapper.memberPwSelect(vo.getUserId());
		// userPw : 1234!qwer   // 본문
		// dbPw : $2a$10$owxu9O0OzTkDPMcHrrl6xeQInvj9mbhvi/pQToo5asEb85VO/0RsK // 암호문
		// passwordEncoder.matches(본문, 암호문)
		if(passwordEncoder.matches(userPw, dbPw)) {
			return true;
		}
		return false;
	}
}
