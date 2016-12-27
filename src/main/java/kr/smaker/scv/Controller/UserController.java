package kr.smaker.scv.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.UTF8Response;

@Controller

@RequestMapping(value = "/API", method = RequestMethod.POST)
public class UserController {

	@Autowired
	private DBService db;

	@RequestMapping(value = "/normal_register", method = RequestMethod.POST)
	public ResponseEntity<String> normal_register(HttpServletRequest request) throws DuplicateKeyException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("email", email);
		map.put("password", password);
		map.put("nickname", nickname);

		if ((email == null) || (password == null) || (nickname == null)) {
			return new UTF8Response("{\"success\":false, \"errorcode\":\"오류 발생! 다시 입력해주세요.\"}", "json").entity;
		}

		try {
			db.normal_register(map);
			return new UTF8Response("{\"success\":true}", "json").entity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new UTF8Response("{\"success\":false}", "json").entity;
	}

	@RequestMapping(value = "/fb_register", method = RequestMethod.POST)
	public ResponseEntity<String> facebook_register(HttpServletRequest request) throws DuplicateKeyException {
		String email = request.getParameter("email");
		String token = request.getParameter("token");
		String nickname = request.getParameter("nickname");
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("email", email);
		map.put("token", token);
		map.put("nickname", nickname);

		if ((email == null) || (nickname == null)) {
			return new UTF8Response("{\"success\":false, \"errorcode\":\"오류 발생! 다시 입력해주세요.\"}", "json").entity;
		}

		try {
			db.fb_register(map);
			return new UTF8Response("{\"success\":true}", "json").entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UTF8Response("{\"success\":false}", "json").entity;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<String> login(HttpServletRequest request, 
			@RequestParam("mode") String mode) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String token = request.getParameter("token");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data = db.loginRequest(map);
		if (data.get("email").equals(email)) {
			if (mode.equals("normal")) {
				if (data.get("mode").equals("normal") && data.get("password").equals(password)) {
					return new UTF8Response("{\"success\":true}", "json").entity;
				} else {
					return new UTF8Response("{\"success\":false}", "json").entity;
				}
			} else if (mode.equals("facebook")) {
				if (data.get("mode").equals("facebook") && data.get("token").equals(token)) {
					return new UTF8Response("{\"success\":true}", "json").entity;
				} else {
					return new UTF8Response("{\"success\":false}", "json").entity;
				}
			}
		}
		
		return null;
	}
}
