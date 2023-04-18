package hkAiRpaProject.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.InquireCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.InquireVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import hkAiRpaProject.repository.InquireRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class InquireWriteService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	InquireRepository inquireRepository;
	public void execute(InquireCommand inquireCommand,
			HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		InquireVO vo = new InquireVO();
		vo.setGoodsNum(inquireCommand.getGoodsNum());
		vo.setInquireContent(inquireCommand.getInquireContent());
		vo.setInquireKind(inquireCommand.getInquireKind());
		vo.setInquireSubject(inquireCommand.getInquireSubject());
		vo.setMemberNum(mem.getMemberNum());
		inquireRepository.inquireInsert(vo);
	}
}
