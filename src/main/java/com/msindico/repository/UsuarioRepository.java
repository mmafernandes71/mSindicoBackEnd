package com.msindico.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msindico.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String > {
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);

}
