package hkAiRpaProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		List<GoodsVO> list = goodsMapper.goodsAllSeslect();
		model.addAttribute("list", list);
	}
}
