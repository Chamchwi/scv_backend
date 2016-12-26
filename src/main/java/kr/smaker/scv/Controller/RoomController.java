package kr.smaker.scv.Controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.UTF8Response;


@Controller()

@RequestMapping(value = "/API", method = RequestMethod.GET)
public class RoomController {
	
	@Autowired
	private DBService db;
	
	@RequestMapping(value = "/Room/list", method = RequestMethod.GET)
	public ResponseEntity<String> register(@RequestParam("id") String id) {
		System.out.println("ID : " + id);
		
		return new UTF8Response("{\"success\":false, \"errorcode\":\"403043\"}", "json").entity;

	}
	
	@RequestMapping(value = "/Room/wait", method = RequestMethod.POST)
	public ResponseEntity<String> Waitroom(@RequestParam("email")  String email) {
		HashMap <String, Object> map = new HashMap <String, Object> ();
		
		
		return new UTF8Response("{\"success\":false, \"errorcode\":\"403043\"}", "json").entity;
	}
	
	@RequestMapping(value = "/Room/create", method = RequestMethod.POST)
	public ResponseEntity<String> createRoom(@RequestParam("email")  String email
			,@RequestParam("gameMode") String gameMode) {
		HashMap <String, Object> map = new HashMap <String, Object> ();
		
		
		return new UTF8Response("{\"success\":false, \"errorcode\":\"403043\"}", "json").entity;
	}
	
	 
}
