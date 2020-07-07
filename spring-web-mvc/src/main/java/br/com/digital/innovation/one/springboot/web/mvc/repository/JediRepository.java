package br.com.digital.innovation.one.springboot.web.mvc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.digital.innovation.one.springboot.web.mvc.model.Jedi;

@Repository
public class JediRepository {
	
	private List<Jedi> jedis;

	public JediRepository() {
		jedis = new ArrayList<>();
		jedis.add(new Jedi(1,"Luke","Skywalker"));
		jedis.add(new Jedi(2,"ObiOne","Kenobi"));
		jedis.add(new Jedi(3,"Yoda",""));
	}

	public List<Jedi> getAllJedi(){
		return this.jedis;
	}
	
	public Jedi save(Jedi jedi) {
		this.jedis.add(jedi);
		return jedi;
	}
	
	public Optional<Jedi> findById(long id){
		return jedis.stream().filter(jedi -> jedi.getId() == id).findFirst();
	}
	
	public void delete(Jedi jedi) {
		this.jedis.remove(jedi);
	}
}
