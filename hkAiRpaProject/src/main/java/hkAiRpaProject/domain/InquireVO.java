package hkAiRpaProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("inquireVO")
public class InquireVO {
	Integer inquireNum;
	String memberNum;
	String goodsNum;
	String inquireKind;
	String inquireSubject;
	String inquireContent;
	Date inquireRegiDate;
	String inquireAnswer; // 답변
	Date answerRegiDate;
	String empNum;
	
	String memberId;
	String goodsName;
}
