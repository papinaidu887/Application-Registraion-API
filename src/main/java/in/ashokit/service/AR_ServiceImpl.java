package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.CitizenApp;
import in.ashokit.entity.AppRegEntity;
import in.ashokit.entity.AppRegRepository;

@Service
public class AR_ServiceImpl implements AR_Service {

	@Autowired
	private AppRegRepository repository;

	@Override
	public String createApplication(CitizenApp app) {

		String ssaApiUrl = "https://ssa-web-api3.herokuapp.com/ssn/{ssn}";

		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity(ssaApiUrl, String.class, app.getSsn());

		if (forEntity.getStatusCodeValue() == 200) {
			 String stateName = forEntity.getBody();
			if (stateName != null && !stateName.isEmpty() && stateName.equals(" New Jersey")) {
				AppRegEntity entity = new AppRegEntity(); 
				BeanUtils.copyProperties(app, entity);
				AppRegEntity savedEntity = repository.save(entity);//New Jersey
				return "Application Registered :: " + savedEntity.getAppNum();
			} else {
				return "Citizen not belongs to New Jersey";
			}
		} else {
			return "Unable to access SSA API..";
		}

	}

	@Override
	public List<CitizenApp> getAllApplications() {

		List<AppRegEntity> findAll = repository.findAll();

		List<CitizenApp> apps = new ArrayList<>();

		for (AppRegEntity entity : findAll) {
			CitizenApp app = new CitizenApp();
			BeanUtils.copyProperties(entity, app);
			apps.add(app);
		}

		return apps;
	}

}
