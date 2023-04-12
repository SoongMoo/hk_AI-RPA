package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cartGoodsIpgoGoodsVO")
public class CartGoodsIpgoGoodsVO {
	GoodsIpgoGoodsVO goodsIpgoGoodsVO;
	CartVO cartVO;
}
