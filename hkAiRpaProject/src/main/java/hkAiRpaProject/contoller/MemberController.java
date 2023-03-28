package hkAiRpaProject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkAiRpaProject.command.MemberCommand;

@Controller
@RequestMapping("member")
public class MemberController {
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/member/memberList";
	}
	@RequestMapping("memberRegist")
	public String memberRegist(MemberCommand memberCommand) {
		return "thymeleaf/member/memberForm";
	}
	@RequestMapping(value = "memberWrite", method = RequestMethod.POST)
	public String write(@Validated MemberCommand memberCommand,
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		if (!memberCommand.isMemberPwEqualsMemberPwCon()){
			System.out.println("비밀번호 확인이 다릅니다.");
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호와 비밀번호 확인이 다릅니다.");
			return "thymeleaf/member/memberForm"; 
		}
		return "redirect:memberList";
	}
}
