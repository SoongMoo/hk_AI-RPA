package hkAiRpaProject.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.domain.ReviewVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import hkAiRpaProject.repository.ReviewRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class ReviewWriteService {
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String goodsNum, String reviewContent,String purchaseNum) {
		ReviewVO dto = new ReviewVO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		dto.setReviewContent(reviewContent);
		reviewRepository.reviewWrite(dto);
	}
}
