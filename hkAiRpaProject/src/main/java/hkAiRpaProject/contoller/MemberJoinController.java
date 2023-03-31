package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.service.memberShip.MemberJoinService;
import hkAiRpaProject.service.memberShip.MemberMailService;

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
	@RequestMapping(value="memberJoinAction", method = RequestMethod.GET)
	public String memberJoinAction() {
		return "redirect:/";
	}
	@Autowired
	MemberJoinService memberJoinService;
	@RequestMapping(value="memberJoinAction", method = RequestMethod.POST)
	public String memberJoinAction(MemberCommand memberCommand, Model model) {
		memberJoinService.execute(memberCommand, model);
		return "thymeleaf/memberShip/welcome";
	}
	@Autowired
	MemberMailService memberMailService;
	@RequestMapping("memberOk")
	public @ResponseBody String memberOk(
		   @RequestParam(value="recieve" , defaultValue = "False")String recieve) {
		int i = memberMailService.execute(recieve);
		if(i == 1)
			return "인증되었습니다.";
		else if(i == 0)
			return "이미 인증되었습니다.";
		else 
			return "다시확인해주세요";
	}
}