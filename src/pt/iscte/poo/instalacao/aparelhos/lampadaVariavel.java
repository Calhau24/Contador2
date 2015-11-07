package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;


public class lampadaVariavel extends AparelhoPotenciaVariavel {

	public lampadaVariavel(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
	
	}
	public lampadaVariavel(JSONObject jason){
		super(jason);
	}
	@Override
	public void aumenta(int i) {
		// TODO Auto-generated method stub
		
	}

}
