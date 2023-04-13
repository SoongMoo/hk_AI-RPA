package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.command.PurchaseCommand;
import hkAiRpaProject.service.iniPay.IniPayReqService;
import hkAiRpaProject.service.iniPay.IniPayReturnService;
import hkAiRpaProject.service.puchase.GoodsBuyService;
import hkAiRpaProject.service.puchase.GoodsOrderService;
import hkAiRpaProject.service.puchase.OrderProcessListService;
import jakarta.servlet.http.HttpServletRequest;
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
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session, model);
		return "redirect:paymentOk?purchaseNum="+purchaseNum 
								+"&totalPrice="+purchaseCommand.getTotalPrice();
	}
	@Autowired
	OrderProcessListService orderProcessListService;
	@RequestMapping("orderList")
	public String orderList(HttpSession session, Model model) {
		orderProcessListService.execute(session, model);
		return "thymeleaf/puchase/orderList";
	}
	@Autowired
	IniPayReqService iniPayReqService;
	@RequestMapping("paymentOk")
	public String paymentOk(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value="totalPrice")String totalPrice,
			HttpSession session, Model model) {
		try {
			iniPayReqService.execute(purchaseNum, totalPrice,session, model );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/puchase/payment";
	}
	@Autowired
	IniPayReturnService iniPayReturnService;
	@RequestMapping("INIstdpay_pc_return")
	public String INIstdpay_pc_return(
			HttpServletRequest request, HttpSession session, Model model ) {
		iniPayReturnService.execute(request, session, model);
		return "thymeleaf/puchase/buyfinished";
	}
	@RequestMapping("close")
	public String close() {
		return "thymeleaf/puchase/close";
	}
	
}
