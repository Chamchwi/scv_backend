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


@Controller

@RequestMapping(value = "/API")
public class RoomController {
	
	@Autowired
	private DBService db;
	
	 
}
