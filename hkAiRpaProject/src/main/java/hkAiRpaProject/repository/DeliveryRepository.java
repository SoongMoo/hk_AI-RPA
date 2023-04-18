package hkAiRpaProject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.DeliveryVO;

@Repository
public class DeliveryRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkAiRpaProject.repository.DeliveryRepository";
	String statement;
	public Integer delveryInsert(DeliveryVO vo) {
		statement = namespace + ".delveryInsert";
		return sqlSession.insert(statement,vo);
	}
	public Integer deliveryDelete(String purchaseNum) {
		statement = namespace + ".deliveryDelete";
		return sqlSession.delete(statement,purchaseNum);
	}
}
