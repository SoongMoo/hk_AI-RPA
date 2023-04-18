package hkAiRpaProject.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkAiRpaProject.domain.PurchaseDetailVO;
import hkAiRpaProject.repository.PuchaseRepository;

@Service
public class PurchaseDetailService {
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(String purchaseNum, Model model) {
		List<PurchaseDetailVO> list = 
				puchaseRepository.purchaseDetail(purchaseNum);
		model.addAttribute("list", list);
	}
}