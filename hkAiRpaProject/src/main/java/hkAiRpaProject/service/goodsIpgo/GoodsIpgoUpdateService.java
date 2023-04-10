package hkAiRpaProject.service.goodsIpgo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.command.GoodsIpgoCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.domain.GoodsIpgoVO;
import hkAiRpaProject.mapper.EmployeeShipMapper;
import hkAiRpaProject.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsIpgoUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	EmployeeShipMapper employeeShipMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand, HttpSession session) {
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("authInfo");
		EmployeeVO emp = employeeShipMapper.myInfoSelect(authInfo.getUserId());
		GoodsIpgoVO vo = new GoodsIpgoVO();
		vo.setEmpNum(emp.getEmpNum());
		vo.setGoodsIpgoNum(goodsIpgoCommand.getGoodsIpgoNum());
		vo.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		vo.setGoodsPrice(goodsIpgoCommand.getGoodsPrice());
		vo.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		vo.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		vo.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
		int i = goodsMapper.goodsIpgoUpdate(vo);
		System.out.println(i + "개행이(가) 삽입되었습니다.");
	
	}
}
