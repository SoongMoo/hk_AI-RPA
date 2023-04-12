package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("cartVO")
public class CartVO {
	String memberNum;
	String goodsNum;
	Integer cartQty;
}
