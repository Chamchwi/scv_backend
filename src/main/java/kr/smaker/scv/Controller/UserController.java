package kr.smaker.scv.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.smaker.scv.dao.UserData;
import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.RemoveBOM;
import kr.smaker.scv.manager.UTF8Response;

@Controller

@RequestMapping(value = "/API", method = RequestMethod.POST)
public class UserController {

	@Autowired
	private DBService db;
	
	@RequestMapping(value = "/normal_register", method = RequestMethod.POST)
	public ResponseEntity<String> normal_register(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("email", email);
		map.put("password", password);
		map.put("nickname", nickname);

		try {
			db.normal_register(map);
			return new UTF8Response("{\"success\":true\"}", "json").entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value ="/fb_register", method = RequestMethod.POST)
	public ResponseEntity<String> facebook_register(HttpServletRequest request) {
		String email = request.getParameter("email");
		String token = request.getParameter("token");
		String nickname = request.getParameter("nickname");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("email", email);
		map.put("token", token);
		map.put("nickname", nickname);
		
		try {
			db.fb_register(map);
			return new UTF8Response("{\"success\":true\"}", "json").entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/* @RequestMapping(value = "/fb_login", method = RequestMethod.GET)
	public ResponseEntity<String> facebookLogin(HttpServletRequest request) throws Exception {

		System.out.println("NAME : " + request.getParameter("first_name"));
		HashMap<String, Object> map = new HashMap<String, Object>();
		UserData data = new UserData();

		if (request.getParameter("email") == null) {
			return new UTF8Response("{\"success\":false\", \"errorcode\":\"이메일을 입력해주세요.\"}", "json").entity;
		} else if (request.getParameter("first_name") == null) {
			return new UTF8Response("{\"success\":false\", \"errorcode\":\"first_name을 입력해주세요.\"}", "json").entity;
		} else if (request.getParameter("last_name") == null) {
			return new UTF8Response("{\"success\":false\", \"errorcode\":\"last_name을 입	력해주세요.\"}", "json").entity;
		} else if ((request.getParameter("email") == null) && (request.getParameter("first_name") == null)
				&& (request.getParameter("last_name") == null)) {
			return new UTF8Response("{\"success\":false\", \"errorcode\":\"입력된 값이 없습니다.\"}", "json").entity;

		}

		data.setEmail(request.getParameter("email"));
		String email = data.getEmail();
		if (email.equals(request.getParameter("email"))) {
			map.put("email", request.getParameter("email"));
			map.put("first_name", request.getParameter("first_name"));
			map.put("last_name", request.getParameter("last_name"));
			map.put("last_log", null);
			map.put("score", 1000);
			map.put("winning_streak", 0);

			try {
				// db.register(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new UTF8Response("{\"success\":true}", "json").entity;
		} else {
			return new UTF8Response("{\"success\":false}", "json").entity;
		}

	} */
}
