package hkAiRpaProject.service.inquire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.InquireCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.domain.InquireVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberMapper;
import hkAiRpaProject.repository.InquireRepository;
import hkAiRpaProject.service.EmailSendService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Service
public class InquireAnswerWriteService {
	@Autowired
	InquireRepository inquireRepository;
	@Autowired
	EmailSendService emailSendService;
	@Autowired
	MemberMapper memberMapper;
	public void execute(InquireCommand inquireCommand, HttpSession  session) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpNum("emp100001");
		
		InquireVO vo = new InquireVO();
		vo.setInquireNum(Integer.parseInt(inquireCommand.getInquireNum()));
		vo.setInquireAnswer(inquireCommand.getInquireAnswer());
		vo.setEmpNum(emp.getEmpNum());
		int i = inquireRepository.inquireAnswerUpdate(vo);
		if(i > 0) { // 메일링
			
			MemberVO mem = memberMapper.memberOneSelect(inquireCommand.getMemberNum()); 
			
			String subject = inquireCommand.getInquireSubject() +"의 답변";
			String content = inquireCommand.getInquireSubject() + "의 답변 <br />"
					       + inquireCommand.getInquireAnswer().replace("\n","<br />");
			String from = "highalnd0@naver.com";
			String to = mem.getMemberEmail();
			try {
				emailSendService.mailsend(content, subject, from, to);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
}
