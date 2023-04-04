package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hkAiRpaProject.service.memberShip.MyDetailService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("mypage")
public class MemberMyPageController {
	@Autowired
	MyDetailService myDetailService;
	@RequestMapping("myDetail")
	public String myDetail(HttpSession session, Model model) {	
		myDetailService.execute(session,model);
		return "thymeleaf/memberShip/myInfo";
	}
}
