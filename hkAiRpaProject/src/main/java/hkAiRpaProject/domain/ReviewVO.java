package hkAiRpaProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("reviewVO")
public class ReviewVO {
	Long reviewNum;
	String goodsNum;
	Date reviewDate;
	String reviewContent;
	String purchaseNum;
	Long reviewScore;
	
	String memberId;
}