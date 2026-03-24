package br.com.ucsal.olimpiadas.classes;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.repository.AplicarProvaRepository;

public class AplicarProva implements AplicarProvaRepository{
	
	private final Scanner in;
	private final List<Prova> provas;
	private final List<Participante> participantes;
	private final List<Questao> questoes;

	public AplicarProva(Scanner in, List<Participante> participantes, List<Prova> provas, List<Questao> questoes) {
		this.in = in;
		this.participantes = participantes;
		this.provas = provas;
		this.questoes = questoes;
	}
	
	public void aplicarProva() {
		
	}
}
