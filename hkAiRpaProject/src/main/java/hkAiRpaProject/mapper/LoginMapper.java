package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.AuthInfoVO;

@Repository("hkAiRpaProject.mapper.LoginMapper")
public interface LoginMapper {
	public String selectIdCheck(String memberId);
	public String selectEmailCheck(String userEmail);
	public AuthInfoVO loginSelect(String userId);
}
