package com.tech.pro.backend.apirest.services;

import java.util.List;

import com.tech.pro.backend.apirest.models.entity.Personal;

public interface IPersonalService {
	public List<Personal> findAll();
}