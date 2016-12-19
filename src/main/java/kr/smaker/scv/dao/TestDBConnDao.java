package kr.smaker.scv.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDBConnDao")
public class TestDBConnDao {

	@Autowired
	private SqlSession sqlSession;

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
	
	public String loadContents(String idx){
    	return sqlSession.selectOne("userMapper.loadContents", idx);
    }
	
}