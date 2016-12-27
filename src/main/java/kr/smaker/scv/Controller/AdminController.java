package kr.smaker.scv.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ResponseEntity<String> userList() {
		return null;
	}
}
