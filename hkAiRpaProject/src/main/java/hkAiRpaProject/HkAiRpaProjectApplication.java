package hkAiRpaProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@MapperScan(value = {"hkAiRpaProject"})
public class HkAiRpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HkAiRpaProjectApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "thymeleaf/index";
	}
	
}
