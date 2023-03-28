package hkAiRpaProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeCommand {
	String empNum;
	@Size(min = 4, max = 12,message = "아이디는 4자에서 12자사이로 입력하여 주세요!")
	String empId;
	@NotEmpty(message = "비밀번호를 입력해주세요!")
	@Size(min = 3, max = 12)
	String empPw;
	@NotBlank(message = "비밀번호확인을 입력해주세요!")
	@Size(min = 3, max = 12)
	String empPwCon;
	@NotEmpty(message = "이름을 입력해주세요!")
	String empName;
	@NotEmpty(message = "주소를 입력해주세요!")
	String empAddr;
	@NotEmpty(message = "전화번호를 입력해주세요!")
	String empAddr2;
	String empPost;
	String empGender;
	String empPhone;
	@NotBlank(message = "이메일을 입력해주세요!")
	String empEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "날짜를 입력하여 주세요.")
	Date empBirth;
	
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}


	public String getEmpNum() {
		return empNum;
	}


	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpPw() {
		return empPw;
	}


	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}


	public String getEmpPwCon() {
		return empPwCon;
	}


	public void setEmpPwCon(String empPwCon) {
		this.empPwCon = empPwCon;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpAddr() {
		return empAddr;
	}


	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}


	public String getEmpAddr2() {
		return empAddr2;
	}


	public void setEmpAddr2(String empAddr2) {
		this.empAddr2 = empAddr2;
	}


	public String getEmpPost() {
		return empPost;
	}


	public void setEmpPost(String empPost) {
		this.empPost = empPost;
	}


	public String getEmpGender() {
		return empGender;
	}


	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}


	public String getEmpPhone() {
		return empPhone;
	}


	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public Date getEmpBirth() {
		return empBirth;
	}


	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}



}
