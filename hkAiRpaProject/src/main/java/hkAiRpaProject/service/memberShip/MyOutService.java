package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;
@Service
public class MyOutService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(HttpSession session) {
		AuthInfoVO vo = (AuthInfoVO)session.getAttribute("authInfo");
		int i = memberShipMapper.myDelete(vo.getUserId());	
		System.out.println(i + "행이(가) 삭제되었습니다.");
	}
}
