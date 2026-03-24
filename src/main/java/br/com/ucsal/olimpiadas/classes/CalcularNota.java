package br.com.ucsal.olimpiadas.classes;

import br.com.ucsal.olimpiadas.Tentativa;

public class CalcularNota {

	public int calcularNota(Tentativa tentativa) {
		int acertos = 0;
		for (var r : tentativa.getRespostas()) {
			if (r.isCorreta())
				acertos++;
		}
		return acertos;
	}
}
