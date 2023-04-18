package hkAiRpaProject.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.PurchaseListPurchasePaymentGoodsVO;
import hkAiRpaProject.repository.PuchaseRepository;

@Service
public class PurchaseListService {
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(Model model) {
		List<PurchaseListPurchasePaymentGoodsVO> list =
				puchaseRepository.purchaseList(null);
		model.addAttribute("list", list);
	}
	public void execute(String purchaseNum) {
		puchaseRepository.purchaseStatus(purchaseNum);
	}
}
