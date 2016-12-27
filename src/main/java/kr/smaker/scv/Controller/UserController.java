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

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

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

		if ((email == null) || (password == null)
				|| (nickname == null)) {
			return new UTF8Response("{\"success\":false, \"errorcode\":\"오류 발생! 다시 입력해주세요.\"}", "json").entity;
		}

		try {
			db.normal_register(map);
			return new UTF8Response("{\"success\":true}", "json").entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/fb_register", method = RequestMethod.POST)
	public ResponseEntity<String> facebook_register(HttpServletRequest request) {
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
		return null;
	}
}
