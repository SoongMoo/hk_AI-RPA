package hkAiRpaProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseVO")
public class PurchaseVO {
	String purchaseNum;
	Date purchaseDate;
	String purchaseName;
	String purchasePhone;
	String purchaseAddr;
	String purchaseAddr2;
	String purchasePost;
	String purchaseMessage;
	String purchaseStatus;
	String memberNum;
	Long purchasePrice;
	
	String [] goodsNums;
}
