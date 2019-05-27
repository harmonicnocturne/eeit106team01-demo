package controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.entity.Test;

@RestController()
public class DemoController {
	
	@GetMapping(path = {"/test"},
	produces = {"application/json"}
	)
	public ResponseEntity<Test> getTestJson() {
		Test test = new Test();
		test.setId(1);
		test.setTest("test33");
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(test);
	}
	
}
