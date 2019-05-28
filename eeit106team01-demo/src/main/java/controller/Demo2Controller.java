package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Demo2Controller {

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/secure")
	public String secure() {
		return "secure";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
