package hkAiRpaProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeCommand {
	String empNum;
	
	String empId;
	
	String empPw;
	
	String empPwCon;
	
	String empName;
	
	String empAddr;
	String empAddr2;
	String empPost;
	String empGender;
	String empPhone;
	String empEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
