package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.service.review.GoodsReviewUpdateService;
import hkAiRpaProject.service.review.ReviewListService;
import hkAiRpaProject.service.review.ReviewWriteService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@RequestMapping("goodsReview")
	public String goodsReview(
			@ModelAttribute(value="goodsNum")String goodsNum,
			@ModelAttribute(value="purchaseNum")String purchaseNum
			, Model model) {
		return "thymeleaf/review/goodsReview";
	}
	@Autowired
	ReviewWriteService reviewWriteService;
	@RequestMapping(value = "reviewWrite", method = RequestMethod.POST)
	public String reviewWrite(
			@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="reviewContent") String reviewContent,
			@RequestParam(value="purchaseNum") String purchaseNum) {
		reviewWriteService.execute(goodsNum,reviewContent,purchaseNum );
		return "redirect:/puchase/orderList";
	}
	
	@Autowired
	GoodsReviewUpdateService goodsReviewUpdateService;
	@GetMapping("goodsReviewUpdate")
	public String goodsReviewUpdate(
			@RequestParam(value="reviewNum") String reviewNum
			, Model model) {
		goodsReviewUpdateService.execute(reviewNum, model);
		return "thymeleaf/review/goodsReviewUpdate";
	}
	
	@PostMapping("goodsReviewUpdate")
	public String goodsReviewUpdate(
			@RequestParam(value="reviewNum") Long reviewNum,
			@RequestParam(value="reviewContent") String reviewContent) {
		goodsReviewUpdateService.execute(reviewNum,reviewContent);
		return "redirect:goodsReviewUpdate?reviewNum="+reviewNum;
	}
	@GetMapping("goodsReviewDelete")
	public String goodsReviewDelete(
			@RequestParam(value="reviewNum") String reviewNum) {
		goodsReviewUpdateService.execute(reviewNum);
		return "redirect:/puchase/orderList";
	}
	@Autowired
	ReviewListService reviewListService;
	@RequestMapping("reviewList")
	public String reviewList(
			@RequestParam(value="goodsNum") String goodsNum
			, Model model) {
		reviewListService.execute(goodsNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/review/reviewList";
	}
	
	
	
	
	
}
