package com.m5a.ista.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.m5a.ista.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> findAll();

	public Page<Usuario> findall(Pageable pageable);

	// public Usuario crearUser ();

	public Optional<Usuario> findById(Long id);

	public Usuario save(Usuario usuario);

	public void deleteById(Long id);

}
