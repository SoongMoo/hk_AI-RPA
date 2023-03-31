package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("authInfo")
public class AuthInfoVO {
	String userId;
	String userEmail;
	String userPw;
	String phone;
	String memberOk;
	String grade;
}
