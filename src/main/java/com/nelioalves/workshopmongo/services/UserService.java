package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired //Ta criando aqui pq o Service q usa o repositório
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	//Optional é um container que pode ou não ter valor
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		//Se ele nn achar nadajá joga exxceção lá atrás
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		//Esse User obj é só o do App, nn tem reação com o BD
		//Ao fzer isso ele vai instanciar o do BD para ser usado e atualizado.
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
		
	//Transformando o newObj com os dados do obj
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	//Transformando DTO em user
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
