package hkAiRpaProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.mapper.LoginMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	public void execute(LoginCommand loginCommand, HttpSession session) {
		AuthInfoVO vo = loginMapper.loginSelect(loginCommand.getUserId());
		if (vo != null) session.setAttribute("authInfo", vo); ///접속중인 사용자입니다.
	}
}
