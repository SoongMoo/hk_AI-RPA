package hkAiRpaProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.command.GoodsIpgoCommand;
import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class GoodsIpgoAutoNumservice {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		String goodsIpgoNum = goodsMapper.goodIpgoAutoNum();
		GoodsIpgoCommand command  = new GoodsIpgoCommand();
		command.setGoodsIpgoNum(goodsIpgoNum);
		model.addAttribute("command", command);
	}
}
