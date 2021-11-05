package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;


//seance3 min 38

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter 
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			l.info("In method retrieveAllUsers");
			users = (List<User>) userRepository.findAll();  
			l.debug("connexion a la db ok");
			for (User user : users) {
				l.debug("user :" + user.getLastName()); 
			} 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("out of methode retriveAllUsers success");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			l.error("out of method retrieve allusers with errors" +e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method addUser");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode addUser success");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		l.info("In method updateUser");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode updateUser success");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method deleteUser");
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode deleteUser success");
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method retrieveUser");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode retriveUser success");
		return u; 
	}

}
