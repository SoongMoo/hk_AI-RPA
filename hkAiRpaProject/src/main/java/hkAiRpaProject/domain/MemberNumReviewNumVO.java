package hkAiRpaProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("memberNumReviewNumVO")
public class MemberNumReviewNumVO {
	String reviewNum;
	String memberNum;
}
