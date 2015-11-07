package pt.iscte.poo.instalacao.aparelhos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;



public abstract class AparelhoPotenciaFixa extends Aparelho {

	private double potenciaMaxima;
	private String id;
	private boolean estado;
	private double potenciaAtual;

	public AparelhoPotenciaFixa(String id, double potenciaMaxima) {
		super(id,potenciaMaxima);
		setEstado(false);
		setPotenciaAtual(0.0);
	}
	
	public AparelhoPotenciaFixa(JSONObject jason){
		super(jason);
		setPotenciaMaxima((double) jason.get("potencia"));
	
	}
	public void liga() {
		setEstado(true);
		setPotenciaAtual(potenciaMaxima());
	}


}
