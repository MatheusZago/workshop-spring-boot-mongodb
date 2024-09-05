package com.nelioalves.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository //Essa interface precisa do que ela vai gerenciar e o tipo de ID do que ela vai usar
public interface PostRepository extends MongoRepository<Post, String>{

}
