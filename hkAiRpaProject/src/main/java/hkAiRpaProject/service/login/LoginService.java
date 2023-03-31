package hkAiRpaProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.mapper.LoginMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(LoginCommand loginCommand, HttpSession session) {
		AuthInfoVO vo = loginMapper.loginSelect(loginCommand);
		if(vo != null) {
			session.setAttribute("authInfo", vo);
		}
		/*
		if (vo == null) {
			System.out.println("가입된 사용자가 없습니다.");
			return -1;
		}else {
			if(vo.getMemberOk().equals("Y") || vo.getGrade().equals("emp")) {
				
				if(passwordEncoder.matches(loginCommand.getUserPw(), vo.getUserPw())) {
					System.out.println("가입된 사용자입니다.");
					System.out.println("로그인");
					session.setAttribute("authInfo", vo);
					return 1;
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					return 0;
				}
				
			}else {
				System.out.println("이메일을 확인하셔야 합니다.");
				return 2;
			}
			
		}
		*/
	}
}
