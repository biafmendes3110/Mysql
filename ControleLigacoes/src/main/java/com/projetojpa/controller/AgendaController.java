package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Agenda;
import com.projetojpa.services.AgendaServices;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
private final AgendaServices agendaServices;
	
	@Autowired
	public AgendaController (AgendaServices agendaServices) {
		this.agendaServices = agendaServices;
	}
	@GetMapping("/{id}")
	public ResponseEntity <Agenda> buscaAgendaIdControlId(@PathVariable Long id){
		Agenda agenda = agendaServices.buscaAgendaId(id);
		if(agenda != null) {
			return ResponseEntity.ok(agenda);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Agenda>> buscaTodasAgendaControl() {
		List<Agenda> Agenda = agendaServices.buscarTodasAgenda();

		return ResponseEntity.ok(Agenda);
	}
	@PostMapping("/")
	public ResponseEntity<Agenda> salvaAgendaControl(@RequestBody Agenda agenda){
		Agenda salvaAgenda = agendaServices.salvaAgenda(agenda);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAgenda);

	}
	@PutMapping ("/{id}")
	public ResponseEntity<Agenda> updateDrogaria(@PathVariable Long id, @RequestBody Agenda agenda) {
		Agenda updateAgenda = agendaServices.alterarAgenda(id,agenda);
		if (updateAgenda  != null) {
			return ResponseEntity.ok(updateAgenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAgendaControl(@PathVariable Long id) {
		boolean apagar = agendaServices.apagarAgenda(id);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

