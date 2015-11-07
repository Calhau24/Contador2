package pt.iscte.poo.eventos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;

public class EventoLigar extends Evento {

	private Ligavel ligavel;
	private Long tempo;
	private String accao;
	
	public EventoLigar(JSONObject evento, Ligavel ligavel) {
		this.ligavel= ligavel;
		accao=(String) evento.get("accao");
		tempo = (Long) evento.get("tempo");
		
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

	@Override
	public void execute() {
		
		getLigavel().liga();
		
	}

}
