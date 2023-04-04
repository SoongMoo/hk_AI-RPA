package hkAiRpaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.mapper.LoginMapper;
import hkAiRpaProject.mapper.MemberShipMapper;

@Service
public class IdcheckService {
	@Autowired
	LoginMapper loginMapper;
	public String execute( String memberId ) {
		String memId = loginMapper.selectIdCheck(memberId);
		return memId;
	}
}
