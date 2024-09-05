package com.nelioalves.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.User;

@RestController //Está dizendo que é uma classe controladora e que os métodos dela devem voltar em Json
@RequestMapping(value = "/users") //Pra ser o caminho 
public class UserResources {

//	@RequestMapping(method = RequestMethod.GET) //Faz a msm coisa do de baixo
	@GetMapping //Para falar que ele puxa esse método com um get
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		//Responde Entity é feito para devolver resposta em html, organizando como corpo e etc
		return ResponseEntity.ok().body(list);
	}
}
