package hkAiRpaProject.contoller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkAiRpaProject.command.InquireCommand;
import hkAiRpaProject.repository.InquireRepository;
import hkAiRpaProject.service.inquire.GoodsInquireDetailService;
import hkAiRpaProject.service.inquire.GoodsQuestionService;
import hkAiRpaProject.service.inquire.InquireAnswerWriteService;
import hkAiRpaProject.service.inquire.InquireListService;
import hkAiRpaProject.service.inquire.InquireModifyService;
import hkAiRpaProject.service.inquire.InquireWriteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("inquire")
public class InquireController {
	@Autowired
	InquireListService inquireListService;
	@RequestMapping("inquireList")
	public String inquireList(
			@RequestParam(value="goodsNum") String goodsNum, Model model
			) {
		inquireListService.execute(goodsNum, model);
		model.addAttribute("goodsNum", goodsNum);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/inquire/inquireList";
	}
	
	@GetMapping("inquireWrite")
	public String inquireWrite(
			@ModelAttribute(value="goodsNum") String goodsNum) {
		return "thymeleaf/inquire/inquireWrite";
	}
	@Autowired
	InquireWriteService inquireWriteService;
	@PostMapping("inquireWrite")
	public void  inquireWrite(InquireCommand inquireCommand,
			HttpSession session, HttpServletResponse response) {
		inquireWriteService.execute(inquireCommand, session);
		
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String str = "<script>"
					+ "opener.parent.inquire();"
					+ "window.self.close()"
					+ "</script>";
			out.print(str);
			out.close();
		}catch(Exception e) {}
	}
	@Autowired
	GoodsQuestionService goodsQuestionService;
	@RequestMapping("goodsQuestion")
	public String goodsQuestion(Model model) {
		goodsQuestionService.execute(model);
		return "thymeleaf/inquire/goodsQuestion";
	}
	@Autowired
	GoodsInquireDetailService goodsInquireDetailService;
	@RequestMapping("goodsInquireDetail/{num}")
	public String goodsInquireDetail(
			@PathVariable(value="num") String inquireNum, Model model) {
		goodsInquireDetailService.execute(inquireNum,model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/inquire/goodsInquireDetail"; 
	}
	@Autowired
	InquireAnswerWriteService inquireAnswerWriteService;
	@PostMapping("answerWrite")
	public String answerWrite(InquireCommand inquireCommand, HttpSession  session) {
		inquireAnswerWriteService.execute(inquireCommand, session);
		return "redirect:goodsQuestion";
	}
	@GetMapping("inquireUpdate")
	public String inquireUpdate(
			@RequestParam(value="inquireNum") String inquireNum, Model model) {
		goodsInquireDetailService.execute(inquireNum,model);
		return "thymeleaf/inquire/goodsInquireUpdate"; 
	}
	@Autowired
	InquireModifyService inquireModifyService;
	@PostMapping("inquireUpdate")
	public void inquireUpdate(InquireCommand inquireCommand , HttpServletResponse response) {
		inquireModifyService.execute(inquireCommand);		
		try {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String str  = "<script>"
					+ "opener.parent.inquire();"
					+ "window.self.close();"
					+ "</script>";
		out.print(str);
		out.close();
		}catch(Exception e) {}
		
	}
	@Autowired
	InquireRepository inquireRepository;
	@RequestMapping("inquireDelete")
	public @ResponseBody String inquireDelete(
			@RequestParam(value="inquireNum") String inquireNum) {
		Integer i = inquireRepository.inquireDelete(inquireNum);
		return i.toString();
	}
	
	
	
	
	
	
	
}
