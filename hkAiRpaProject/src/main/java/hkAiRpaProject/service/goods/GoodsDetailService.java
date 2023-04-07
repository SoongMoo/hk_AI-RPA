package hkAiRpaProject.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		GoodsVO vo = goodsMapper.goodsItemSelect(goodsNum);
		model.addAttribute("goodsCommand", vo);
		model.addAttribute("newLineChar", '\n'); // \n을 <br />로 변경하기 위해
	}
}
