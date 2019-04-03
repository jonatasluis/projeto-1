package com.projeto1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projeto1.domain.Categoria;
import com.projeto1.repositories.CategoriaRepository;
import com.projeto1.services.exceptios.DataIntegrityException;
import com.projeto1.services.exceptios.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	

	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}



	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}



	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj); 
	}



	public void deleteById(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
		
	}





}
