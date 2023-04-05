package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.EmployeeVO;

@Repository("hkAiRpaProject.mapper.EmployeeShipMapper")
public interface EmployeeShipMapper {
	public EmployeeVO myInfoSelect(String userId);
}
