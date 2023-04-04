package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.mapper.MemberShipMapper;

@Service
public class MemberEmailCheckService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public Integer execute(String email) {
		int i = memberShipMapper.memberCkeckUpdate(email);
		return i;
	}
}
