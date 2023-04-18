package hkAiRpaProject.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkAiRpaProject.domain.InquireVO;

@Repository
public class InquireRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "InquireRepository";
	String statement;
	public List<InquireVO> inquireList(InquireVO vo) {
		statement = namespace + ".inquireList";
		return sqlSession.selectList(statement, vo);
	}
	public Integer inquireInsert(InquireVO vo) {
		statement = namespace + ".inquireInsert";
		return sqlSession.insert(statement, vo);
	}
	public Integer inquireAnswerUpdate(InquireVO vo) {
		statement = namespace + ".inquireAnswerUpdate";
		return sqlSession.update(statement, vo);
	}
	public Integer inquireUpdate(InquireVO vo) {
		statement = namespace + ".inquireUpdate";
		return sqlSession.update(statement, vo);
	}
	public Integer inquireDelete(String inquireNum) {
		statement = namespace + ".inquireDelete";
		return sqlSession.delete(statement, inquireNum);
	}
}
