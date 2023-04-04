package hkAiRpaProject.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;

@Service
public class MemberMyUpdateService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(MemberCommand memberCommand, BindingResult result) {
		String memberPw = memberShipMapper.memberPwSelect(memberCommand.getMemberId());
		System.out.println(memberPw);
		if(passwordEncoder.matches(memberCommand.getMemberPw(), memberPw)) {
			MemberVO vo = new MemberVO();
			vo.setMemberAddr(memberCommand.getMemberAddr());
			vo.setMemberAddr2(memberCommand.getMemberAddr2());
			vo.setMemberBirth(memberCommand.getMemberBirth());
			vo.setMemberEmail(memberCommand.getMemberEmail());
			vo.setMemberGender(memberCommand.getMemberGender());
			vo.setMemberId(memberCommand.getMemberId());
			vo.setMemberName(memberCommand.getMemberName());
			vo.setMemberPhone(memberCommand.getMemberPhone());
			vo.setMemberPost(memberCommand.getMemberPost());
			int i = memberShipMapper.myInfoUpdate(vo);
			System.out.println(i + "행이(가) 수정되었습니다.");
		}else {
			result.rejectValue("memberPw", "memberCommand.memberPw", "비밀번호가 맞지 않습니다.");
		}
	}
}
