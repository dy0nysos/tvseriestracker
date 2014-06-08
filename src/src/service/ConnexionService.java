package src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import src.dao.UserDAO;

@Service("connexionService")
@Scope("singleton")
public class ConnexionService {

	private UserDAO userDAO;
	
	@Autowired
	public ConnexionService(UserDAO userDAO){
		this.userDAO = userDAO;
	}
}
