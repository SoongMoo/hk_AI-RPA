package hkAiRpaProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hkAiRpaProject.command.FindIdCommand;
import hkAiRpaProject.command.FindPasswordCommand;
import hkAiRpaProject.service.help.FindIdService;
import hkAiRpaProject.service.help.FindPwService;

@Controller
@RequestMapping("help")
public class HelpController {
	/*
	public FindIdCommand findIdCommand() {
		return new FindIdCommand();
	}
	*/
	@GetMapping("findId")
	public String findId(/*FindIdCommand findIdCommand*/
			@ModelAttribute("findIdCommand") FindIdCommand findIdCommand  ) {
		return "thymeleaf/help/findId";
	}
	@Autowired
	FindIdService findIdService;
	@PostMapping("findId")
	public String findId(@Validated FindIdCommand findIdCommand 
			, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/help/findId";
		}
		findIdService.execute(findIdCommand, result, model);
		if(result.hasErrors()) {
			return "thymeleaf/help/findId";
		}
		return "thymeleaf/help/findIdOk";
	}
	@GetMapping("findPassword")
	public String findPassword(FindPasswordCommand findPasswordCommand) {
		return "thymeleaf/help/findPw";
	}
	@Autowired
	FindPwService findPwService;
	@PostMapping("findPassword")
	public String findPassword(FindPasswordCommand findPasswordCommand, BindingResult result
			, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/help/findPw";
		}
		findPwService.execute(findPasswordCommand, result, model);
		if(result.hasErrors()) {
			return "thymeleaf/help/findPw";
		}
		return "thymeleaf/help/findPwOk";
	}
}
