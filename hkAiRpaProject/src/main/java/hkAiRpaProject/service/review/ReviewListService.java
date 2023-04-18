package hkAiRpaProject.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.ReviewVO;
import hkAiRpaProject.repository.ReviewRepository;

@Service
public class ReviewListService {
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String goodsNum, Model model) {
		List<ReviewVO> list = reviewRepository.goodsReviewList(goodsNum);
		model.addAttribute("list", list);
	}
}
