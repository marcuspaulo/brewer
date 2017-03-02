package com.mp.brewer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mp.brewer.model.Cerveja;

@Controller
public class CerverjasController {
	
	private static final Logger logger = LoggerFactory.getLogger(CerverjasController.class);

	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		
		if(logger.isDebugEnabled()) {
			logger.info("O Objeto Cerveja eh: " + cerveja);
		}
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			System.out.println("-");
			return novo(cerveja);
		}
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println("Cadastrar " + cerveja.getSku() + " - " + cerveja.getNome());
		return "redirect:/cervejas/novo";
	}
	
	@RequestMapping(value = "/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}
}
