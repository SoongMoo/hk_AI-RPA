package hkAiRpaProject.service.inquire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.InquireVO;
import hkAiRpaProject.repository.InquireRepository;

@Service
public class InquireListService {
	@Autowired
	InquireRepository inquireRepository;
	public void execute(String goodsNum, Model model) {
		InquireVO vo = new InquireVO();
		vo.setGoodsNum(goodsNum);
		List<InquireVO> list = inquireRepository.inquireList(vo);
		model.addAttribute("list", list);
	}
}
