package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.CitizenApp;
import in.ashokit.service.AR_ServiceImpl;

@RestController
public class AR_RestController {

	@Autowired
	private AR_ServiceImpl service;

	@PostMapping("/application")
	public ResponseEntity<String> createApplication(@RequestBody CitizenApp app) {
		String status = service.createApplication(app);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/applications")
	public ResponseEntity<List<CitizenApp>> getApplications() {
		List<CitizenApp> apps = service.getAllApplications();
		return new ResponseEntity<>(apps, HttpStatus.OK);
	}

}
