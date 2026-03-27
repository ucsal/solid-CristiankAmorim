package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.classes.AplicarProva;
import br.com.ucsal.olimpiadas.classes.CadastrarParticipante;
import br.com.ucsal.olimpiadas.classes.CadastrarProva;
import br.com.ucsal.olimpiadas.classes.CadastrarQuestao;
import br.com.ucsal.olimpiadas.classes.EscolherParticipante;
import br.com.ucsal.olimpiadas.classes.EscolherProva;
import br.com.ucsal.olimpiadas.classes.ListarTentativas;
import br.com.ucsal.olimpiadas.classes.Menu;
import br.com.ucsal.olimpiadas.classes.Seed;

public class App {

	static final List<Participante> participantes = new ArrayList<>();
	static final List<Prova> provas = new ArrayList<>();
	static final List<Questao> questoes = new ArrayList<>();
	static final List<Tentativa> tentativas = new ArrayList<>();
	
	private static final Scanner in = new Scanner(System.in);
	static CadastrarParticipante cadastrarPart = new CadastrarParticipante(in, participantes);
	static CadastrarProva cadastrarProva = new CadastrarProva(in, provas);
	static EscolherProva escolherProva = new EscolherProva(in, provas);
	static CadastrarQuestao cadastrarQuestao = new CadastrarQuestao(in, provas, questoes, escolherProva);
	static EscolherParticipante escolherParticipante = new EscolherParticipante(in, participantes);
	static AplicarProva aplicarProva = new AplicarProva(in, participantes, provas, questoes, 
			tentativas, escolherParticipante, escolherProva);
	static ListarTentativas listarTentativas = new ListarTentativas(tentativas);
	static Seed seed = new Seed(provas, questoes);
	static Menu menu = new Menu();
	
	public static void main(String[] args) {
		seed.seed();

		while (true) {
			menu.showMenu();

			switch (in.nextLine()) {
			case "1" -> cadastrarPart.cadastrarParticipante();
			case "2" -> cadastrarProva.cadastrarProva();
			case "3" -> cadastrarQuestao.cadastrarQuestao();
			case "4" -> aplicarProva.aplicarProva();
			case "5" -> listarTentativas.listarTentativas();
			case "0" -> {
				System.out.println("tchau");
				return;
			}
			default -> System.out.println("opção inválida");
			}
		}
	}

}