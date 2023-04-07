package hkAiRpaProject.service.goods;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import hkAiRpaProject.command.FileInfoCommand;
import hkAiRpaProject.command.GoodsCommand;
import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.domain.EmployeeVO;
import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.mapper.EmployeeMapper;
import hkAiRpaProject.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session, BindingResult result, Model model) {
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("authInfo");
		EmployeeVO emp = employeeMapper.employeeOneSelect(authInfo.getUserId());
		
		GoodsVO vo = new GoodsVO();
		vo.setDeliveryCost(goodsCommand.getDeliveryCost());
		vo.setEmpNum(emp.getEmpNum());
		vo.setGoodsContent(goodsCommand.getGoodsContent());
		vo.setGoodsName(goodsCommand.getGoodsName());
		vo.setGoodsNum(goodsCommand.getGoodsNum());
		vo.setManufacturer(goodsCommand.getManufacturer());
		
		// 파일정보 update하기 위해 파일정보를 디비로부터 가지고 옴
		GoodsVO vo1 = goodsMapper.goodsItemSelect(goodsCommand.getGoodsNum());
		//// 파일 추가 
		String fileDir = "/view/goods/upload";
		String filePath=session.getServletContext().getRealPath(fileDir);
		
		List<FileInfoCommand> list = (List<FileInfoCommand>)session.getAttribute("fileList");
		///메인 이미지
		if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
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
		}else {
			if(list != null) {
				for(FileInfoCommand command : list) {
					if(vo1.getGoodsMain().equals(command.getStoreFile())) {
						result.rejectValue("goodsMain", "goodsCommand.goodsMain", "대문이미지를 선택해주세요.");
						model.addAttribute("goodsCommand", vo1);
						session.removeAttribute("fileList");
						return;
					}
				}
			}
		}
		
		//// 이미지
		List<String> goodsImages = new ArrayList<String>();
		List<String> goodsOrgImages= new ArrayList<String>();
		if(vo1.getGoodsImage() != null) {
			String [] images = vo1.getGoodsImage().split("-");
			String [] orgImages = vo1.getGoodsImageOrg().split("-");
			for(String img : images) {
				goodsImages.add(img);
			}
			for(String img : orgImages) {
				goodsOrgImages.add(img);
			}

			//// list에 있는 정보에서 session에 있는 정보를 먼저 삭제
			if(list != null) {
				for(FileInfoCommand command : list) {
					for(String str : goodsImages) {
						if(str.equals(command.getStoreFile())) {
							goodsImages.remove(command.getStoreFile());
							goodsOrgImages.remove(command.getOrgFile());
							break;
						}
					}
				}
			}
		}
		//// 이미지 파일 추가
		String originalTotal = ""; 
		String storeTotal = "";
		if(!goodsCommand.getGoodsImage()[0].getOriginalFilename().isEmpty()) {
			for( MultipartFile mf1  :  goodsCommand.getGoodsImage()) {
				String originalFile = mf1.getOriginalFilename(); ///a.b.c.d.hwp
				String extension = originalFile.substring(originalFile.lastIndexOf(".")) ; //".hwp"
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = storeName +  extension; /// busabfusaf7420974.hwp
				
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf1.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				originalTotal += originalFile +"-"; 
				storeTotal += storeFileName +"-";
			}
		}
		if(vo1.getGoodsImage() != null) {
			for(String img : goodsImages) {
				storeTotal += img + "-";
			}
			for(String img : goodsOrgImages) {
				originalTotal += img + "-";
			}
		}
		vo.setGoodsImageOrg(originalTotal);
		vo.setGoodsImage(storeTotal);
		int i = goodsMapper.goodsUpdate(vo);
		/// session에 있는 파일을 삭제
		if(i > 0) {
			if(list != null) {
				for(FileInfoCommand command : list) {
					File file = new File(filePath +"/"+ command.getStoreFile());
					if(file.exists()) file.delete();
				}
			}
		}
		session.removeAttribute("fileList");
	}
}
