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
import jakarta.mail.MessagingException;


@Service
public class MemberJoinService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	EmailSendService emailSendService;
	@Autowired
	SMSSendService sMSSendService;
	@Autowired
	PasswordEncoder passwordEncoder;
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
		vo.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		Integer i = memberShipMapper.MemberShipInsert(vo);
		System.out.println(i + " 행 이(가) 삽입되었습니다");
		
		model.addAttribute("userName", vo.getMemberName());
		model.addAttribute("userEmail", vo.getMemberEmail());
		
		/// 이메일 
		String _content = "<html><body>"
				        + vo.getMemberName() + "님 가입을 환영합니다."
				        + "<a href='http://localhost:8080/memberConfirm?chk=" + vo.getMemberEmail() +"'>"
				        + "가입하시려면 여기를 눌러주세요.</a>"
				        + "</body></html>"; // 내용
		String _subject = "환영 인사입니다."; // 제목
		String _fromEmail = "highland0@nate.com"; // 보내는 사람의 이메일 주소
		String _toEmail = vo.getMemberEmail(); // 받는 사람의 이메일 주소

		try {
			emailSendService.mailsend(_content, _subject, _fromEmail, _toEmail);
			/// SMS
			_content = "안녕하세요. 한경쇼핑몰입니다."
					 + vo.getMemberName() + "님 가입을 축하드립니다."
					 + "신고는 080-123-1234으로 연락주세요.";
			String _from = "010-7146-1970";
			String _to = vo.getMemberPhone();
			sMSSendService.smsSend(_from, _to, _content);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
