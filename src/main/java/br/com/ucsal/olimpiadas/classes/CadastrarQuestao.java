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
	static long proximaQuestaoId = 1;

	public CadastrarQuestao(Scanner in, List<Prova> provas, List<Questao> questoes) {
		this.in = in;
		this.provas = provas;
		this.questoes = questoes;
	}
	
	public void cadastrarQuestao() {
		
	}
}
