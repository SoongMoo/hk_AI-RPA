package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.mapper.MemberShipMapper;

@Service
public class MemberMailService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public Integer execute(String recieve) {
		if (!recieve.equals("false")) {
			int i = memberShipMapper.memberMailOk(recieve); ///0/1
			return i;
		}
		return -1;

	}
}
