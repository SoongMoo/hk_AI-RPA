package hkAiRpaProject.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseListPurchasePaymentGoodsVO")
public class PurchaseListPurchasePaymentGoodsVO {
	PurchaseVO purchaseVO;         // 1
	PurchaseListVO purchaseListVO; // 1
	PaymentVO paymentVO;           // 1
	List<GoodsVO> goodsVOs;        // n
}
