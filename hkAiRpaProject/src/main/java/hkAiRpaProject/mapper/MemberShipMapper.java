package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.MemberVO;

@Repository("hkAiRpaProject.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public Integer memberJoinInsert(MemberVO vo);
	public Integer memberMailOk(String recieve);
}
