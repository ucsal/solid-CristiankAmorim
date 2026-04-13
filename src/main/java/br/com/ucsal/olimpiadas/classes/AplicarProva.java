package br.com.ucsal.olimpiadas.classes;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.Resposta;
import br.com.ucsal.olimpiadas.Tentativa;
import br.com.ucsal.olimpiadas.repository.AplicarProvaRepository;

public class AplicarProva implements AplicarProvaRepository{
	
	private final Scanner in;
	private final List<Prova> provas;
	private final List<Participante> participantes;
	private final List<Questao> questoes;
	private final List<Tentativa> tentativas;
	private final EscolherParticipante escolherParticipante;
	private final EscolherProva escolherProva;
	static long proximaTentativaId = 1;
	private final CalcularNota calcularNota = new CalcularNota();
	private final ImprimirTabuleiroFen imprimirTabFen= new ImprimirTabuleiroFen();

	public AplicarProva(Scanner in, List<Participante> participantes, List<Prova> provas, 
			List<Questao> questoes, List<Tentativa> tentativas,
			EscolherParticipante escolherParticipante, EscolherProva escolherProva) {
		
		this.in = in;
		this.participantes = participantes;
		this.provas = provas;
		this.questoes = questoes;
		this.escolherParticipante = escolherParticipante;
		this.escolherProva = escolherProva;
		this.tentativas =  tentativas;
	}
	
	public void aplicarProva() {
		
		if (participantes.isEmpty()) {
			System.out.println("cadastre participantes primeiro");
			return;
		}
		if (provas.isEmpty()) {
			System.out.println("cadastre provas primeiro");
			return;
		}

		var participanteId = escolherParticipante.escolherParticipante();
		if (participanteId == null)
			return;

		var provaId = escolherProva.escolherProva();
		if (provaId == null)
			return;

		var questoesDaProva = questoes.stream().filter(q -> q.getProvaId() == provaId).toList();

		if (questoesDaProva.isEmpty()) {
			System.out.println("esta prova não possui questões cadastradas");
			return;
		}

		var tentativa = new Tentativa();
		tentativa.setId(proximaTentativaId++);
		tentativa.setParticipanteId(participanteId);
		tentativa.setProvaId(provaId);

		System.out.println("\n--- Início da Prova ---");

		for (var q : questoesDaProva) {
			System.out.println("\nQuestão #" + q.getId());
			System.out.println(q.getEnunciado());

			System.out.println("Posição inicial:");
			imprimirTabFen.imprimirTabuleiro(q.getFenInicial());

			for (var alt : q.getAlternativas()) {
			    System.out.println(alt);
			}

			System.out.print("Sua resposta (A–E): ");
			char marcada;
			try {
				marcada = Questao.normalizar(in.nextLine().trim().charAt(0));
			} catch (Exception e) {
				System.out.println("resposta inválida (marcando como errada)");
				marcada = 'X';
			}

			var r = new Resposta();
			r.setQuestaoId(q.getId());
			r.setAlternativaMarcada(marcada);
			r.setCorreta(q.isRespostaCorreta(marcada));

			tentativa.getRespostas().add(r);
		}

		tentativas.add(tentativa);

		int nota = calcularNota.calcularNota(tentativa);
		System.out.println("\n--- Fim da Prova ---");
		System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());
	}
}
