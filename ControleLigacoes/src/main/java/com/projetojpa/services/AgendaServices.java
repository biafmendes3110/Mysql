package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Agenda;
import com.projetojpa.repository.AgendaRepository;

@Service
public class AgendaServices {
	private final AgendaRepository agendaRepository;

	@Autowired
	public AgendaServices(AgendaRepository agendaRepository) {
		this.agendaRepository= agendaRepository;
	}
	public List<Agenda> buscarTodasAgenda(){
		return agendaRepository.findAll();
	}
	//método para buscar produto por código 
	public Agenda buscaAgendaId(long id) {
		Optional<Agenda> Agenda = agendaRepository.findById(id); // classe usada para consulta de banco
		return Agenda.orElse(null);
	} 
	//método para salvar os produtos
	public Agenda salvaAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}
	public Agenda alterarAgenda(long id, Agenda alterarAgenda) {
		Optional<Agenda> existeAgenda = agendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			alterarAgenda.setId(id);
			return agendaRepository.save(alterarAgenda);
		}
		return null;
	}
	public boolean apagarAgenda(long id) {
		Optional<Agenda> existeAgenda = agendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			agendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

