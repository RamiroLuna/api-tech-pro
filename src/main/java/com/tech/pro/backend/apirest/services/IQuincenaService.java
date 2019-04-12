package com.tech.pro.backend.apirest.services;

import java.util.List;

import com.tech.pro.backend.apirest.models.entity.Anio;
import com.tech.pro.backend.apirest.models.entity.Mes;
import com.tech.pro.backend.apirest.models.entity.Quincena;


public interface IQuincenaService {
	
	public List<Quincena> findAllQuincena();
	
	public List<Anio> findAllAnio();
	
	public List<Mes> findAllMoth();
}