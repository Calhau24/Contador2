package pt.iscte.poo.eventos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;

public class EventoDesligar extends Evento {

	private Ligavel ligavel;
	private String accao;
	private long tempo;

	public EventoDesligar(JSONObject evento, Ligavel ligavel) {
		this.ligavel= ligavel;
		accao=(String) evento.get("accao");
		tempo = (long) evento.get("tempo");
	
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
		getLigavel().desliga();
	}

}
