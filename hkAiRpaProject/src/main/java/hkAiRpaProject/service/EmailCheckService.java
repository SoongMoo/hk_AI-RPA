package hkAiRpaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.mapper.LoginMapper;

@Service
public class EmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	public String execute(String userEmail) {
		String userEamil = loginMapper.selectEmailCheck(userEmail) ;
		return userEamil;
	}
}
