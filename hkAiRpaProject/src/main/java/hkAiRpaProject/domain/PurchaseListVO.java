package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data 
@Alias("purchaseListVO")
public class PurchaseListVO {
	String purchaseNum;
	String goodsNum;    /// cart
	Long purchaseQty;   /// cart
	Long purchasePrice; /// ipgo
	String [] goodsNums;
}
