package hkAiRpaProject.service.corner;

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
public class GoodsCartListServcice {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerMapper cornerMapper;
	public void execute(Model model , HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		WishVO vo = new WishVO(); // goodsNums때문에
		vo.setMemberNum(mem.getMemberNum());
		List<CartGoodsIpgoGoodsVO> list = cornerMapper.cartList(vo);
		model.addAttribute("list", list);
	}
}
