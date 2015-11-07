package pt.iscte.poo.eventos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;

public class EventoDiminuir extends Evento {


	private Ligavel ligavel;
	private Integer tempo;
	private String accao;

	public EventoDiminuir(JSONObject jason, Ligavel ligavel){
		this.ligavel= ligavel;
		String accao = (String)	jason.get("accao");

		Long t = (Long) jason.get("tempo");
		tempo=Integer.valueOf(t.intValue());



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
		// TODO Auto-generated method stub

	}

}
