package in.ass.esms.api.users.rest;

import static in.ass.esms.api.users.constants.Constants.USERS;
import static in.ass.esms.api.users.constants.Constants.VERSION_ONE;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import in.ass.esms.api.users.exception.ResourceNotFoundException;
import in.ass.esms.api.users.model.UserModel;
import in.ass.esms.api.users.repository.UserMgmtRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value=VERSION_ONE + USERS)
@CrossOrigin(origins = "http://localhost:4200")
public class UserMgmtController {
	
	private static final Logger log = LoggerFactory.getLogger(UserMgmtController.class);

	@Autowired 
	private UserMgmtRepository userMgmtRepository;
	
	
	@GetMapping("/{id}")
	@ApiOperation("Returns a specific User details by their identifier. 404 if does not exist.")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public UserModel getUser(HttpSession session, @ApiParam("Id of the UserModel to be obtained. Cannot be empty.") @PathVariable Long id) {
		log.info("in side getUser()");
		return userMgmtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", id));

	}

	@GetMapping("/")
	@ApiOperation("Returns list of all User details in the system.")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public List<UserModel> getAllUserModels(HttpSession session) {
		return userMgmtRepository.findAll();
	}

	@PostMapping("/")
	@ApiOperation("Creates a new UserModel.")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	
	public UserModel createUserModel(HttpSession session,
			@ApiParam("UserModel information for a new User to be created.") @RequestBody UserModel UserModel) {
		return userMgmtRepository.save(UserModel);
	}

	@PutMapping("/{id}")
	@ApiOperation("update an existing User details.")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public UserModel updateUserModel(HttpSession session,@ApiParam("Id of the User to be obtained. Cannot be empty.") @PathVariable Long id,
			@ApiParam("UserModel information.") @Valid @RequestBody UserModel UserModelDetails) {

		UserModel updatedUserModel = userMgmtRepository.saveAndFlush(UserModelDetails);
		return updatedUserModel;
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Deletes a UserModel from the system. 404 if the studnet's identifier is not found.")
	@HystrixCommand(fallbackMethod = "getDataFallBack2")
	public ResponseEntity<UserModel> deleteUserModel(HttpSession session,
			@ApiParam("Id of the UserModel to be obtained. Cannot be empty.") @PathVariable Long id) {
		UserModel UserModel = userMgmtRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", id));

		userMgmtRepository.delete(UserModel);

		return ResponseEntity.ok().build();
	}

	public UserModel getDataFallBack(HttpSession session,UserModel UserModel1) {

		UserModel UserModel = new UserModel();
		UserModel.setFirstName("fallback-firstname");
		UserModel.setLastName("fallback-lastname");
		UserModel.setUsername("fallback-username");
		UserModel.setUserpassword("fallback-password");
		return UserModel;

	}

	public UserModel getDataFallBack(HttpSession session,Long id, UserModel UserModel1) {

		UserModel UserModel = new UserModel();
		UserModel.setFirstName("fallback-firstname");
		UserModel.setLastName("fallback-lastname");
		UserModel.setUsername("fallback-username");
		UserModel.setUserpassword("fallback-password");
		return UserModel;

	}

	public List<UserModel> getDataFallBack(HttpSession session) {

		List<UserModel> UserModelList = new ArrayList<UserModel>();

		UserModel UserModel = new UserModel();
		UserModel.setFirstName("fallback-firstname");
		UserModel.setLastName("fallback-lastname");
		UserModel.setUsername("fallback-username");
		UserModel.setUserpassword("fallback-password");

		UserModelList.add(UserModel);
		return UserModelList;

	}

	public UserModel getDataFallBack(HttpSession session,Long id) {

		UserModel UserModel = new UserModel();
		UserModel.setFirstName("fallback-firstname");
		UserModel.setLastName("fallback-lastname");
		UserModel.setUsername("fallback-username");
		UserModel.setUserpassword("fallback-password");
		return UserModel;

	}

	public ResponseEntity<UserModel> getDataFallBack2(HttpSession session,Long id) {

		UserModel UserModel = new UserModel();
		UserModel.setFirstName("fallback-firstname");
		UserModel.setLastName("fallback-lastname");
		UserModel.setUsername("fallback-username");
		UserModel.setUserpassword("fallback-password");
		return new ResponseEntity<UserModel>(UserModel, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
