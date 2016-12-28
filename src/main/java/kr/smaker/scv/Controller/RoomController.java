package kr.smaker.scv.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.UTF8Response;

@Controller

@RequestMapping(value = "/API/Room")
public class RoomController {
	
	@Autowired
	private DBService db;
	
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<String> refreshRoom(HttpServletRequest request) {
		String email = request.getParameter("email");
		return null;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ResponseEntity<String> createRoom(HttpServletRequest request) {
		return null;
	}
}
