package pt.iscte.poo.instalacao;

public class Tomada {
	
	private boolean estado = false;
	private Ligavel ligavel;
	private boolean tmdTripla;


	public Ligavel getLigavel() {
		return ligavel;
	}

	public void setLigavel(Ligavel ligavel) {
		this.ligavel = ligavel;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean tomadaDaTripla(){
		return tmdTripla;
	}
	public void setTomadaDaTripla(boolean tmdTripla){
		this.tmdTripla=tmdTripla;
	}

}
