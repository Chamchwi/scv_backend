package kr.smaker.scv.manager;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void normal_register(HashMap<String, Object> map) throws Exception {
    	sqlSession.insert("userMapper.normal_register", map);
    }
	
	public void fb_register(HashMap<String, Object> map) throws Exception {
    	sqlSession.insert("userMapper.fb_register", map);
    }
	
	public String getVersion() throws Exception {
		return sqlSession.selectOne("userMapper.getVersion");
	}
}
