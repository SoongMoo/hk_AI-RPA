package hkAiRpaProject;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import hkAiRpaProject.command.LoginCommand;
import hkAiRpaProject.service.CookiesService;
import hkAiRpaProject.service.goods.IndexGoodsListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@SpringBootApplication
@MapperScan(value = {"hkAiRpaProject"})
public class HkAiRpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HkAiRpaProjectApplication.class, args);
	}

	@ModelAttribute
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	@Autowired
	IndexGoodsListService indexGoodsListService;
	@Autowired
	CookiesService cookiesService;
	@RequestMapping("/")
	public String index(/*LoginCommand loginCommand*/Model model,
			HttpServletRequest request ) {
		cookiesService.execute(request, model);
		
		indexGoodsListService.execute(null , model);
		return "thymeleaf/index";
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean(value = "jsonView")
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }
	
}
