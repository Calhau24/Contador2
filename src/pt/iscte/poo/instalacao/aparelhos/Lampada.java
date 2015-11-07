package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class Lampada extends AparelhoPotenciaFixa{


	public Lampada(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
		setEstado(false);
		setPotenciaAtual(0.0);
	}
	public Lampada(JSONObject jason){
		super(jason);
	}
	


}
