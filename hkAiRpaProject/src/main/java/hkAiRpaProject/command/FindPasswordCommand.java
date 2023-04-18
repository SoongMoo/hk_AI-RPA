package hkAiRpaProject.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FindPasswordCommand {
	@NotBlank(message = "아이디를 입력해주세요.")
	String userId;
	@NotBlank(message = "등록한 전화번호를 입력해주세요.")
	String userPhone;
}
