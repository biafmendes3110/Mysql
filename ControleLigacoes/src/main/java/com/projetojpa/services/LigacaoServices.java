package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Ligacao;
import com.projetojpa.repository.LigacaoRepository;

@Service
public class LigacaoServices {
	private final LigacaoRepository ligacaoRepository;

	@Autowired
	public LigacaoServices(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository=ligacaoRepository;
	}
	public List<Ligacao> buscarTodasLigacao(){
		return ligacaoRepository.findAll();
	}
	//método para buscar produto por código 
	public Ligacao buscaLigacaoId(long id) {
		Optional<Ligacao> Ligacao=  ligacaoRepository.findById(id); // classe usada para consulta de banco
		return Ligacao.orElse(null);
	} 
	//método para salvar os produtos
	public Ligacao salvaLigacao(Ligacao ligacao) {
		return ligacaoRepository.save(ligacao);
	}
	public Ligacao alterarLigacao(long id, Ligacao alterarLigacao) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			alterarLigacao.setId(id);
			return ligacaoRepository.save(alterarLigacao);
		}
		return null;
	}
	public boolean apagarLigacao(long id) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			ligacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

