package hkAiRpaProject.service.corner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.CartVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.CornerMapper;
import hkAiRpaProject.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsCartQtyDownService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerMapper cornerMapper;
	public String execute(String goodsNum, HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		CartVO vo = new CartVO();
		vo.setGoodsNum(goodsNum);
		vo.setMemberNum(mem.getMemberNum());
		return cornerMapper.goodsCartQtyDown(vo).toString();
	}
}
