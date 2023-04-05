package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.service.memberShip.MemberMyUpdateService;
import hkAiRpaProject.service.memberShip.MyDetailService;
import hkAiRpaProject.service.memberShip.MyOutService;
import hkAiRpaProject.service.memberShip.MyPassConService;
import hkAiRpaProject.service.memberShip.MyPassConfirmService;
import hkAiRpaProject.service.memberShip.MyPassUpdateService;
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
	@RequestMapping("myInfoUpdate")
	public String myInfoUpdate(HttpSession session,Model model) {
		myDetailService.execute(session,model);	
		return "thymeleaf/memberShip/myUpdateForm";
	}
	@Autowired
	MemberMyUpdateService memberMyUpdate;
	@RequestMapping("memberMyUpdate")
	public String memberMyUpdate(@Validated MemberCommand memberCommand, BindingResult result) {
		memberMyUpdate.execute(memberCommand, result);
		if(result.hasErrors()) {
			return "thymeleaf/memberShip/myUpdateForm";
		}
		return "redirect:myDetail";
	}
	
	@RequestMapping("myOutPass")
	public String myOutPass() {
		
		return "thymeleaf/memberShip/myPassCheck";
	}
	@Autowired
	MyPassConfirmService myPassConfirmService;
	@RequestMapping("passConfirm")
	public @ResponseBody boolean passConfirm(@RequestParam(value="userPw") String userPw,
			HttpSession session) {
		return myPassConfirmService.execute(userPw,session);
	}
	
	@Autowired
	MyOutService myOutService;
	@RequestMapping("myOut")
	public String myOut(HttpSession session) {
		myOutService.execute(session);
		return "redirect:/login/loginOut";
	}
	
	@RequestMapping(value="myPwUpdate", method = RequestMethod.GET)
	public String myPwUpdate() {
		return "thymeleaf/memberShip/myPassword";
	}
	
	@Autowired
	MyPassConService myPassConService;
	@RequestMapping(value="myPwUpdate", method = RequestMethod.POST)
	public @ResponseBody Boolean myPwUpdate(@RequestParam(value="userPw") String userPw,
			HttpSession session) {	
		return myPassConService.execute(userPw, session); // 호출 메서드
	}
	
	@RequestMapping("myPwUpdateCon")
	public String myPwUpdateCon() {
		return "thymeleaf/memberShip/myPasswordCon";
	}
	@Autowired
	MyPassUpdateService myPassUpdateService;
	@RequestMapping("myPwUpdatePro")
	public String myPwUpdatePro(@RequestParam(value="userPw")String userPw,
			HttpSession session) {
		myPassUpdateService.execute(userPw, session);
		return "redirect:myDetail";
	}
}
