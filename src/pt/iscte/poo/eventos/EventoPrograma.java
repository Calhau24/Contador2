package pt.iscte.poo.eventos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.aparelhos.AparelhoPotenciaVariavel;
import pt.iscte.poo.instalacao.aparelhos.MaquinaLavar;

public class EventoPrograma extends Evento {

	private long tempo;
	private String accao;
	private Ligavel ligavel;
	private String programa;
	
	public EventoPrograma(JSONObject evento, Ligavel ligavel) {
		this.ligavel= ligavel;
		accao=(String) evento.get("accao");
		
		tempo = (Long) evento.get("tempo");
		
		
		programa = (String) evento.get("programa");
		
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
	public String getPrograma(){
		return programa;
	}
	@Override
	public void execute() {
		MaquinaLavar apar=(MaquinaLavar) getLigavel();
		apar.setProgramaAtual(getPrograma());
	}




}
