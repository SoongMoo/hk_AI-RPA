package hkAiRpaProject.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.InquireCommand;
import hkAiRpaProject.domain.InquireVO;
import hkAiRpaProject.repository.InquireRepository;

@Service
public class InquireModifyService {
	@Autowired
	InquireRepository inquireRepository;
	public void execute(InquireCommand inquireCommand) {
		InquireVO vo = new InquireVO();
		vo.setInquireContent(inquireCommand.getInquireContent());
		vo.setInquireKind(inquireCommand.getInquireKind());
		vo.setInquireNum(Integer.parseInt(inquireCommand.getInquireNum()));
		vo.setInquireSubject(inquireCommand.getInquireSubject());
		inquireRepository.inquireUpdate(vo);
		
	}
}
