package com.mp.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mp.brewer.model.Estilo;
import com.mp.brewer.repository.Estilos;
import com.mp.brewer.service.exception.NomeEstiloCadastroException;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloCadastroException("Nome do Estilo já cadastrado");
		}
		estilos.save(estilo);
	}
}
