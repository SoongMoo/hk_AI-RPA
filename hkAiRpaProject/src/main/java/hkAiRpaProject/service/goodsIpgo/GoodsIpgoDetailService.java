package hkAiRpaProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsIpgoGoodsVO;
import hkAiRpaProject.domain.GoodsIpgoVO;
import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class GoodsIpgoDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsIpgoNum, Model model) {
		/*
		 * GoodsVo goodsVO = goodsMapper.goodsItemSelect(goodsNum);
		   GoodsIpgoVO goodsIpgoVO = goodsMapper.goodsIpgoSelect(goodsIpgoNum);
		 */
		GoodsIpgoGoodsVO vo = goodsMapper.goodsIpgoGoodsSelect(goodsIpgoNum);
		
		model.addAttribute("goodsIpgoGoodsCommand", vo);
	}
}
