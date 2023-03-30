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
import hkAiRpaProject.service.member.MemberDeleteService;
import hkAiRpaProject.service.member.MemberDetailService;
import hkAiRpaProject.service.member.MemberInsertService;
import hkAiRpaProject.service.member.MemberListService;
import hkAiRpaProject.service.member.MemberUpdateService;
import hkAiRpaProject.service.member.MembersDeleteService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@RequestMapping("memberList")
	public String memberList(
			@RequestParam(value="memberWord" , required = false) String memberWord
			,Model model) {
		memberListService.execute(memberWord, model);
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
		/// memberNum에 해당되는 디비로 부터 데이터를 가져오기
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberDetail";
	}
	
	@RequestMapping(value="memberModify" , method = RequestMethod.GET)
	public String memberModify(
			@RequestParam(value="memberNum")String memberNum,
			Model model) {
		// memberDetail 하고 내용이 같으므로 memberDetailService를 같이 사용
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberUpdate";
	}
	@Autowired
	MemberUpdateService memberUpdateService;
	@RequestMapping(value="memberModify" , method = RequestMethod.POST)
	public String memberModify(
			@Validated MemberCommand memberCommand,
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberUpdate";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail?memberNum="+memberCommand.getMemberNum();
		// memberDetail?memberNum=mem100001
	}
	@Autowired
	MemberDeleteService memberDeleteService;
	@RequestMapping("memberDelete")
	public String memberDelete(
			@RequestParam(value="memberNum") String memberNum ) {
		memberDeleteService.execute(memberNum);
		return "redirect:memberList";
	}
	@Autowired
	MembersDeleteService membersDeleteService;
	@RequestMapping("membersDelete")
	public String membersDelete(
			@RequestParam(value="memDels") String memDels []) {
		membersDeleteService.execute(memDels);
		return "redirect:memberList";
	}
	
	
	
	
	
}
