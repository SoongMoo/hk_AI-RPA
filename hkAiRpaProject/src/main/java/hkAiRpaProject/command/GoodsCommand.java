package hkAiRpaProject.command;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	@NotBlank(message = "상품명을 입력해주세요.")
	String goodsName;
	@NotBlank(message = "상품내용을 입력해주세요.")
	String goodsContent;
	@NotNull(message = "상품금액을 입력해주세요.")
	Integer deliveryCost;
	@NotBlank(message = "제조사를 입력해주세요.")
	String manufacturer;
	String empNum;

	MultipartFile goodsMain;
	MultipartFile goodsImage [] ;

}
