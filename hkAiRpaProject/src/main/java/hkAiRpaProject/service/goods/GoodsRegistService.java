package hkAiRpaProject.service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import hkAiRpaProject.command.GoodsCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.mapper.EmployeeMapper;
import hkAiRpaProject.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsRegistService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		GoodsVO vo = new GoodsVO();
		vo.setDeliveryCost(goodsCommand.getDeliveryCost());
		vo.setEmpNum(goodsCommand.getEmpNum());
		vo.setGoodsContent(goodsCommand.getGoodsContent());
		vo.setGoodsName(goodsCommand.getGoodsName());
		vo.setGoodsNum(goodsCommand.getGoodsNum());
		vo.setManufacturer(goodsCommand.getManufacturer());
		
		/////////////////////////////////////////////////////////////////////////
		///// 파일정보
		/// 파일 업로드 하기 위한 경로
		String fileDir = "/view/goods/upload";
		String filePath = session.getServletContext().getRealPath(fileDir);
		System.out.println(filePath);
		
		/// 파일 업로드
		MultipartFile mf = goodsCommand.getGoodsMain();
		String originalFile = mf.getOriginalFilename(); ///a.b.c.d.hwp
		String extension = originalFile.substring(originalFile.lastIndexOf(".")) ; //".hwp"
		String storeName = UUID.randomUUID().toString().replace("-", "");
		String storeFileName = storeName +  extension; /// busabfusaf7420974.hwp
		
		File file = new File(filePath + "/" + storeFileName);
		
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		vo.setGoodsMain(storeFileName);
		vo.setGoodsMainOrg(originalFile);
		
		if(!goodsCommand.getGoodsImage()[0].getOriginalFilename().isEmpty()) {
			String originalTotal = ""; 
			String storeTotal = "";
			for( MultipartFile mf1  :  goodsCommand.getGoodsImage()) {
				originalFile = mf1.getOriginalFilename(); ///a.b.c.d.hwp
				extension = originalFile.substring(originalFile.lastIndexOf(".")) ; //".hwp"
				storeName = UUID.randomUUID().toString().replace("-", "");
				storeFileName = storeName +  extension; /// busabfusaf7420974.hwp
				
				file = new File(filePath + "/" + storeFileName);
				try {
					mf1.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				originalTotal += originalFile +"-"; 
				storeTotal += storeFileName +"-";
			}
			vo.setGoodsImage(storeTotal);
			vo.setGoodsImageOrg(originalTotal);
		}
		goodsMapper.goodsInsert(vo);
	}
	
	public void execute(HttpSession session , Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		EmployeeVO emp = employeeMapper.employeeOneSelect(authInfo.getUserId());
		String goodsNum = goodsMapper.goodAutoNum();
		GoodsVO vo = new GoodsVO();
		vo.setGoodsNum(goodsNum);
		vo.setEmpNum(emp.getEmpNum());
		model.addAttribute("goodsCommand", vo);
	}
}
