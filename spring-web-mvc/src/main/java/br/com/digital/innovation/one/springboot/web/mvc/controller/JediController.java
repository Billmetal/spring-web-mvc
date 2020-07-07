package br.com.digital.innovation.one.springboot.web.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.digital.innovation.one.springboot.web.mvc.model.Jedi;
import br.com.digital.innovation.one.springboot.web.mvc.repository.JediRepository;

@Controller
public class JediController {
	
	@Autowired
	private JediRepository jediRepository;

	@GetMapping("/jedi")
	public ModelAndView jedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");
		modelAndView.addObject("allJedi",jediRepository.getAllJedi());
		return modelAndView;
	}
	
	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		modelAndView.addObject("jedi",new Jedi());
		return modelAndView;
	}
	
	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi,BindingResult result,RedirectAttributes redirectAtributes) {	
		if(result.hasErrors()) {
			return "new-jedi";
		}
				
		jediRepository.save(new Jedi(jedi.getId(),jedi.getName(),jedi.getLastName()));
		
		redirectAtributes.addFlashAttribute("message", "Jedi cadastrado com sucesso .");		
		
		return "redirect:jedi";
	}
}
