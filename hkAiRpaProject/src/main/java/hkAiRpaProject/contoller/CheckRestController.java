package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hkAiRpaProject.service.EmailCheckService;
import hkAiRpaProject.service.IdcheckService;
import hkAiRpaProject.service.memberShip.MemberEmailCheckService;

@RestController
public class CheckRestController {
	@Autowired
	EmailCheckService emailCheckService;
	@RequestMapping("/checkRest/userEmailCheck")
	public String userEmailCheck(
			@RequestParam(value="userEmail") String userEmail) {
		String checkEmail = emailCheckService.execute(userEmail);
		if(checkEmail == null) return "사용가능한 이메일입니다.";
		else return "사용중인 이메일입니다.";
	}
	@Autowired
	IdcheckService idcheckService;
	@RequestMapping("/checkRest/memberIdCheck")
	public String memberIdCheck(
			@RequestParam(value="memberId") String memberId
			) {
		String checkId= idcheckService.execute(memberId);
		if (checkId == null) return "사용가능한 아이디입니다.";
		else return "사용중인 아이디입니다.";
	}
	@Autowired
	MemberEmailCheckService memberEmailCheckService;
	@RequestMapping("memberConfirm")
	public String  memberConfirm(
			@RequestParam(value="chk") String email) {
		int i = memberEmailCheckService.execute(email);
		if (i > 0) {
			return "인증되었습니다.";
		}
		return "이미 인증되었습니다.";
	}
}



