package com.msindico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msindico.domain.Usuario;
import com.msindico.domain.enums.Perfil;
import com.msindico.repository.UsuarioRepository;
import com.msindico.security.UserSS;
import com.msindico.services.exceptions.AuthorizationException;
import com.msindico.services.exceptions.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario findByEmail(String email) {

		UserSS user = UserService.authenticated();
		
		LOG.info("email " + email);

		
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado" + user);		
		}

		Usuario obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}

}
