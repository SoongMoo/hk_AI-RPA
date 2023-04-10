package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hkAiRpaProject.command.GoodsIpgoCommand;
import hkAiRpaProject.service.goodsIpgo.GoodsIpgoAutoNumservice;
import hkAiRpaProject.service.goodsIpgo.GoodsIpgoDeleteService;
import hkAiRpaProject.service.goodsIpgo.GoodsIpgoDetailService;
import hkAiRpaProject.service.goodsIpgo.GoodsIpgoListService;
import hkAiRpaProject.service.goodsIpgo.GoodsIpgoService;
import hkAiRpaProject.service.goodsIpgo.GoodsIpgoUpdateService;
import hkAiRpaProject.service.goodsIpgo.GoodsItemService;
import jakarta.servlet.http.HttpSession;

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
	
	@Autowired
	GoodsIpgoService goodsIpgoService;
	@RequestMapping("ipgoRegist")
	public String ipgoRegist(
			GoodsIpgoCommand goodsIpgoCommand, HttpSession session
			) {
		goodsIpgoService.execute(goodsIpgoCommand, session);
		return "redirect:goodsList";
	}
	
	@Autowired
	GoodsIpgoListService goodsIpgoListService;
	/*
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList(Model model) {
		goodsIpgoListService.execute(model);
		return "thymeleaf/goodsIpgo/goodsIpgoList1";
	}
	*/
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList() {
		return "thymeleaf/goodsIpgo/goodsIpgoList";
	}

	@RequestMapping("goodsIpgoList1")
	public ModelAndView goodsIpgoList(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		goodsIpgoListService.execute(model);
		return mav;
	}
	@Autowired
	GoodsIpgoDetailService goodsIpgoDetailService;
	@RequestMapping(value="goodsIpgoDetail",method = RequestMethod.GET)
	public String goodsIpgoDetail(
			@RequestParam(value="goodsIpgoNum") String goodsIpgoNum,
			Model model) {
		goodsIpgoDetailService.execute(goodsIpgoNum, model);
		return "thymeleaf/goodsIpgo/goodsIpgoDetail";
	}
	
	@RequestMapping(value="goodsIpgoUpdate", method = RequestMethod.GET)
	public String goodsIpgoUpdate(
			@RequestParam(value="goodsIpgoNum") String goodsIpgoNum, Model model) {
		goodsIpgoDetailService.execute(goodsIpgoNum, model);
		return "thymeleaf/goodsIpgo/goodsIpgoUpdate";
	}
	@Autowired
	GoodsIpgoUpdateService goodsIpgoUpdateService;
	@RequestMapping(value="goodsIpgoUpdate", method=RequestMethod.POST)
	public String goodsIpgoUpdate(GoodsIpgoCommand goodsIpgoCommand, HttpSession session) {
		goodsIpgoUpdateService.execute(goodsIpgoCommand, session);
		return "redirect:goodsList";
	}
	@Autowired
	GoodsIpgoDeleteService goodsIpgoDeleteService;
	@RequestMapping("goodsIpgoDelete")
	public String goodsIpgoDelete(
			@RequestParam(value="goodsIpgoNum") String goodsIpgoNum) {
		goodsIpgoDeleteService.execute(goodsIpgoNum);
		return "redirect:goodsList";
	}
	
	
	
	
}
