package in.ass.esms.api.users.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;

import in.ass.esms.api.users.constants.Constants;
import in.ass.esms.api.users.model.ErrorVO;
import in.ass.esms.api.users.model.ErrorsVO;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

@ExceptionHandler(value=Exception.class)
public ResponseEntity<?> unhandleException(Exception exception){
	log.error("Exception occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}

@ExceptionHandler(value=MissingPathVariableException.class)
public ResponseEntity<?> unhandleMissingPathVariable(MissingPathVariableException exception){
	log.error("MissingPathVariableException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}


@ExceptionHandler(value=MethodArgumentNotValidException.class)
public ResponseEntity<?> unhandleMethodArgumentNotValid(MethodArgumentNotValidException exception){
	log.error("MethodArgumentNotValidException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}


@ExceptionHandler(value=JsonProcessingException.class)
public ResponseEntity<?> unhandleJsonProcessing(JsonProcessingException exception){
	log.error("JsonProcessingException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}


@ExceptionHandler(value=NoHandlerFoundException.class)
public ResponseEntity<?> unhandleNoHandlerFound(NoHandlerFoundException exception){
	log.error("NoHandlerFoundException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}

@ExceptionHandler(value=ServletRequestBindingException.class)
public ResponseEntity<?> unhandleServletRequestBinding(ServletRequestBindingException exception){
	log.error("ServletRequestBindingException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}
@ExceptionHandler(value=ResourceAccessException.class)
public ResponseEntity<?> unhandleResourceAccess(ResourceAccessException exception){
	log.error("Exception occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}

@ExceptionHandler(value=HttpMessageNotReadableException.class)
public ResponseEntity<?> unhandleHttpMessageNotReadable(HttpMessageNotReadableException exception){
	log.error("HttpMessageNotReadableException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}


@ExceptionHandler(value=UserServiceException.class)
public ResponseEntity<?> unhandleUserService(UserServiceException exception){
	log.error("UserServiceException occurred in User management={}",exception);
	return new ResponseEntity<>(this.getErrorsList(HttpStatus.BAD_REQUEST.toString(), exception.getMessage(), Constants.TECHNICAL),HttpStatus.BAD_REQUEST);			
}

	private ErrorsVO getErrorsList(String errorCode, String description, String errorType) {

		ErrorsVO errors = new ErrorsVO();
		List<ErrorVO> errorsList = new ArrayList<>();
		ErrorVO error = new ErrorVO();
		errorsList.add(error);
		errors.setErrors(errorsList);
		return errors;

	}

}
