package pt.iscte.poo.instalacao.aparelhos;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Relogio;


public class MaquinaLavar extends AparelhoPotenciaVariavel {
	private ArrayList<Programa> programas= new ArrayList<>();
	private Programa pAtual=null;
	private long tempo;
	
	public MaquinaLavar(String id, double potenciaMaxima) {
		super(id, potenciaMaxima);
		pAtual = null;
		
	}
	public MaquinaLavar(JSONObject jason){
		super(jason);
		setPotenciaAtual(0.0);
		JSONArray p=(JSONArray) jason.get("programas");
			for(int i=0; i< p.size();i++){
			
				programas.add(new Programa((JSONObject)p.get(i)));
				
			}
	}
	public ArrayList<Programa> getProgramas() {
		return programas;
	}

	public Programa getProgramaAtual(){
		return pAtual;
	}
	public void setProgramaAtual(String idProg) {
		for(Programa p:getProgramas())
			if(idProg.equals(p.getId()))
				pAtual= p;
				
	}

	public double potenciaAtual(){		
		double potenciaAtual = 0.0;
		long tempoInicial = tempo;
		for(Programa p: getProgramas()){
			if(p.equals(getProgramaAtual()))
			for(Ciclo cicloAtual : p.getCiclos()){
				if(tempoInicial + cicloAtual.getDuracao() < Relogio.getInstanciaUnica().getTempoAtual()){
					tempoInicial += cicloAtual.getDuracao();
					continue;
				}
				
			potenciaAtual = cicloAtual.getPotencia();
			break;
			}
		}
		
		return potenciaAtual;
	
}
	public void liga(){
		
		setEstado(true);
		tempo = Relogio.getInstanciaUnica().getTempoAtual();	
		setPotenciaAtual(potenciaAtual());
		
		
	}
	

}
