package com.projeto.basico.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.basico.demo.entities.User;

// Para dizer que esta classe é um controlador rest (recurso web) se usa a anotation abaixo

@RestController
// Para acessar a pagina que retorna os dados abaixo sera no dominio/users
@RequestMapping(value = "/users")
public class UserResource {
	
	// @GetMapping = um get para http
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "00000000", "12345678");
		
		// Retorna um ok para o http com o corpo da resposta sendo o objeto u
		return ResponseEntity.ok().body(u);
	}
}
