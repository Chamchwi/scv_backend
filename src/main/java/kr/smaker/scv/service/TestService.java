package kr.smaker.scv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TestService {
	public void register(HashMap<String, Object> map) throws Exception;
	public void refreshRoom(HashMap<String, Object> map) throws Exception;
	public void getVersion() throws Exception;
	public String loadContents(String idx) throws Exception;
}
