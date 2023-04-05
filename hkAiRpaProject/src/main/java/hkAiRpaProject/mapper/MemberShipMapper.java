package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.MemberVO;

@Repository("hkAiRpaProject.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public Integer MemberShipInsert(MemberVO vo);
	public Integer memberCkeckUpdate(String email);
	public MemberVO myInfoSelect(String userId);
	public String memberPwSelect(String memberId);
	public Integer myInfoUpdate(MemberVO vo);
	public Integer myDelete(String userId);
	public Integer myPassUpdate(MemberVO vo);
}
