package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MyPassUpdateService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(String userPw, HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO vo = new MemberVO();
		vo.setMemberId(authInfo.getUserId());
		vo.setMemberPw(passwordEncoder.encode(userPw));
		int i = memberShipMapper.myPassUpdate(vo);
		System.out.println(i + " 개 행이(가) 수정되었습니다.");
		if(i >0) authInfo.setUserPw(vo.getMemberPw());
	}
}
