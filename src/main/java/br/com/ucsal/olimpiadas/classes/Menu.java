package br.com.ucsal.olimpiadas.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.repository.MenuRepository;

public class Menu implements MenuRepository{

	private final List<OpcaoMenu> opcoes = new ArrayList<>();
	
	public void registrarNovaOpcao(OpcaoMenu opcao) {
		opcoes.add(opcao);	
	}
	
	public void showMenu() {
		System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
		for(var o : opcoes) {
			System.out.println(o.getId() + ") " + o.getTexto());
		}
		System.out.println("0) Sair");
		System.out.println("> ");
	}
}
