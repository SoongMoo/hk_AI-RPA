package hkAiRpaProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hkAiRpaProject.domain.GoodsIpgoGoodsVO;
import hkAiRpaProject.domain.GoodsIpgoVO;
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
	public Integer goodsIpgoInsert(GoodsIpgoVO goodsIpgoVO);
	public List<GoodsIpgoVO> goodsIpgoAllSelect();
	public GoodsIpgoVO goodsIpgoSelect(String goodsIpgoNum);
	public GoodsIpgoGoodsVO goodsIpgoGoodsSelect(String goodsIpgoNum);
	public Integer  goodsIpgoUpdate(GoodsIpgoVO goodsIpgoVO);
	public Integer goodsIpgoDelete(String goodsIpgoNum);
}