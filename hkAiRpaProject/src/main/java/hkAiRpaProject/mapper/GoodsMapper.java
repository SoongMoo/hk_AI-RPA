package hkAiRpaProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hkAiRpaProject.domain.GoodsVO;

@Mapper
public interface GoodsMapper {
	public String goodAutoNum();
	public Integer goodsInsert(GoodsVO vo);
	public List<GoodsVO> goodsAllSeslect();
	public GoodsVO goodsItemSelect(String goodsNum);
	public Integer goodsUpdate(GoodsVO vo);
	public Integer goodsDelete(String goodsNum);
}