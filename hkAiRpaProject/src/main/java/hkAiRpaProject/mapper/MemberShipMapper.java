package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.MemberVO;

@Repository("hkAiRpaProject.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public Integer MemberShipInsert(MemberVO vo);
	public Integer memberCkeckUpdate(String email);
}
