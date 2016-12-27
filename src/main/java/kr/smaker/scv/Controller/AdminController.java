package kr.smaker.scv.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.smaker.scv.manager.DBService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private DBService db;
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String userList(ModelMap modelMap, Map<String, Object> commandMap, HttpServletRequest request) throws Exception {
		
		List<Map<String, Object>> list = db.getAllMember(commandMap);
		modelMap.addObject("list", list);
		return "admin/UserList";
	}
}
