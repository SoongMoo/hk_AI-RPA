package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import hkAiRpaProject.service.EmailSendService;
import hkAiRpaProject.service.SMSSendService;

@Service
public class MemberJoinService {
	@Autowired
	EmailSendService emailSendService;
	@Autowired
	SMSSendService sMSSendService;
	@Autowired
	PasswordEncoder  passwordEncoder;
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(MemberCommand memberCommand, Model model) {
		MemberVO vo = new MemberVO();
		vo.setMemberAddr(memberCommand.getMemberAddr());
		vo.setMemberAddr2(memberCommand.getMemberAddr2());
		vo.setMemberBirth(memberCommand.getMemberBirth());
		vo.setMemberEmail(memberCommand.getMemberEmail());
		vo.setMemberGender(memberCommand.getMemberGender());
		vo.setMemberId(memberCommand.getMemberId());
		vo.setMemberName(memberCommand.getMemberName());
		vo.setMemberPhone(memberCommand.getMemberPhone());
		vo.setMemberPost(memberCommand.getMemberPost());
		vo.setMemberPw( passwordEncoder.encode(memberCommand.getMemberPw()));
		memberShipMapper.memberJoinInsert(vo);
		model.addAttribute("userName", vo.getMemberName());
		model.addAttribute("userEmail", vo.getMemberEmail());
		
		
		/**** 메일 보내기 ****/
		String content = "<html><body>";
			   content += vo.getMemberName() + "한경 쇼핑몰입니다. <br />";
			   content += "<a href='http://localhost:8080/register/memberOk?recieve=";
			   content += vo.getMemberEmail()+"'>가입을 완료하시려면 클릭하세요.</a>";
			   content += "</html></body>";
		String subject = "가입환영인사";
		String fromEmail = "hiland00@gmail.com";
		String toEmail = vo.getMemberEmail();
		emailSendService.mailsend(content, subject, fromEmail, toEmail);
		
		/// 문자
		content = "안녕하세요.. 한경 쇼핑몰입니다. "
				+ "가입을 환영합니다. ";
		sMSSendService.smsSend("010-7146-1970", vo.getMemberPhone(), content);
	}
}
