package hkAiRpaProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.mapper.LoginMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(LoginCommand loginCommand, HttpSession session
			,BindingResult result, HttpServletResponse response) {
		AuthInfoVO vo = loginMapper.loginSelect(loginCommand.getUserId());
		if (vo != null) {
			System.out.println("가입된 회원입니다.");
			if (vo.getGrade().equals("mem") && vo.getMemberOk()==null) {
				System.out.println("이메일인증이 안된 회원");
				result.rejectValue("userId", "loginCommand.userId", "이메일 인증이 안되었습니다.");
			}
			if(passwordEncoder.matches(loginCommand.getUserPw(), vo.getUserPw())) {
				System.out.println("비밀번호가 일치");
				session.setAttribute("authInfo", vo);///접속중인 사용자입니다
				
				if(loginCommand.getIdStore() != null && loginCommand.getIdStore()) {
					Cookie cookie = new Cookie("idStore", loginCommand.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("idStore", "");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				if(loginCommand.getAutoLogin() != null && loginCommand.getAutoLogin()) {
					Cookie cookie = new Cookie("autoLogin", loginCommand.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
			}else {
				System.out.println("비밀번호가 일치 하지 않습니다.");
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 틀렸습니다.");
			}
		}else{
			System.out.println("가입하지 않은 회원입니다.");
			result.rejectValue("userId", "loginCommand.userId", "가입하지 않은 회원입니다.");
		}
	}
}
