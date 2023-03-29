package hkAiRpaProject.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberMapper;

@Service
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model) {
		List<MemberVO> list = memberMapper.memberAllSelect();
		model.addAttribute("list", list);
	}
	
}
