package hkAiRpaProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsIpgoGoodsVO;
import hkAiRpaProject.domain.WishVO;
import hkAiRpaProject.mapper.CornerMapper;
import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class IndexGoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	CornerMapper cornerMapper;
	public void execute(String goodsNum, Model model) {
		WishVO vo = new WishVO();
		vo.setGoodsNum(goodsNum);
		List<GoodsIpgoGoodsVO> list = goodsMapper.goodsListselect(vo);
		model.addAttribute("list", list);
	}
}
