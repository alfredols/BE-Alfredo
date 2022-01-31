package br.com.api.user.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import br.com.api.user.converter.DozerConverter;
import br.com.api.user.data.dto.UserRequestDTO;
import br.com.api.user.data.dto.UserResponseDTO;
import br.com.api.user.data.model.User;
import br.com.api.user.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository repository;
			
	public UserResponseDTO create(UserRequestDTO user) {
		var entity = DozerConverter.parseObject(user, User.class);		
		entity.setCreated_at(new Date());
		var result = repository.save(entity);
		return DozerConverter.parseObject(result, UserResponseDTO.class);		
	}
	
	public List<UserResponseDTO> findAll() {			
		return DozerConverter.parseListObjects(repository.findAll(),UserResponseDTO.class);		
	}		
	public UserResponseDTO findById(Long id) {
		
		var result = repository.findById(id);		
		return result.isPresent() ? DozerConverter.parseObject(result.get(), UserResponseDTO.class) : null;		
	}
	
	public UserResponseDTO update(UserRequestDTO user, long id) {	
		var entity = DozerConverter.parseObject(user, User.class);
		entity.setId(id);
		entity.setUpdated_at(new Date());
		return DozerConverter.parseObject(repository.save(entity), UserResponseDTO.class);	
	}	
	
	public void delete(Long id) {						
		repository.deleteById(id);
	}
}
