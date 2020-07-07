package br.com.digital.innovation.one.springboot.web.mvc.model;

import javax.validation.constraints.NotBlank;


public class Jedi {
	
	private long id;
	
	@NotBlank(message = "Não pode ser em Branco")
	private String name;
	
	@NotBlank(message = "Não pode ser em Branco")
	private String lastName;
	
	public Jedi() {
		
	}
	
	public Jedi(long id ,String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		this.id=id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
	
	public long getId() {
		return id;
	}

}
