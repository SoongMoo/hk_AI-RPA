package hkAiRpaProject.command;

import lombok.Data;

@Data
public class InquireCommand {
	String inquireNum;
	String goodsNum;
	String inquireKind;
	String inquireSubject;
	String inquireContent;
	String inquireAnswer;
	String memberNum;
}
