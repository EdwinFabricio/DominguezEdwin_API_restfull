package com.m5a.ista.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m5a.ista.entity.Usuario;
import com.m5a.ista.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	// crear
	@PostMapping("/crear")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usuario));

	}

	// listar id
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {

		Optional<Usuario> oUser = userService.findById(id);

		if (!oUser.isPresent()) {

			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(oUser);
		}

	}

	// actualizarUsuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario userDetails, @PathVariable(value = "id") Long id) {

		Optional<Usuario> User = userService.findById(id);
		if (!User.isPresent()) {
			return ResponseEntity.notFound().build();

		}
		User.get().setNombre(userDetails.getNombre());
		User.get().setEmail(userDetails.getEmail());
		User.get().setEstado(userDetails.getEstado());
		User.get().setClave(userDetails.getClave());
		

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(User.get()));
	}
	
	
	//borrar
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <?> delete (@PathVariable (value="id") Long id){
		if (!userService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
	userService.deleteById(id);
	return ResponseEntity.ok().build();
	}
	
	
	//listarTodos
	
	
	@GetMapping
	public List<Usuario> readAll (){
		List<Usuario> user = StreamSupport.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
		return user;
	}

}
