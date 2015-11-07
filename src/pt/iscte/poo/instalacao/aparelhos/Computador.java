package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class Computador extends AparelhoPotenciaVariavel{

	public Computador(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
	
	}

	public Computador(JSONObject jason){
		super(jason);
	}
	@Override
	public double potenciaAtual(){
			return (Math.random() * potenciaMaxima());
			
	}
	@Override
	public void liga() {
		setEstado(true);
		setPotenciaAtual(potenciaAtual());
	
	}

	

}
