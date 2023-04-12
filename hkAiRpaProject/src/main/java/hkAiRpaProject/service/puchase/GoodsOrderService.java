package hkAiRpaProject.service.puchase;

import java.util.Date;

import org.python.icu.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.command.PurchaseCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.MemberVO;
import hkAiRpaProject.mapper.MemberShipMapper;
import hkAiRpaProject.repository.PuchaseRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsOrderService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(PurchaseCommand purchaseCommand,HttpSession session,Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		MemberVO mem = memberShipMapper.myInfoSelect(authInfo.getUserId());
		Integer num = puchaseRepository.selectNum();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String purchaseNum = df.format(new Date()) + num;
		System.out.println(purchaseNum);
	}
}
