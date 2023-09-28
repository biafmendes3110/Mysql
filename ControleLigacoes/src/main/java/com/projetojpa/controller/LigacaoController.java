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

import com.projetojpa.entities.Ligacao;
import com.projetojpa.services.LigacaoServices;

@RestController
@RequestMapping("/ligacao")
public class LigacaoController {
private final LigacaoServices ligacaoServices;
	
	@Autowired
	public LigacaoController (LigacaoServices ligacaoServices) {
		this.ligacaoServices = ligacaoServices;
	}
	@GetMapping("/{id}")
	public ResponseEntity <Ligacao> buscaLigacaoIdControlId(@PathVariable Long id){
		Ligacao ligacao = ligacaoServices.buscaLigacaoId(id);
		if(ligacao != null) {
			return ResponseEntity.ok(ligacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Ligacao>> buscaTodasLigacaoControl() {
		List<Ligacao> Ligacao = ligacaoServices.buscarTodasLigacao();

		return ResponseEntity.ok(Ligacao);
	}
	@PostMapping("/")
	public ResponseEntity<Ligacao> salvaLigacaoControl(@RequestBody Ligacao ligacao){
		Ligacao salvaLigacao = ligacaoServices.salvaLigacao(ligacao);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaLigacao);

	}
	@PutMapping ("/{id}")
	public ResponseEntity<Ligacao> updateLigacao(@PathVariable Long id, @RequestBody Ligacao ligacao) {
		Ligacao updateLigacao = ligacaoServices.alterarLigacao(id, ligacao);
		if (updateLigacao != null) {
			return ResponseEntity.ok(updateLigacao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaLigacaoControl(@PathVariable Long id) {
		boolean apagar = ligacaoServices.apagarLigacao(id);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

