package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class MicroOndas extends AparelhoPotenciaVariavel {
	private double aux;
	
	public MicroOndas(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
	
	}
	public MicroOndas(JSONObject jason){
		super(jason);
	}

		
	


	
}
