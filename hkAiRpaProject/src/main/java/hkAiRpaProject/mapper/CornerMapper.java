package hkAiRpaProject.mapper;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.WishVO;

@Repository("hkAiRpaProject.mapper.CornerMapper")
public interface CornerMapper {
	public Integer wishAdd(WishVO vo);
	public String wishCount(WishVO vo);
}
