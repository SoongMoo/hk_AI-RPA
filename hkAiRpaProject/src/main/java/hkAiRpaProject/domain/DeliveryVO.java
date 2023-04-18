package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("deliveryVO")
public class DeliveryVO {
	String purchaseNum;
	String deliveryNumber;
	String deliveryCompany;
}
