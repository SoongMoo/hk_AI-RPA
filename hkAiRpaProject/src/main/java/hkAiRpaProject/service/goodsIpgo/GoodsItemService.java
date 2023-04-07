package hkAiRpaProject.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.mapper.GoodsMapper;
import hkAiRpaProject.service.StartEndPageService;

@Service
public class GoodsItemService {
	@Autowired
	GoodsMapper goodsMapper;  
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(String goodsWord, Model model, int page) {
		int limit = 2;
		int limitPage = 10; 
		
		List<GoodsVO> list = goodsMapper.selectItem(startEndPageService.execute(page, limit, limitPage, goodsWord));
		int count = goodsMapper.goodsCount(goodsWord);
		
		startEndPageService.execute(model, count, limit, page, limitPage, list);
	}
}
