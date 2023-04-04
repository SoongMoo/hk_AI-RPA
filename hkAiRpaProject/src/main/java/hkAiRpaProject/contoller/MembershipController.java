package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.service.memberShip.MemberJoinService;

@Controller
@RequestMapping("register")
public class MembershipController {
	@RequestMapping("agree")
	public String agree() {
		return "thymeleaf/memberShip/agree";
	}
	@RequestMapping("regist")
	public String regist(
			/*
			 boolean agree = request.getParameter("agree");
			 if (agree != null){
			 	RequestDispatcher dispatcher =
			 		request.getRequestDispatcher("member/agree.jsp"); 
			 }else{
			 	RequestDispatcher dispatcher =
			 		request.getRequestDispatcher("member/memberJoinForm.jsp"); 
			 }
			 dispatcher.forward(request, response);
			 */
			@RequestParam(value = "agree", defaultValue = "false" ) boolean agree
			, Model model) {
		if(agree == false) {
			return "thymeleaf/memberShip/agree";
		}
		
		model.addAttribute("memberCommand", new MemberCommand());
		
		return "thymeleaf/memberShip/memberJoinForm";
	}
	@Autowired
	MemberJoinService memberJoinService;
	@RequestMapping("welcome")
	public String register(
			// String memberName = request.getParameter("memberName");
			//@RequestParam(value="memberName") String memberName 
			@Validated MemberCommand memberCommand,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/memberShip/memberJoinForm";
		}
		if (!memberCommand.isMemberPwEqualsMemberPwCon()) {
			
			return "thymeleaf/memberShip/memberJoinForm";
		}
		memberJoinService.execute(memberCommand, model);
		return "thymeleaf/memberShip/welcome";
	}
}
