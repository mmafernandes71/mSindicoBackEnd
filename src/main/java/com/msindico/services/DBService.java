package com.msindico.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.msindico.domain.Usuario;
import com.msindico.domain.enums.Perfil;
import com.msindico.repository.UsuarioRepository;


@Service
public class DBService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() throws ParseException {
	
	usuarioRepo.deleteAll();	
		
	Usuario maria = new Usuario(null,  "maria@gmail.com", pe.encode("123"));	
	Usuario alex = new Usuario(null,  "alex@gmail.com", pe.encode("123"));
	Usuario bob = new Usuario(null,  "bob@gmail.com", pe.encode("123") );
	
	maria.addPerfil(Perfil.ADMIN);
	
	usuarioRepo.saveAll(Arrays.asList(maria,alex,bob));		
	}

}
