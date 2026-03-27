package br.com.ucsal.olimpiadas.classes;

import br.com.ucsal.olimpiadas.Tentativa;
import br.com.ucsal.olimpiadas.repository.CalcularNotaRepository;

public class CalcularNota implements CalcularNotaRepository {

	public int calcularNota(Tentativa tentativa) {
		int acertos = 0;
		for (var r : tentativa.getRespostas()) {
			if (r.isCorreta())
				acertos++;
		}
		return acertos;
	}
}
