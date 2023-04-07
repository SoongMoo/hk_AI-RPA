package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("startEndPageVO")
public class StartEndPageVO {
	int startRow;
	int endRow;
	String goodsWord;
}
