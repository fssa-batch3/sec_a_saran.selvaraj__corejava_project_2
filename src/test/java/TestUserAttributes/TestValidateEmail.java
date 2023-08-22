package TestUserAttributes;

import java.sql.SQLException;
import java.util.regex.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.validation.exception.InvalidUserException;
import com.google.protobuf.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import static org.junit.jupiter.api.Assertions.*;

public class TestValidateEmail {
 
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	public static void TestEmailSuccess() throws ServiceException {	
		    String Email ="saran@gmail.com";
			try {
				assertTrue(validator.validateEmail(Email));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
	
	@Test
	public static void TestEmailFailure() throws ServiceException {	
		    String Email = null;
			try {		
				assertFalse(validator.validateEmail(Email));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail(); 
			}
	} 
}