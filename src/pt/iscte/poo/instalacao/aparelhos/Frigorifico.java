package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class Frigorifico extends AparelhoPotenciaFixa{


	public Frigorifico(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
	}
	public Frigorifico(JSONObject jason){
		super(jason);
	}

}