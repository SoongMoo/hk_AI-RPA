package hkAiRpaProject.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.MemberNumReviewNumVO;
import hkAiRpaProject.domain.PurchaseListPurchasePaymentGoodsVO;
import hkAiRpaProject.domain.ReviewVO;
import hkAiRpaProject.repository.PuchaseRepository;
import hkAiRpaProject.repository.ReviewRepository;

@Service
public class GoodsReviewUpdateService {
	@Autowired
	PuchaseRepository puchaseRepository;
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String reviewNum) {
		reviewRepository.reviewDelete(reviewNum);
	}
	
	public void execute(Long reviewNum, String reviewContent) {
		ReviewVO vo = new ReviewVO();
		vo.setReviewNum(reviewNum);
		vo.setReviewContent(reviewContent);
		reviewRepository.reviewUpdate(vo);
	}
	
	public void execute(String reviewNum, Model model) {
		MemberNumReviewNumVO vo = new MemberNumReviewNumVO();
		vo.setReviewNum(reviewNum);
		
		List<PurchaseListPurchasePaymentGoodsVO> list = 
				puchaseRepository.purchaseList(vo);
		model.addAttribute("list", list);
	}
}
