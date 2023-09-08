package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.mtnm.Usuario;
import com.example.demo.service.mtnm.UsuarioService;

import lombok.var;



//@Service
//public class JWTUserDetailsService implements UserDetailsService {
public class JWTUserDetailsService  {
	@Autowired
	private UsuarioService service;
	
	/*
	 * Tenemos anotado un objeto de la clase UserDetailsService como @Servicio
	 * y es lo único que necesita SpringSecurity para tener un User ACTIVO
	 * que se suele cargar generalmente desde una BBDD.
	 * Es muy importante porque es así como SpringSecurity conoce el nombre
	 * del usuario (ACTIVO), la contraseña etc (en nuestro caso el e-mail que
	 * va a actuar como usuario y consigue realizar el proceso de autenticación.
	 * */
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		return service.BuscarPorUser(username).map(usuario ->{
			
			//Si la BBDD devuelve un solo valor de un campo "rol" de la BBDD
			var authorities = List.of(new SimpleGrantedAuthority(usuario.getRol()));
			//User extiende UserDetails 
			return new User(usuario.getUsername(),usuario.getPassword(),authorities);
			
		}).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado en la BBDD"));
		
		
	}
	
	*/

}
