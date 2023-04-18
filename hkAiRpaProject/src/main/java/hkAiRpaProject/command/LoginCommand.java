package hkAiRpaProject.command;

import org.apache.ibatis.type.Alias;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Alias("login")
public class LoginCommand {
	String userId;
	String userPw;
	
	
	Boolean autoLogin;
	Boolean idStore;
}
