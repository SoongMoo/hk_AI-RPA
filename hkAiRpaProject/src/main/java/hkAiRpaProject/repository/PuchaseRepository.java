package hkAiRpaProject.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.PaymentVO;
import hkAiRpaProject.domain.PurchaseListPurchasePaymentGoodsVO;
import hkAiRpaProject.domain.PurchaseVO;
import hkAiRpaProject.domain.WishVO;

@Repository
public class PuchaseRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkAiRpaProject.repository.PuchaseRepository";
	String statement;
	public Integer selectNum() {
		statement = namespace + ".selectNum";
		return sqlSession.selectOne(statement);
	}
	public Integer purchaseInsert(PurchaseVO vo) {
		statement = namespace + ".purchaseInsert";
		return sqlSession.insert(statement, vo);
	}
	public Integer purchaseListInsert(PurchaseVO vo) {
		statement = namespace + ".purchaseListInsert";
		return sqlSession.insert(statement, vo);
	}
	public Integer cartItemDelete(WishVO vo) {
		statement = namespace + ".cartItemDelete";
		return sqlSession.delete(statement, vo);
	}
	public List<PurchaseListPurchasePaymentGoodsVO> purchaseList(String memberNum) {
		statement = namespace + ".purchaseList";
		return sqlSession.selectList(statement, memberNum);
	}
	public PurchaseVO purchaseSelect(String purchaseNum) {
		statement = namespace + ".purchaseSelect";
		return sqlSession.selectOne(statement, purchaseNum);
	}
	public Integer paymentInsert(PaymentVO vo) {
		statement = namespace + ".paymentInsert";
		return sqlSession.insert(statement, vo);
	}
}
