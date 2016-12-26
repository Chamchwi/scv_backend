package kr.smaker.scv.manager;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void register(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.selectList("userMapper.register", map);
	}

	public void refreshRoom(HashMap<String, Object> map) {
		sqlSession.selectList("userMapper.refreshRoom", map);
	}

	public void getVersion() {
		sqlSession.selectList("userMapper.getversion");
	}

	public String loadContents(String idx) {
		return sqlSession.selectOne("userMapper.loadContents", idx);
	}
}
