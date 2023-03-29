package hkAiRpaProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("empVO")
public class EmployeeVO {
	String empNum;
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empAddr2;
	String empPost;
	String empGender;
	String empPhone;
	String empEmail;
	Date empBirth;
	Date empRegiDate;
	
	public Date getEmpRegiDate() {
		return empRegiDate;
	}
	public void setEmpRegiDate(Date empRegiDate) {
		this.empRegiDate = empRegiDate;
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
