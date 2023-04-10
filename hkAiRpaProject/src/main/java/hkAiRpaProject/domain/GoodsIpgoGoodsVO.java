package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsIpgoGoodsVO")
public class GoodsIpgoGoodsVO {
	GoodsIpgoVO goodsIpgoVO; // 1
	GoodsVO goodsVO;         // 1
}
