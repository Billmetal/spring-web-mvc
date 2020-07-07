package br.com.digital.innovation.one.springboot.web.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digital.innovation.one.springboot.web.mvc.exception.JediNotFoundException;
import br.com.digital.innovation.one.springboot.web.mvc.model.Jedi;
import br.com.digital.innovation.one.springboot.web.mvc.repository.JediRepository;

@Service
public class JediService {
	
	@Autowired
	private JediRepository repository;
	
	public List<Jedi> findAll(){
		return repository.getAllJedi();
	}
	
	public Jedi findById(final Long id){
		Optional<Jedi> jedi = repository.findById(id);
		if(jedi.isPresent()) {
			return jedi.get();
		} else {
			throw new JediNotFoundException();
		}
	}
	
	public Jedi save(final Jedi jedi) {
		return repository.save(jedi);
	}
	
	public Jedi update(final Long id,final Jedi jedi) {
		Optional<Jedi> jediEntity = repository.findById(id);
		if(jediEntity.isPresent()) {
			Jedi jediFounded = jediEntity.get();
			jediFounded.setName(jedi.getName());
			jediFounded.setLastName(jedi.getLastName());
			return jediFounded;
		} else {
			throw new JediNotFoundException();
		}
	}
	
	public void delete(final Long id) {
		Jedi jedi = findById(id);		
		repository.delete(jedi);		
	}

}
