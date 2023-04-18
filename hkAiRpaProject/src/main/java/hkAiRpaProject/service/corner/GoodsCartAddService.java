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
public class GoodsCartAddService {
	
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerMapper cornerMapper;
	public String execute(String goodsNum, int qty, HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		if(authInfo.getGrade().equals("mem")) {
			MemberVO mem =  memberShipMapper.myInfoSelect(authInfo.getUserId());
			
			CartVO vo = new CartVO();
			vo.setCartQty(qty);
			vo.setGoodsNum(goodsNum);
			vo.setMemberNum(mem.getMemberNum());
			
			return cornerMapper.cartAdd(vo).toString(); 
		}else {
			return "999";
		}
		//wrapper : Integer, Long, Double,Float, String :  null, 형변환을 쉽게
	}
}
