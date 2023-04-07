package hkAiRpaProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsVO")
public class GoodsVO {
	String goodsNum;
	String goodsName;
	String goodsContent;
	String goodsMain;
	String goodsMainOrg;
	String goodsImage;
	String goodsImageOrg;
	Integer deliveryCost;
	String manufacturer;
	Integer visitCount;
	String empNum;
	Date regiDate;
	String updateEmpNum;
	Date updateRegiDate;
}