package kr.smaker.scv.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.smaker.scv.service.TestService;

import kr.smaker.scv.dao.TestDBConnDao;


@Service("testService")
public class TestServiceImpl implements TestService {
	
    @Resource(name="testDBConnDao")
    private TestDBConnDao testDBConnDao;
	
	public void register(HashMap<String, Object> map) {
		testDBConnDao.register(map);
	}
	
	public void refreshRoom(HashMap<String, Object> map) throws Exception {
		testDBConnDao.refreshRoom(map);
	}
	
	public void getVersion() throws Exception {
		testDBConnDao.getVersion();
	}
	
	public String loadContents(String idx) {
		return testDBConnDao.loadContents(idx);
	}
	

}
