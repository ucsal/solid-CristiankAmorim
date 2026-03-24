package br.com.ucsal.olimpiadas.classes;

import java.util.List;

import br.com.ucsal.olimpiadas.Tentativa;
import br.com.ucsal.olimpiadas.repository.ListarTentativasRepository;

public class ListarTentativas implements ListarTentativasRepository {

	private final List<Tentativa> tentativas;
	private final CalcularNota calcularNota = new CalcularNota();
	
	public ListarTentativas(List<Tentativa> tentativas) {
		this.tentativas = tentativas;
	}
	
	public void listarTentativas() {
		System.out.println("\n--- Tentativas ---");
		for (var t : tentativas) {
			System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(),
					t.getProvaId(), calcularNota.calcularNota(t), t.getRespostas().size());
		}
	}
}
