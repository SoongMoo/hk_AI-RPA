package hkAiRpaProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.MemberVO;

@Repository("hkAiRpaProject.mapper.MemberMapper")
public interface MemberMapper {
	public Integer memberInsert(MemberVO vo);
	public String autoNum();
	public List<MemberVO> memberAllSelect();
}
