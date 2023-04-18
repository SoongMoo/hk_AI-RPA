package hkAiRpaProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkAiRpaProject.domain.FindIdPasswordVO;

@Mapper
public interface FindMapper {
	public FindIdPasswordVO findId(String userPhone);
	public Integer userPwUpdate(FindIdPasswordVO vo);
}
