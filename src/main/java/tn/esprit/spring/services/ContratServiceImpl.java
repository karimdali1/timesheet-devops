package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;


//seance3 min 38

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;

	// TODO Logger à ajouter 
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			l.info("In method retrieveAllContrats");
			contrats = (List<Contrat>) contratRepository.findAll();  
			l.debug("connexion a la db ok");
			for (Contrat contrat : contrats) {
				l.debug("Contrat :" + contrat.getReference()); 
			} 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("out of methode retriveAllContrats success");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			l.error("out of method retrieve allusers with errors" +e);
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat u) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method addContrat");
		Contrat u_saved = contratRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode addContrat success");
		return u_saved; 
	}

	@Override 
	public Contrat updateContrat(Contrat u) { 
		// TODO Log à ajouter en début de la méthode 
		l.info("In method updateContrat");
		Contrat u_saved = contratRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode updateContrat success");
		return u_saved; 
	}

	@Override
	public void deleteContrat(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method deleteContrat");
		contratRepository.deleteById(Integer.parseInt(id)); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode deleteUser success");
	}

	@Override
	public Contrat retrieveContrat(String id) {
		Contrat u = null;
		try {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method retrieveContrat");
		//Contrat u =  contratRepository.findById(Long.parseLong(id)).orElse(null);
	 u =  contratRepository.findById(Integer.parseInt(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		l.debug("connexion a la db ok");
		l.info("out of methode retriveContrat success");}catch (Exception e) {
			l.error("error in retrievecontrat() :"+e);		}
		return u; 
	}


	

}
