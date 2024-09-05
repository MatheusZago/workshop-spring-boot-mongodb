package com.nelioalves.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository //Essa interface precisa do que ela vai gerenciar e o tipo de ID do que ela vai usar
public interface PostRepository extends MongoRepository<Post, String>{
	
	//Usando query method, só de criar o nome de certa forma ela monta uma consulta automaticamente
	List<Post> findByTitleContainingIgnoreCase(String text);

}
