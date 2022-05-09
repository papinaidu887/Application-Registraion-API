package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.CitizenApp;

public interface AR_Service {
	
	public String createApplication(CitizenApp app);
	
	public List<CitizenApp> getAllApplications();

}
