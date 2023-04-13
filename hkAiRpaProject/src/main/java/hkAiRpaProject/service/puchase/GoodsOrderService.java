package hkAiRpaProject.service.puchase;

import java.util.Date;

import org.python.icu.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.command.PurchaseCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.domain.PurchaseVO;
import hkAiRpaProject.domain.WishVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import hkAiRpaProject.repository.PuchaseRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsOrderService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PuchaseRepository puchaseRepository;
	public String execute(PurchaseCommand purchaseCommand,HttpSession session,Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		Integer num = puchaseRepository.selectNum();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		String purchaseNum = df.format(new Date()) + num; /// 2023040510001
		System.out.println(purchaseNum);

		String goodsNums [] =  purchaseCommand.getGoodsNums().split("-");
		String purchaseName = goodsNums[0] + "외 " + Integer.toString(goodsNums.length - 1)+"개";
		
		PurchaseVO vo = new PurchaseVO();
		vo.setMemberNum(mem.getMemberNum());
		vo.setPurchaseAddr(purchaseCommand.getPurchaseAddr());
		vo.setPurchaseAddr2(purchaseCommand.getPurchaseAddr2());
		vo.setPurchaseMessage(purchaseCommand.getMessage());
		vo.setPurchaseName(purchaseCommand.getRecieveName());
		vo.setPurchaseNum(purchaseNum);
		System.out.println("vo.getPurchaseNum() : " + vo.getPurchaseNum());
		vo.setPurchasePhone(purchaseCommand.getPurchasePhone());
		vo.setPurchasePost(purchaseCommand.getPurchasePost());
		vo.setPurchasePrice(purchaseCommand.getTotalPrice());	
		int i = puchaseRepository.purchaseInsert(vo);
		if (i > 0) {
			vo.setGoodsNums(goodsNums);
			i = puchaseRepository.purchaseListInsert(vo);
			if(i > 0) {
				WishVO wishVO = new WishVO();
				wishVO.setMemberNum(mem.getMemberNum());
				wishVO.setGoodsNums(goodsNums);
				puchaseRepository.cartItemDelete(wishVO);
			}
		}
		return purchaseNum;
	}
}
