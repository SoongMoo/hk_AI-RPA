package hkAiRpaProject.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class GoodsIpgoCommand {
	String goodsIpgoNum;
	String goodsNum;
	Date ipgoDate;
	Integer ipgoQty;
	LocalDateTime madeDate;
	Integer goodsPrice;
}
/// html <==> command
/// table <===> vo/dto
/// command <===> vo : vo