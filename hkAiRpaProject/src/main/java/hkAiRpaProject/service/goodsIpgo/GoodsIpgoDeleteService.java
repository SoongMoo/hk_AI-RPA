package hkAiRpaProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.mapper.GoodsMapper;

@Service
public class GoodsIpgoDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsIpgoNum) {
		int i = goodsMapper.goodsIpgoDelete(goodsIpgoNum);
		System.out.println(i + "개 행이(가) 삭제되었습니다.");
	}
}
