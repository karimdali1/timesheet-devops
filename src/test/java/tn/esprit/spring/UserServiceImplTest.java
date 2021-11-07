package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IUserService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	@Autowired
	IUserService us;
	UserRepository userRepository;

		@Test
		@Order(1)
		public void testRetrieveAllUsers(){
			List<User> listUsers = us.retrieveAllUsers();
			Assertions.assertEquals(5,listUsers.size());
		}
		
		@Test
		@Order(2)
		public void testaddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("Maykssa1","Maybjss1",d,Role.INGENIEUR);
			User UserAdded = us.addUser(u);
			Assertions.assertEquals(u.getLastName(),UserAdded.getLastName());
		}
		
		
		@Test
		@Order(3)
		public void testupdateUser() throws ParseException{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(1L,"MAYSSA1pl1122","MAYYYhbbbSSSAA",d,Role.TECHNICIEN);
			User UserUpdated = us.updateUser(u); 
			Assertions.assertEquals(u.getLastName(),UserUpdated.getLastName());
			
		}
		
		@Test
		@Order(4)
		public void testdeleteUser() {
			us.deleteUser("3");
			Assertions.assertNull(us.retrieveUser("3"));
			
		}
		
		
		@Test
		@Order(5)
		public void testretrieveUser() {
			
			User UserRetrieved = us.retrieveUser("1");
			
			Assertions.assertEquals(1L,UserRetrieved.getId().longValue()); 
		}
}
