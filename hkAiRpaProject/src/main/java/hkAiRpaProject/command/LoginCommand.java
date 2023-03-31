package hkAiRpaProject.command;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("login")
public class LoginCommand {
	String userId;
	String userPw;
}
