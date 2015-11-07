package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class Torradeira extends AparelhoPotenciaFixa {
	
	public Torradeira(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
		
	}

	public Torradeira(JSONObject jason){
		super(jason);
	}

	

}

