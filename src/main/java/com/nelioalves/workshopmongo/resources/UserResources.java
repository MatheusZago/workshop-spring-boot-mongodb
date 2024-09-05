package com.nelioalves.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.services.UserService;

@RestController //Está dizendo que é uma classe controladora e que os métodos dela devem voltar em Json
@RequestMapping(value = "/users") //Pra ser o caminho 
public class UserResources {
	
	@Autowired //Para mostrar que ele acessa o serviço
	private UserService service;

//	@RequestMapping(method = RequestMethod.GET) //Faz a msm coisa do de baixo
	@GetMapping //Para falar que ele puxa esse método com um get
	public ResponseEntity<List<User>> findAll(){
		//Já ta criando a lista com os valores do findAll do service
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
