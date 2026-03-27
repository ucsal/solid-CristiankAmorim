package br.com.ucsal.olimpiadas.classes;

public class OpcaoMenu {

	private final int id;
	private final String texto;
	
	public OpcaoMenu(int id, String texto) {
		this.id = id;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}
	
	
}
