package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.service.goodsIpgo.GoodsIpgoAutoNumservice;
import hkAiRpaProject.service.goodsIpgo.GoodsItemService;

@Controller
@RequestMapping("goods")
public class GoodsIpgoController {
	@Autowired
	GoodsIpgoAutoNumservice goodsIpgoAutoNumservice;
	@RequestMapping("goodsIpgo")
	public String goodsIpgo(Model model) {
		goodsIpgoAutoNumservice.execute(model);
		return "thymeleaf/goodsIpgo/goodsIpgo";
	}
	@Autowired
	GoodsItemService goodsItemService;
	@RequestMapping(value="goodsItem")
	public String goodsItem(
			@RequestParam(value="goodsWord" , required = false )String goodsWord,
			@RequestParam(value="page" , required = false, defaultValue = "1" )int page,
			Model model) {
		goodsItemService.execute(goodsWord, model, page);
		return "thymeleaf/goodsIpgo/goodsItem";
	}
}
