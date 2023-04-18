package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.service.puchase.PurchaseListService;

@Controller
@RequestMapping("puchase")
public class EmpPurchaseController {
	@Autowired
	PurchaseListService purchaseListService;
	@RequestMapping("purchaseList")
	public String purchaseList(Model model) {
		purchaseListService.execute(model);
		return "thymeleaf/puchase/purchaseList";
	}
	@RequestMapping("purchaseStatus")
	public String purchaseStatus(
			@RequestParam(value="purchaseNum")String purchaseNum) {
		purchaseListService.execute(purchaseNum);
		return "redirect:purchaseList";
	}
}
