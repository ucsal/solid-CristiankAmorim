package br.com.ucsal.olimpiadas.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.repository.CadastrarParticipanteRepository;

public class CadastrarParticipante implements CadastrarParticipanteRepository {

	private final Scanner in;
	List<Participante> participantes = new ArrayList<>();
	static long proximoParticipanteId = 1;
	
	public CadastrarParticipante(Scanner in) {
		this.in = in;
	}
	
	public void cadastrarParticipante() {
		
		System.out.print("Nome: ");
		var nome = in.nextLine();

		System.out.print("Email (opcional): ");
		var email = in.nextLine();

		if (nome == null || nome.isBlank()) {
			System.out.println("nome inválido");
			return;
		}

		var p = new Participante();
		p.setId(proximoParticipanteId++);
		p.setNome(nome);
		p.setEmail(email);

		participantes.add(p);
		System.out.println("Participante cadastrado: " + p.getId());
	}
}
