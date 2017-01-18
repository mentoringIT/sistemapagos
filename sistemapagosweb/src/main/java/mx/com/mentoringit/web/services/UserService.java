package mx.com.mentoringit.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.IUser;
import mx.com.mentoringit.model.dto.UserDTO;

@Service
public class UserService implements IUserService{

	public UserService() {
	}
	
	private IUser userDAO;
	
	public IUser getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(IUser userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserDTO userLogin(UserDTO userDTO) throws Exception {
		return userDAO.userLogin(userDTO);
	}


}
