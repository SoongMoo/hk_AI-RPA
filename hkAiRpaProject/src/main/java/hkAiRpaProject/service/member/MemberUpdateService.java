package hkAiRpaProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberMapper;

@Service
/// 변수, 상수, 함수 모아둔 집합체다.
public class MemberUpdateService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberVO vo = new MemberVO();
		vo.setMemberAddr(memberCommand.getMemberAddr());
		vo.setMemberAddr2(memberCommand.getMemberAddr2());
		vo.setMemberBirth(memberCommand.getMemberBirth());
		vo.setMemberGender(memberCommand.getMemberGender());
		vo.setMemberName(memberCommand.getMemberName());
		vo.setMemberNum(memberCommand.getMemberNum());
		vo.setMemberPhone(memberCommand.getMemberPhone());
		vo.setMemberPost(memberCommand.getMemberPost());
		memberMapper.memberUpdate(vo);
	}
}
