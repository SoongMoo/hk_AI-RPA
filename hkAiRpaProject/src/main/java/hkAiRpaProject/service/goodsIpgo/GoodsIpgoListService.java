package hkAiRpaProject.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsIpgoVO;
import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class GoodsIpgoListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		List<GoodsIpgoVO> list = goodsMapper.goodsIpgoAllSelect();
		model.addAttribute("list", list);
	}
}
