package hkAiRpaProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.domain.StartEndPageVO;
import hkAiRpaProject.mapper.GoodsMapper;
import hkAiRpaProject.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page , String goodsWord,  Model model, int limit1) {
		int limit = limit1;
		int limitPage = 10;
		StartEndPageVO startEndPageVO=  startEndPageService.execute(page, limit, limitPage, goodsWord);
		List<GoodsVO> list = goodsMapper.goodsAllSeslect(startEndPageVO);
		int count = goodsMapper.goodsCount(goodsWord);
		
		startEndPageService.execute(model, count, limit, page, limitPage, list); 
	}
}
