package br.com.ucsal.olimpiadas.classes;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.repository.EscolherParticipanteRepository;

public class EscolherParticipante implements EscolherParticipanteRepository{
	
	private final Scanner in;
	private final List<Participante> participantes;
	
	public EscolherParticipante(Scanner in, List<Participante> participantes) {
		this.in = in;
		this.participantes = participantes;
	}

	public Long escolherParticipante() {

		System.out.println("\nParticipantes:");
		for (var p : participantes) {
			System.out.printf("  %d) %s%n", p.getId(), p.getNome());
		}
		System.out.print("Escolha o id do participante: ");

		try {
			long id = Long.parseLong(in.nextLine());
			boolean existe = participantes.stream().anyMatch(p -> p.getId() == id);
			if (!existe) {
				System.out.println("id inválido");
				return null;
			}
			return id;
		} catch (Exception e) {
			System.out.println("entrada inválida");
			return null;
		}
	}
}
