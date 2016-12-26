package kr.smaker.scv.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.smaker.scv.manager.DBService;
import kr.smaker.scv.manager.UTF8Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		String idx = "1";
		// JSONObject obj = new JSONObject();
		String data = null;
		try {
			System.out.println(db.loadContents(idx));
			
			data = db.loadContents(idx);
			
			//HashMap<String, Object> map = data.get(0);
			//obj.put("version", map.get("version"));
			System.out.println(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jsonObject.put("result_list", jsonList);
		return new UTF8Response("{\"success\":true}", "json").entity;
	}
}
