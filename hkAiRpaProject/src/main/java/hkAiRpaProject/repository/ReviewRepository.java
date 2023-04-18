package hkAiRpaProject.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.ReviewVO;

@Repository
public class ReviewRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "ReviewRepository";
	String statement;
	public Integer reviewWrite(ReviewVO vo) {
		statement = namespace + ".reviewWrite";
		return sqlSession.insert(statement, vo) ;
	}
	public Integer reviewUpdate(ReviewVO vo) {
		statement = namespace + ".reviewUpdate";
		return sqlSession.update(statement, vo) ;
	}
	public Integer reviewDelete(String reviewNum) {
		statement = namespace + ".reviewDelete";
		return sqlSession.delete(statement, reviewNum) ;
	}
	public List<ReviewVO> goodsReviewList(String goodsNum){
		statement = namespace + ".goodsReviewList";
		return sqlSession.selectList(statement, goodsNum) ;
	}
}
