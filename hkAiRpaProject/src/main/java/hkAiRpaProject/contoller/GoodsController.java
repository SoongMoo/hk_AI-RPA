package hkAiRpaProject.contoller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hkAiRpaProject.command.FileInfoCommand;
import hkAiRpaProject.command.GoodsCommand;
import hkAiRpaProject.service.goods.FileDelService;
import hkAiRpaProject.service.goods.GoodsDeleteService;
import hkAiRpaProject.service.goods.GoodsDetailService;
import hkAiRpaProject.service.goods.GoodsListService;
import hkAiRpaProject.service.goods.GoodsRegistService;
import hkAiRpaProject.service.goods.GoodsUpdateService;
import jakarta.servlet.http.HttpServletResponse;
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
		//return "thymeleaf/goods/goodsForm";
		// return "thymeleaf/goods/goodsForm1";
		return "thymeleaf/goods/goodsForm2";
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
	
	@RequestMapping("goodsRegist2")
	public @ResponseBody Map<String, Object> goodsRegist2(
			GoodsCommand goodsCommand, HttpSession session
			) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		goodsRegistService.execute(goodsCommand, session);
		map.put("SUCCESS", true);
		map.put("HEADER", 107);
		return map;
	}
	@RequestMapping("goodsRegist3")
	public @ResponseBody Map<String, Object> goodsRegist3(
			MultipartHttpServletRequest request, HttpSession session){
		GoodsCommand goodsCommand = new GoodsCommand();
		goodsCommand.setDeliveryCost(Integer.parseInt(request.getParameter("deliveryCost")));
		goodsCommand.setGoodsContent(request.getParameter("goodsContent"));
		goodsCommand.setGoodsName(request.getParameter("goodsName"));
		goodsCommand.setGoodsNum(request.getParameter("goodsNum"));
		goodsCommand.setManufacturer(request.getParameter("manufacturer"));
		goodsCommand.setEmpNum(request.getParameter("empNum"));
		
		MultipartFile  goodsMain = request.getFile("goodsMain");
		
		List<MultipartFile>  goodsImages = request.getFiles("goodsImage");
		Integer size = goodsImages.size();
		MultipartFile [] goodsImage = new MultipartFile[size];
		for(int i = 0; i < size ; i++) {
			goodsImage[i] = goodsImages.get(i);
		}
		goodsCommand.setGoodsMain(goodsMain);
		goodsCommand.setGoodsImage(goodsImage);		
		
		goodsRegistService.execute(goodsCommand, session);
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("SUCCESS", true);
		map.put("HEADER", 107);
		return map;
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
			,  HttpSession session,HttpServletResponse response) {
		try {
			goodsDeleteService.execute(goodsNum, session);
			return "redirect:../goodsList";
		}catch(Exception e) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String str= "<script language='javascript'>"
						+ " alert('입고정보 또는 구매정보가 있어서 상품정보를 삭제할 수 없습니다.');"
						+ " location.href='/goods/goodsDetail?goodsNum="+goodsNum+"'"
						+ "</script>";
				out.print(str);
				out.close();
			}catch(Exception e1) {
				System.out.println("오류!!!!!");
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	@Autowired
	FileDelService fileDelService;
	@RequestMapping("fileDel")
	public @ResponseBody String  fileDel(FileInfoCommand fileInfoCommand,HttpSession session) {
		return fileDelService.execute(fileInfoCommand, session);
	}	
}
