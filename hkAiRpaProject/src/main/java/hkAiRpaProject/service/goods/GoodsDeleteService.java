package hkAiRpaProject.service.goods;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkAiRpaProject.domain.GoodsVO;
import hkAiRpaProject.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, HttpSession session) {
		GoodsVO vo = goodsMapper.goodsItemSelect(goodsNum);
		int i = goodsMapper.goodsDelete(goodsNum);
		System.out.println(i + "개행이(가) 삭제되었습니다.");
		
		if(i > 0) {
			String fileDir = "/view/goods/upload";
			String filePath = session.getServletContext().getRealPath(fileDir);
			String goodsMain =  vo.getGoodsMain();
			File file = new File(filePath +"/"+goodsMain);
			if(file.exists()) file.delete();
			
			
			if(vo.getGoodsImage() != null) {
				String [] fileNames = vo.getGoodsImage().split("-"); 
				for(String fileName : fileNames) {
					file = new File(filePath + "/" + fileName);
					if(file.exists()) file.delete();
				}
			}
		}
		
	}
}
