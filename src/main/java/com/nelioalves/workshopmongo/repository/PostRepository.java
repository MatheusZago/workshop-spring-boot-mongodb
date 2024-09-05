package com.nelioalves.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository //Essa interface precisa do que ela vai gerenciar e o tipo de ID do que ela vai usar
public interface PostRepository extends MongoRepository<Post, String>{
	
	//Usando query method, só de criar o nome de certa forma ela monta uma consulta automaticamente
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
	//Isso aqui é pra executar  query automatica de antes, só que de forma mais personalizada.
	//Title ta dizendo qual campo vai buscar, ?0 quer dizer que ele vai pegar o primeiro parametro do metodo pra usar
	//E i no options quer dizer q ignora case
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

}
