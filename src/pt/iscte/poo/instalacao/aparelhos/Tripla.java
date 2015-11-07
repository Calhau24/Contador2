package pt.iscte.poo.instalacao.aparelhos;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Instalacao;
import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.Linha;
import pt.iscte.poo.instalacao.Tomada;

public class Tripla implements Ligavel {



	private String id;
	private double potenciaMaxima;
	private double potenciaAtual;
	private ArrayList<Tomada>tomadas= new ArrayList<>();
	private boolean estado=false;
	private Linha linha;
	

	public Tripla ( String id , double potenciaMaxima, int nTomadas){
		this.id=id;
		this.potenciaMaxima= potenciaMaxima;
		for (int x = 0; x<nTomadas; x++)
			tomadas.add(new Tomada());
	}

	@Override
	public String getId() {
		return id;
	}
	@Override
	public double potenciaAtual() {
		return potenciaAtual;
	}	
	@Override
	public double potenciaMaxima() {
		return potenciaMaxima;
	}

	public void setPotenciaAtual(double potenciaAtual) {
		this.potenciaAtual = potenciaAtual;
	}	
	
	public void setPotenciaMaxima(double potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
		
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void aumenta(){
		for (Tomada t : tomadas)
			if (t.getEstado())
				potenciaAtual+= t.getLigavel().potenciaAtual();
	}
	@Override
	public boolean estaLigado() {
		if(estado==true){
			return true	;
		}
		return false;
	}
	@Override
	public void liga() {
		setEstado(true);
		adicionarTomadasALinha(linha);
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public void desliga() {
		setEstado(false);
		setPotenciaAtual(0.0);

	}
	
	public void adicionarTomadasALinha(Linha linha){
		this.linha=linha;
		for(Tomada t : tomadas){
			linha.addTomada(t);
	}
	}
	public static Tripla novoAparelho(JSONObject jason) {
		
		Long tmd=(Long)jason.get("nTomadas");
		
		Integer nTomadas =  Integer.valueOf(tmd.intValue());
		
		Tripla tripla = new Tripla((String) jason.get("id"), (double) jason.get("potenciaMaxima"), nTomadas);
		return tripla;
		
	}


	









}
