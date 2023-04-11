package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkAiRpaProject.service.corner.GoodsWishCheckService;
import hkAiRpaProject.service.corner.GoodsWishListService;
import hkAiRpaProject.service.corner.GoodsWishService;
import hkAiRpaProject.service.goods.IndexGoodsListService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	IndexGoodsListService indexGoodsListService;
	@Autowired
	GoodsWishCheckService goodsWishCheckService;
	@RequestMapping("prodInfo/{num}")
	public String prodInfo(
			@PathVariable(value="num") String goodsNum,Model model, HttpSession session) {
		indexGoodsListService.execute(goodsNum, model);
		goodsWishCheckService.execute(goodsNum, model, session);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/corner/prodInfo";
	}
	@Autowired
	GoodsWishService goodsWishService;
	@RequestMapping(value="goodsWishAdd", method=RequestMethod.POST)
	public @ResponseBody String goodsWishAdd(
			@RequestParam(value="goodsNum")String goodsNum,
			HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
	@Autowired
	GoodsWishListService goodsWishListService;
	@RequestMapping(value="wishList")
	public String wishList(HttpSession session,Model model) {
		goodsWishListService.execute(session, model);
		return "thymeleaf/corner/wishList";
	}
	
}
