package com.tech.pro.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.backend.apirest.models.entity.Area;
import com.tech.pro.backend.apirest.models.entity.Usuario;
import com.tech.pro.backend.apirest.services.AreaServiceImpl;
import com.tech.pro.backend.apirest.services.UsuarioServiceImpl;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private AreaServiceImpl areaServiceImpl;
	
	@Secured({"ROLE_CONSULTA_USUARIO"})
	@GetMapping("/findAll")
	public List<Usuario> index(){
		return usuarioServiceImpl.findAll();
	} 
	
	@Secured({"ROLE_CONSULTA_PERFIL"})
	@GetMapping("/profile/{usuario}")
	public ResponseEntity<?> findByUser(@PathVariable String usuario){
		Map<String, Object> response =  new HashMap<>();
		Usuario getUser  = usuarioServiceImpl.findByUsuario(usuario);
		List<Area> listaAreas = areaServiceImpl.findAll();
		response.put("areas", listaAreas);
		response.put("getUser", getUser);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	} 
	
}
