package hkAiRpaProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MemberCommand {
	String memberNum;
	@NotBlank(message = "아이디를 입력해주세요. ")
	@Size(min= 8, max = 12)
	String memberId;
	@Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-+]).{8,}$",
			 message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String memberPw;
	@NotBlank(message = "비밀번호확인 입력하여 주세요.")
	String memberPwCon;
	@NotBlank(message = "이름을 입력하여 주세요.")
	String memberName;
	@NotBlank(message = "주소를 입력하여 주세요.")
	String memberAddr;
	String memberAddr2;
	String memberPost;
	@NotBlank(message = "성별을 선택하여 주세요.")
	String memberGender;
	@NotBlank(message = "연락처을 입력하여 주세요.")
	String memberPhone;
	@Email(message = "형식에 맞지 않습니다.")
	@NotBlank(message = "이메일을 입력하여 주세요.")
	String memberEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "날짜를 입력하여 주세요.")
	Date memberBirth;
	
	public boolean isMemberPwEqualsMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
	
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberNum() {
		return this.memberNum;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberId() {
		return this.memberId;
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPwCon() {
		return memberPwCon;
	}
	public void setMemberPwCon(String memberPwCon) {
		this.memberPwCon = memberPwCon;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public String getMemberPost() {
		return memberPost;
	}
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	
}
