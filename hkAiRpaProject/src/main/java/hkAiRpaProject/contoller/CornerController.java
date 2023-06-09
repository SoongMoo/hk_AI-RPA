package hkAiRpaProject.contoller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkAiRpaProject.domain.AuthInfoVO;
import hkAiRpaProject.service.corner.GoodsCartAddService;
import hkAiRpaProject.service.corner.GoodsCartListServcice;
import hkAiRpaProject.service.corner.GoodsCartQtyDownService;
import hkAiRpaProject.service.corner.GoodsWishCheckService;
import hkAiRpaProject.service.corner.GoodsWishListService;
import hkAiRpaProject.service.corner.GoodsWishService;
import hkAiRpaProject.service.goods.IndexGoodsListService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("corner")
public class CornerController {

	@Autowired
	IndexGoodsListService indexGoodsListService;
	@Autowired
	GoodsWishCheckService goodsWishCheckService;
	@RequestMapping("prodInfo/{num}")
	public String prodInfo(
			@PathVariable(value="num") String goodsNum,Model model, HttpSession session) {
		indexGoodsListService.execute(goodsNum, model);
		goodsWishCheckService.execute(goodsNum, model, session);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/corner/prodInfo";
	}
	@Autowired
	GoodsWishService goodsWishService;
	@RequestMapping(value="goodsWishAdd", method=RequestMethod.POST)
	public @ResponseBody String goodsWishAdd(
			@RequestParam(value="goodsNum")String goodsNum,
			HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
	@Autowired
	GoodsWishListService goodsWishListService;
	@RequestMapping(value="wishList")
	public String wishList(HttpSession session,Model model) {
		goodsWishListService.execute(session, model);
		return "thymeleaf/corner/wishList";
	}
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@RequestMapping("goodsCartAdd")
	public @ResponseBody String goodsCartAdd(
			@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="qty") Integer qty,
			HttpSession session) {
		System.out.println("nsdbvsdbgv");
		return goodsCartAddService.execute(goodsNum, qty, session);
	}
	
	@Autowired
	GoodsCartListServcice goodsCartListServcice;
	@RequestMapping("goodsCartList")
	public String goodsCartList(Model model, HttpSession session) {
		goodsCartListServcice.execute(model, session);
		return "thymeleaf/corner/cartList";
	}
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@RequestMapping("goodsCartQtyDown")
	public @ResponseBody String goodsCartQtyDown(
			@RequestParam(value="goodsNum") String goodsNum,
			HttpSession session) {
		return goodsCartQtyDownService.execute(goodsNum, session);
	}
	@PostMapping("buyItem")
	public String buyItem(
			@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="qty") Integer qty,
			HttpSession session,HttpServletResponse response) {
		String i = goodsCartAddService.execute(goodsNum, qty, session);
		if(i.equals("999")) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String str = "<script>"
						+ "alert('관리자는 구매할 수 없습니다.');"
						+ "location.href='/corner/prodInfo/"+goodsNum+"';"
						+ "</script>";
				out.print(str);
				out.close();
			}catch(Exception e) {}
			return null;
		}
		return "redirect:/puchase/goodsBuy?prodCk="+goodsNum;
	}
	
	
	
	
	
	
	
	
	
}
