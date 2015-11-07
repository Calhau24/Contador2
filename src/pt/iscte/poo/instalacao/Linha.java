package pt.iscte.poo.instalacao;

import java.util.ArrayList;

public class Linha {

	ArrayList<Tomada> tomadas = new ArrayList<>();
	String nome;

	
	public Linha (String nome,int nTomadas) {
		this.nome = nome;
		for (int x = 0; x<nTomadas; x++) 
			tomadas.add(new Tomada());
	}


	public Tomada getTomadaLivre(){
		for (Tomada t : getTomadas())
			if (!t.getEstado())
				return t;
		return null;
	}
	
	public boolean isTomadaLivre(){
		for (Tomada t : getTomadas())
			if (!t.getEstado())
				return true;
		return false;
	}
	
	public ArrayList<Tomada> getTomadas() {
		return tomadas;
	}

	public void addTomada(Tomada tomada){
		tomadas.add(tomada);
	}
	public String getNome() {
		return nome;
	}
	
	
	
}
