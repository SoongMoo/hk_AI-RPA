package hkAiRpaProject.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkAiRpaProject.domain.DeliveryVO;
import hkAiRpaProject.repository.DeliveryRepository;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("delivery")
public class DeliveryController {
	@Autowired
	DeliveryRepository deliveryRepository;
	@RequestMapping("deliveryAction")
	public void deliveryAction(DeliveryVO vo, HttpServletResponse response) {
		deliveryRepository.delveryInsert(vo);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "<script>"
				+ "opener.location.reload();"
				+ "window.self.close();"
				+ " </script>";
		out.print(str);
		out.close();
	}
	@RequestMapping("deliveryDel")
	public void deliveryDel(
			@RequestParam(value="purchaseNum") String purchaseNum
			,HttpServletResponse response) {
		deliveryRepository.deliveryDelete(purchaseNum);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "<script>"
				+ " opener.location.reload();"
				+ " window.self.close();"
				+ " </script>";
		out.print(str);
	}
}
