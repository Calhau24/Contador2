package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class Ciclo {

	private Integer duracao;
	private double potencia;


	public Ciclo(JSONObject jason) {
		Long d=(Long)jason.get("duracao");
		duracao =  Integer.valueOf(d.intValue());
		Long p= (Long)jason.get("potencia");
		potencia = Double.valueOf(p.intValue());
	}

	

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
}
