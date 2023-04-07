package hkAiRpaProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.domain.StartEndPageVO;

@Mapper
public interface GoodsMapper {
	public String goodAutoNum();
	public Integer goodsInsert(GoodsVO vo);
	public List<GoodsVO> goodsAllSeslect();
	public GoodsVO goodsItemSelect(String goodsNum);
	public Integer goodsUpdate(GoodsVO vo);
	public Integer goodsDelete(String goodsNum);
	public String goodIpgoAutoNum();
	public List<GoodsVO> selectItem(StartEndPageVO vo);
	public Integer goodsCount(String goodsWord);
}