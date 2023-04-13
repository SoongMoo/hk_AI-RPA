package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paymentVO")
public class PaymentVO {
	String purchaseNum;
	String confirmNumber;
}
