package com.projeto.basico.demo.resources;

import com.projeto.basico.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.basico.demo.entities.User;

import java.util.List;

// Para dizer que esta classe é um controlador rest (recurso web) se usa a anotation abaixo
// Esta classe é um controlador rest

@RestController
// Para acessar a pagina que retorna os dados abaixo sera no dominio/users
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserServices services;

	// @GetMapping = um get para http
	// O metodo ResponseEntity é um end-point para buscar todos os users
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = services.findAll();

		// Retorna um ok para o http com o corpo da resposta sendo o objeto u
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = services.finById(id);
		return ResponseEntity.ok().body(obj);
	}
}