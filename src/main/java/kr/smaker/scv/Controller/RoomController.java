package kr.smaker.scv.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.UTF8Response;

@Controller

@RequestMapping(value = "/API/Room")
public class RoomController {

	@Autowired
	private DBService db;
	
	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> refreshRoom(HttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		int score = -1;
		JSONObject obj = new JSONObject();
		List<HashMap<String, Object>> list = null;
		
		try {
			list = db.getRoomData();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		try {
			score = Integer.parseInt(db.getScore(email));
			obj.put("rating_score", score);
			obj.put("room_data", list);
		} catch (Exception e) {
			obj.clear();
			obj.put("success", false);
			return new UTF8Response(obj.toJSONString(), "json").entity;
		}

		return new UTF8Response(obj.toJSONString(), "json").entity;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> createRoom(HttpServletRequest request) throws Exception, DuplicateKeyException {
		String master_email = request.getParameter("master_email");
		String game_mode = request.getParameter("game_mode");
		String room_title = request.getParameter("room_title");

		HashMap<String, Object> map = new HashMap<String, Object>();
		int room_id;

		if (master_email != null && game_mode != null && room_title != null) {
			map.put("master_email", master_email);
			map.put("game_mode", game_mode);
			map.put("title", room_title);
			db.createRoom(map);
			room_id = db.getRoomid(master_email);
			return new UTF8Response("{\"room\":" + "\"" + room_id + "\"" + "}", "json").entity;
		}
		return new UTF8Response("{\"success\":false}", "json").entity;
	}

	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public ResponseEntity<String> enterRoom(HttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String game_mode = request.getParameter("game_mode");
		String room_id = request.getParameter("room_id");
		
		
		return null;
	}

	@RequestMapping(value = "/out", method = RequestMethod.GET)
	public ResponseEntity<String> outRoom(HttpServletRequest request) {
		return null;
	}
}
