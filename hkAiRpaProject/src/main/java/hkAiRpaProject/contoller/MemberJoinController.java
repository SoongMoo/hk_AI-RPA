package hkAiRpaProject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	@RequestMapping("agree")
	public String agree() {
		return "thymeleaf/memberShip/agree";
	}
	@RequestMapping("regist")
	public String regist(@RequestParam(value="agree", defaultValue = "false") boolean agree) {
		if(agree == false) {
			return "thymeleaf/memberShip/agree";
		}
		return "thymeleaf/memberShip/memberJoinForm";
	}
}
