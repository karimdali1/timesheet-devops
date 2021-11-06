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
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IContratService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest {
	@Autowired
	IContratService us;
	ContratRepository contratRepository;

		@Test
		@Order(1)
		public void testRetrieveAllContrats(){
			List<Contrat> listContrats = us.retrieveAllContrats();
			Assertions.assertEquals(1,listContrats.size());
		}
		
		@Test
		@Order(2)
		public void testaddContrat() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Contrat u = new Contrat(d, "cdd", 300);
			Contrat ContratAdded = us.addContrat(u);
			Assertions.assertEquals(u.getSalaire(),ContratAdded.getSalaire());
		}
		
		
		@Test
		@Order(3)
		public void testupdateContrat() throws ParseException{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Contrat u = new Contrat(d, "cdi", 600);
			Contrat ContratUpdated = us.updateContrat(u); 
			Assertions.assertEquals(u.getSalaire(),ContratUpdated.getSalaire());
			
		}
		
		@Test
		@Order(4)
		public void testdeleteContrat(String id) {
			
			us.deleteContrat("3");
			Assertions.assertNull(us.retrieveContrat("3"));
			
		}
		
		
		@Test
		@Order(5)
		public void testretrieveContrat() {
			
			Contrat ContratRetrieved = us.retrieveContrat("1");
			
			Assertions.assertEquals(1L,ContratRetrieved.getReference()); 
		}
}
