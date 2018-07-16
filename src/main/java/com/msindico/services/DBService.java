package com.msindico.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msindico.domain.Usuario;
import com.msindico.repository.UsuarioRepository;


@Service
public class DBService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public void instantiateTestDatabase() throws ParseException {
	
	usuarioRepo.deleteAll();	
		
	Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");	
	Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
	Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
	
	usuarioRepo.saveAll(Arrays.asList(maria,alex,bob));		
	}

}
