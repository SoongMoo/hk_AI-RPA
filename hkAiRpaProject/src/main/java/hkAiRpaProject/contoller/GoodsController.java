package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkAiRpaProject.command.FileInfoCommand;
import hkAiRpaProject.command.GoodsCommand;
import hkAiRpaProject.service.goods.FileDelService;
import hkAiRpaProject.service.goods.GoodsDeleteService;
import hkAiRpaProject.service.goods.GoodsDetailService;
import hkAiRpaProject.service.goods.GoodsListService;
import hkAiRpaProject.service.goods.GoodsRegistService;
import hkAiRpaProject.service.goods.GoodsUpdateService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@ModelAttribute
	public GoodsCommand goodsCommand() {
		return new GoodsCommand();
	}
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	@Autowired
	GoodsRegistService goodsRegistService;
	@RequestMapping(value="goodsRegist", method=RequestMethod.GET)
	public String goodsRegist(HttpSession session,Model model) {
		goodsRegistService.execute(session, model);
		return "thymeleaf/goods/goodsForm";
	}
	@RequestMapping(value="goodsRegist", method=RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand , BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}

		if(goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			result.rejectValue("goodsMain", "goodsCommand.goodsMain" , "대문이미지를 선택해주세요.");
			return "thymeleaf/goods/goodsForm";
		}

		goodsRegistService.execute(goodsCommand, session);
		return "redirect:goodsList"; 
	}
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("goodsDetail")
	public String goodsDetail(
			@RequestParam(value="goodsNum") String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	@RequestMapping("goodsModify")
	public String goodsModify(
			@RequestParam(value="goodsNum") String goodsNum, Model model ,HttpSession session) {
		session.removeAttribute("fileList");
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsUpdate";
	}
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(@Validated GoodsCommand goodsCommand, BindingResult result ,
			HttpSession session ,Model model) {
		goodsUpdateService.execute(goodsCommand, session, result , model);
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsUpdate";
		}
		return "redirect:goodsDetail?goodsNum="+goodsCommand.getGoodsNum();
	}
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@RequestMapping("goodsDelete/{goodsNum}")
	public String goodsDelete(@PathVariable(value = "goodsNum") String goodsNum
			,  HttpSession session) {
		goodsDeleteService.execute(goodsNum, session);
		return "redirect:../goodsList";
	}
	
	@Autowired
	FileDelService fileDelService;
	@RequestMapping("fileDel")
	public @ResponseBody String  fileDel(FileInfoCommand fileInfoCommand,HttpSession session) {
		return fileDelService.execute(fileInfoCommand, session);
	}
	
	
	
	
	
	
}
