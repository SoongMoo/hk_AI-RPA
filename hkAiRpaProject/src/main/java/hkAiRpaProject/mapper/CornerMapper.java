package hkAiRpaProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.CartGoodsIpgoGoodsVO;
import hkAiRpaProject.domain.CartVO;
import hkAiRpaProject.domain.WishVO;

@Repository("hkAiRpaProject.mapper.CornerMapper")
public interface CornerMapper {
	public Integer wishAdd(WishVO vo);
	public String wishCount(WishVO vo);
	public Integer cartAdd(CartVO vo);
	public List<CartGoodsIpgoGoodsVO> cartList(WishVO vo);
	public Integer goodsCartQtyDown(CartVO vo);
}
