package hkAiRpaProject.command;

import lombok.Data;

@Data
public class PurchaseCommand {
	String recieveName;
	String purchaseAddr;
	String purchasePhone;
	String purchaseAddr2;
	String purchasePost;
	String message;
	String goodsNums;
	Long totalPrice;
}
