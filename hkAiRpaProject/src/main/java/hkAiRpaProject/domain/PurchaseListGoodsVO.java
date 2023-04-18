package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseListGoodsVO")
public class PurchaseListGoodsVO {
	PurchaseListVO purchaseListVO;
	GoodsVO goodsVO;
}
