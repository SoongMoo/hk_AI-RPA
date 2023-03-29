package hkAiRpaProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberMapper;

@Service
public class MemberDetailService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memberNum, Model model) {
		MemberVO vo = memberMapper.memberOneSelect(memberNum);
		model.addAttribute("memberVO", vo);
	}
}
