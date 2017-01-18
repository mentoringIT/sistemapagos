package mx.com.mentoringit.web.services;

import mx.com.mentoringit.model.dto.UserDTO;

public interface IUserService {

	UserDTO userLogin(UserDTO userDTO) throws Exception;
}
