package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.command.PurchaseCommand;
import hkAiRpaProject.service.puchase.GoodsBuyService;
import hkAiRpaProject.service.puchase.GoodsOrderService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("puchase")
public class PuchaseController {
	@Autowired
	GoodsBuyService GoodsBuyService;
	@RequestMapping(value="goodsBuy")
	public String goodsBuy(
			@RequestParam(value="prodCk") String [] prodCk,
			HttpSession session, Model model
			) {
		GoodsBuyService.execute(prodCk, session, model);
		return "thymeleaf/puchase/goodsOrder";
	}
	@Autowired
	GoodsOrderService goodsOrderService;
	@RequestMapping("goodsOrder")
	public String goodsOrder(
			PurchaseCommand purchaseCommand,HttpSession session,Model model) {
		goodsOrderService.execute(purchaseCommand, session, model);
		return "thymeleaf/puchase/payment";
	}
}
