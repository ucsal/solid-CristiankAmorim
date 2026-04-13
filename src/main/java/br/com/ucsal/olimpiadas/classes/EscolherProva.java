package br.com.ucsal.olimpiadas.classes;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.repository.EscolherProvaRepository;

public class EscolherProva implements EscolherProvaRepository {

	private final Scanner in;
	private final List<Prova> provas;
	
	public EscolherProva(Scanner in, List<Prova> provas) {
		this.in = in;
		this.provas = provas;
	}
	
	public Long escolherProva() {
		
		System.out.println("\nProvas:");
		for (var p : provas) {
			System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
		}
		System.out.print("Escolha o id da prova: ");

		try {
			long id = Long.parseLong(in.nextLine());
			boolean existe = provas.stream().anyMatch(p -> p.getId() == id);
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
