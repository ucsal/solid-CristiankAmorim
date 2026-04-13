package br.com.ucsal.olimpiadas.classes;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.repository.CadastrarProvaRepository;

public class CadastrarProva implements CadastrarProvaRepository {
	
	private final Scanner in;
	private final List<Prova> provas;
	static long proximaProvaId = 2;
	
	public CadastrarProva(Scanner in, List<Prova> provas) {
		this.in = in;
		this.provas = provas;
	}
	
	public void cadastrarProva() {
		
		System.out.print("Título da prova: ");
		var titulo = in.nextLine();

		if (titulo == null || titulo.isBlank()) {
			System.out.println("título inválido");
			return;
		}
		
		var prova = new Prova();
		prova.setId(proximaProvaId++);
		prova.setTitulo(titulo);

		provas.add(prova);
		System.out.println("Prova criada: " + prova.getId());
		
	}
}
