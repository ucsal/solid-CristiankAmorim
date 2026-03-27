package br.com.ucsal.olimpiadas.classes;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.repository.CadastrarQuestaoRepository;

public class CadastrarQuestao implements CadastrarQuestaoRepository{
	
	private final Scanner in;
	private final List<Prova> provas;
	private final List<Questao> questoes;
	private final EscolherProva escolherProva;
	static long proximaQuestaoId = 2;

	public CadastrarQuestao(Scanner in, List<Prova> provas, List<Questao> questoes, EscolherProva escolherProva) {
		this.in = in;
		this.provas = provas;
		this.questoes = questoes;
		this.escolherProva = escolherProva;
	}
	
	public void cadastrarQuestao() {
		
		if (provas.isEmpty()) {
			System.out.println("não há provas cadastradas");
			return;
		}
		
		var provaId = escolherProva.escolherProva();
		if (provaId == null)
			return;
		
		System.out.println("Enunciado:");
		var enunciado = in.nextLine();
		
		var alternativas = new String[5];
		for (int i = 0; i < 5; i++) {
			char letra = (char) ('A' + i);
			System.out.print("Alternativa " + letra + ": ");
			alternativas[i] = letra + ") " + in.nextLine();
		}

		System.out.print("Alternativa correta (A–E): ");
		char correta;
		try {
			correta = Questao.normalizar(in.nextLine().trim().charAt(0));
		} catch (Exception e) {
			System.out.println("alternativa inválida");
			return;
		}

		var q = new Questao();
		q.setId(proximaQuestaoId++);
		q.setProvaId(provaId);
		q.setEnunciado(enunciado);
		q.setAlternativas(alternativas);
		q.setAlternativaCorreta(correta);

		questoes.add(q);

		System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
		
	}
}
