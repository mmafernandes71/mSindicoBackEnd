package com.msindico.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.msindico.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String > {
	
	

}
