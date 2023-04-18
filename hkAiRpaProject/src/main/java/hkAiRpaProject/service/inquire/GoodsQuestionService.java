package hkAiRpaProject.service.inquire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.InquireVO;
import hkAiRpaProject.repository.InquireRepository;

@Service
public class GoodsQuestionService {
	@Autowired
	InquireRepository inquireRepository;
	public void execute(Model model) {
		List<InquireVO> list = inquireRepository.inquireList(null);
		model.addAttribute("list", list);
	}
}
