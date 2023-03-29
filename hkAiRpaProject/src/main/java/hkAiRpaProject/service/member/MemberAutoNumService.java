package hkAiRpaProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.command.MemberCommand;
import hkAiRpaProject.mapper.MemberMapper;

@Service
public class MemberAutoNumService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand, Model model) {
		String memberNum = memberMapper.autoNum(); /// mem100001
		memberCommand.setMemberNum(memberNum);/// memberNum = mem100001
		model.addAttribute("memberCommand", memberCommand);
		//model.addAttribute("empNum", memberNum);
	}
}
