package in.ass.esms.api.users.rest;

import static in.ass.esms.api.users.constants.Constants.USER_MANAGEMENT;
import static in.ass.esms.api.users.constants.Constants.VERSION_ONE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value=USER_MANAGEMENT + VERSION_ONE)
public class AppHealthController {
	
	public static final String GET_HEALTH_CEHCK="/health";
	
	@GetMapping(value=GET_HEALTH_CEHCK)
	public ResponseEntity<String> healthCheck(){
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}

}
