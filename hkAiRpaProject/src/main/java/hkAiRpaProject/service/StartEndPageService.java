package hkAiRpaProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.StartEndPageVO;
@Service
public class StartEndPageService {
	int stratRow;
	int endRow;
	String goodsWord;
	public StartEndPageVO execute(int page, int limit , int limitPage, String goodsWord) {
		// 1page = 1~ 10, 2page = 11~20 
		stratRow = (page - 1) *  limit + 1;// 5page
		endRow = stratRow + limit - 1;
		this.goodsWord = goodsWord;		
		StartEndPageVO vo = new StartEndPageVO();
		vo.setEndRow(endRow);
		vo.setGoodsWord(this.goodsWord);
		vo.setStartRow(stratRow);
		return vo;
	}
	public void execute(Model model, int count, int limit, int page, int limitPage, List list) {
		int maxPage = (int)((double)count / limit + 0.99);
		int startPage =  (int)((double) page / limitPage + 0.95 -1 ) * limitPage + 1;  // 2 , 3 : 1~10  , 14 : 11~20
		int endPage = startPage + limitPage - 1; // 10, 20, 30, 40
		if(maxPage < endPage) endPage = maxPage;
		
		model.addAttribute("list", list);
		model.addAttribute("goodsWord", goodsWord);
		model.addAttribute("page", page);
		model.addAttribute("stratRow", stratRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("count", count);
	}
}
