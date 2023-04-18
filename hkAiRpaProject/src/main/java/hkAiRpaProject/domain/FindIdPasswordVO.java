package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("findIdPasswordVO")
public class FindIdPasswordVO {
	String userId;
	String userEmail;
	String userPhone;
	String grade;
	
	
	String userPw;
	String tableName;
	String columnName;
	String userIdColumn;
}
