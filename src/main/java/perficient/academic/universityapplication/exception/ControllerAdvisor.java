package perficient.academic.universityapplication.exception;

import org.postgresql.util.PSQLException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler
{
	private static final String MESSAGE = "message";
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request)
	{
		Map<String, Object> body = new HashMap<>();
		body.put(MESSAGE, ex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request)
	{
		Map<String, Object> body = new HashMap<>();
		String[] message = ex.getMessage().split("default message");
		body.put(MESSAGE, message[2].replaceAll("[\\[\\](){}]",""));
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
		Map<String, Object> body = new HashMap<>();
		body.put(MESSAGE, ex.getMessage().split("models.")[1].replace("exists", "doesn't exists"));
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(org.postgresql.util.PSQLException.class)
	public ResponseEntity<Object> handlePSQLException(PSQLException ex, WebRequest request){
		Map<String, Object> body = new HashMap<>();
		if(ex.getSQLState().equals("23505")){
			body.put(MESSAGE, "Government id or email already in use");
		}
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}
