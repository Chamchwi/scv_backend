package kr.smaker.scv.Controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.UTF8Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private DBService db;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "index";
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public ResponseEntity<String> version() {
		String version = null;
		JSONObject obj = new JSONObject();
		try {
			version = db.getVersion();
			obj.put("version", version);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new UTF8Response(obj.toJSONString(), "json").entity;
	}
}
