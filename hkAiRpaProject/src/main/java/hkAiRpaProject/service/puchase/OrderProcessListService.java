package hkAiRpaProject.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.MemberNumReviewNumVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.domain.PurchaseListPurchasePaymentGoodsVO;
import hkAiRpaProject.domain.PurchaseVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import hkAiRpaProject.repository.PuchaseRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class OrderProcessListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(HttpSession session, Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		MemberNumReviewNumVO vo = new MemberNumReviewNumVO();
		vo.setMemberNum(mem.getMemberNum());
		List<PurchaseListPurchasePaymentGoodsVO> list =
				puchaseRepository.purchaseList(vo);
		model.addAttribute("list", list);
		
		
	}
}
