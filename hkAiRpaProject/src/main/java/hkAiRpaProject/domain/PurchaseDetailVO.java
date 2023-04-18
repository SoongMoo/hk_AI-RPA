package hkAiRpaProject.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseDetailVO")
public class PurchaseDetailVO {
	PurchaseVO purchaseVO;
	PaymentVO paymentVO;
	DeliveryVO deliveryVO;
	List<PurchaseListGoodsVO> purchaseListGoodsVOs;
}
