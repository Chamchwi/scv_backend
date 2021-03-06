package kr.smaker.scv.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	/*
	 *  		User Query
	 */

	public void normal_register(HashMap<String, Object> map) throws Exception {
		sqlSession.insert("userMapper.normal_register", map);
	}

	public void fb_register(HashMap<String, Object> map) throws Exception {
		sqlSession.insert("userMapper.fb_register", map);
	}

	public String getVersion() throws Exception {
		return sqlSession.selectOne("userMapper.getVersion");
	}

	public HashMap<String, Object> loginRequest(String param) throws Exception {
		return sqlSession.selectOne("userMapper.loginRequest", param);
	}
	
	public void createRoom(HashMap<String, Object> map) throws Exception {
		sqlSession.insert("userMapper.createRoom", map);
	}
	
	public int getRoomid(String param) throws Exception {
		return sqlSession.selectOne("userMapper.getRoomid", param);
	}
	
	public String getScore(String param) throws Exception {
		return sqlSession.selectOne("userMapper.getScore", param);
	}
	
	public List<HashMap<String, Object>> getRoomData() throws Exception {
		return sqlSession.selectList("userMapper.getRoomData");
	}

	/*
	 *  		Admin Query
	 */

	public List<Map<String, Object>> getAllMember(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("userMapper.getAllMember", map);
	}

}
