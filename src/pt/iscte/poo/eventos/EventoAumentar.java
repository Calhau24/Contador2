package pt.iscte.poo.eventos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.aparelhos.AparelhoPotenciaVariavel;

public class EventoAumentar extends Evento {

	private String accao;
	private Ligavel ligavel;
	private long tempo;
	private double valor;
	
	public EventoAumentar(JSONObject evento, Ligavel ligavel) {
		this.ligavel= ligavel;
		accao=(String) evento.get("accao");
		
		tempo = (Long) evento.get("tempo");
	
		
		 valor = (double) evento.get("valor");
		
	}

	@Override
	public long getTempo() {
		return tempo;
	}

	@Override
	public String getAccao() {
		return accao;
	}

	@Override
	public Ligavel getLigavel() {
		return ligavel;
	}
	public int getValor(){
		return (int) valor;
	}
	@Override
	public void execute() {
		AparelhoPotenciaVariavel apar= (AparelhoPotenciaVariavel) getLigavel();
		apar.aumenta(getValor());
	}

}
