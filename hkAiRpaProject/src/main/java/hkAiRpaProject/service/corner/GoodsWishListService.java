package hkAiRpaProject.service.corner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.GoodsIpgoGoodsVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.domain.WishVO;
import hkAiRpaProject.mapper.CornerMapper;
import hkAiRpaProject.mapper.GoodsMapper;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWishListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		WishVO vo = new WishVO();
		vo.setMemberNum(mem.getMemberNum());
		List<GoodsIpgoGoodsVO> list = goodsMapper.goodsListselect(vo);
		model.addAttribute("list", list);
	}
}
