package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.service.member.MemberAutoNumService;
import hkAiRpaProject.service.member.MemberDetailService;
import hkAiRpaProject.service.member.MemberInsertService;
import hkAiRpaProject.service.member.MemberListService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@RequestMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	@Autowired
	MemberAutoNumService memberAutoNumService;
	@RequestMapping("memberRegist")
	public String memberRegist(MemberCommand memberCommand,Model model) {
		memberAutoNumService.execute(memberCommand, model);
		return "thymeleaf/member/memberForm";
	}
	@Autowired
	MemberInsertService memberInsertService;
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
		/// service에게 html로 부터 받아온 값을 가진 command를 전달한다.
		memberInsertService.execute(memberCommand);		
		
		return "redirect:memberList";
	}
	@Autowired
	MemberDetailService memberDetailService;
	@RequestMapping("memberDetail")
	public String memberDetail(
			// String memberNum = request.getParameter("memberNum")
			@RequestParam(value="memberNum")String memberNum,
			Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberDetail";
	}
	
	
	
	
	
	
	
	
	
}