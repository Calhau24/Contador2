package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;

public abstract class AparelhoPotenciaVariavel extends Aparelho{
	private double potenciaMaxima;
	private String id;
	private boolean estado;
	private double potenciaAtual;
	private double aux;
	private String tipo;
	private Integer nTomadas;
	
	public AparelhoPotenciaVariavel(String id, double potenciaMaxima){
		super(id,potenciaMaxima);
		setEstado(false);
		setPotenciaAtual(0.0);
	}
	
	public AparelhoPotenciaVariavel(JSONObject jason){
		super(jason);
		setPotenciaMaxima((double) jason.get("potenciaMaxima"));
		setPotenciaAtual(0.0);
	
	}
	public Double getAux() {
		return aux;
	}
	public void setAux(double aux) {
		this.aux = aux;
	}
	@Override
	public boolean estaLigado() {
		if(isEstado()==true){
			return true	;
		}
		return false;
	}


	@Override
	public void liga() {
		setEstado(true);
		setPotenciaAtual(getAux()+potenciaAtual());
	
	}
	@Override
	public void desliga() {
		setEstado(false);
		setPotenciaAtual(0.0);

	}
	
	public void aumenta(int i) {
		setAux(i);
		if(i>potenciaMaxima()-potenciaAtual()){
			setAux(potenciaMaxima()-potenciaAtual());
			if(estaLigado()==true){
				setPotenciaAtual(potenciaAtual()+getAux());
		}
	}
	
	}
	
}
