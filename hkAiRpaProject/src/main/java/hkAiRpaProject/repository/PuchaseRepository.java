package hkAiRpaProject.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
