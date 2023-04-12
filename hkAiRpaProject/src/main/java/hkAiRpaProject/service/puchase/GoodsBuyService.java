package hkAiRpaProject.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.CartGoodsIpgoGoodsVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.domain.WishVO;
import hkAiRpaProject.mapper.CornerMapper;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsBuyService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerMapper cornerMapper;
	public void execute(String [] prodCk, HttpSession session, Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		WishVO vo = new WishVO();
		vo.setMemberNum(mem.getMemberNum());
		vo.setGoodsNums(prodCk);
		List<CartGoodsIpgoGoodsVO> list  = cornerMapper.cartList(vo);
		//System.out.println(list.size());
		Long goodsPriceTotal = 0L;
		Long deliveryCostTotal = 0L;
		String goodsNums = "";
		for( CartGoodsIpgoGoodsVO dto : list) {
			goodsPriceTotal += dto.getGoodsIpgoGoodsVO().getGoodsIpgoVO().getGoodsPrice()
					         * dto.getCartVO().getCartQty();
			deliveryCostTotal += dto.getGoodsIpgoGoodsVO().getGoodsVO().getDeliveryCost();
			goodsNums += dto.getGoodsIpgoGoodsVO().getGoodsVO().getGoodsNum() +"-";
		}
		Long totalPrice = goodsPriceTotal + deliveryCostTotal;
		model.addAttribute("list", list);
		model.addAttribute("goodsPriceTotal", goodsPriceTotal);
		model.addAttribute("deliveryCostTotal", deliveryCostTotal);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("goodsNums", goodsNums);
		
	}
}
