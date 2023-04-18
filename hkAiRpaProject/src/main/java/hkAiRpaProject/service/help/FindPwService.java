package hkAiRpaProject.service.help;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import hkAiRpaProject.command.FindPasswordCommand;
import hkAiRpaProject.domain.FindIdPasswordVO;
import hkAiRpaProject.mapper.FindMapper;
import hkAiRpaProject.service.EmailSendService;
import jakarta.mail.MessagingException;

@Service
public class FindPwService {
	@Autowired
	FindMapper findMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailSendService emailSendService;
	public void execute(FindPasswordCommand findPasswordCommand, BindingResult result
			, Model model) {
		FindIdPasswordVO vo = findMapper.findId(findPasswordCommand.getUserPhone());
		if(vo != null) {
			if(vo.getUserId().equals(findPasswordCommand.getUserId())) {
				String tempPw = UUID.randomUUID().toString().substring(0,8);
				String encPw = passwordEncoder.encode(tempPw);
				vo.setUserId(findPasswordCommand.getUserId());
				vo.setUserPw(encPw);
				if(vo.getGrade().equals("emp")) {
					vo.setTableName("employees");
					vo.setColumnName("emp_pw");
					vo.setUserIdColumn("emp_id");
				}else {
					vo.setTableName("member");
					vo.setColumnName("member_pw");
					vo.setUserIdColumn("member_id");
				}
				findMapper.userPwUpdate(vo);
				String content = vo.getUserId() + "님의 임시비밀번호는 " + tempPw + "입니다.<br />"
						+ " 로그인 후 비밀번호를 변경해 주세요.";
				String to = vo.getUserEmail();
				try {
					emailSendService.mailsend(content,"임시비밀번호","highland0@nate.com" ,to);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				model.addAttribute("userId", vo.getUserId());
				model.addAttribute("userEmail", vo.getUserEmail());
			}else {
				result.rejectValue("userId","notFind");
			}
		}else {
			result.rejectValue("userPhone","bad");
		}
	}
}
