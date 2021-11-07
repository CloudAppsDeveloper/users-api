package in.ass.esms.api.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ass.esms.api.users.repository.UserMgmtRepository;

@Service
public class UserMgmtService {
	
	@Autowired
	private UserMgmtRepository userMgmtRepository;
	
	

}
