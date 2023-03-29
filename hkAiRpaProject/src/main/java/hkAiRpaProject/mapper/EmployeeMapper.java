package hkAiRpaProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.EmployeeVO;

@Repository("hkAiRpaProject.mapper.EmployeeMapper")
public interface EmployeeMapper {
	public Integer employeeInsert(EmployeeVO vo);
	public String autoNum();
	public List<EmployeeVO> employeeAllSelect();
	public EmployeeVO employeeOneSelect(String empNum);
}
