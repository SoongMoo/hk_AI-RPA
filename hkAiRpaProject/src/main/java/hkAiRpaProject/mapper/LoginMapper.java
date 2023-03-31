package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.domain.AuthInfoVO;

@Repository("hkAiRpaProject.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfoVO loginSelect(LoginCommand loginCommand);
}
