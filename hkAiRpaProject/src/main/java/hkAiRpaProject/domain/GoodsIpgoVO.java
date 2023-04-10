package hkAiRpaProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsIpgoVO")
public class GoodsIpgoVO {
	String goodsIpgoNum;
	String goodsNum;
	Integer ipgoQty;
	Date ipgoDate;
	Date madeDate;
	Integer goodsPrice;
	String empNum;
}