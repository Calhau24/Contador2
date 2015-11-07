package pt.iscte.poo.instalacao;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pt.iscte.poo.instalacao.aparelhos.AparelhoPotenciaFixa;
import pt.iscte.poo.instalacao.aparelhos.AparelhoPotenciaVariavel;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.MaquinaLavar;
import pt.iscte.poo.instalacao.aparelhos.MicroOndas;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;
import pt.iscte.poo.instalacao.aparelhos.lampadaVariavel;


public abstract class Aparelho implements Ligavel{
	private String id;
	private double potenciaMaxima;
	private double potenciaAtual;
	private boolean estado;
	
	public Aparelho(String id, double potenciaMaxima) {
		this.id=id;
		this.potenciaMaxima=potenciaMaxima;
		setEstado(false);
		setPotenciaAtual(0.0);
	}
	
	public Aparelho(JSONObject jason){
		id = (String)jason.get("id");
	
	}
	
	public double potenciaAtual() {
		return potenciaAtual;
	}
	public void setPotenciaAtual(double potenciaAtual) {
		this.potenciaAtual = potenciaAtual;
	}
	public double potenciaMaxima() {
		return potenciaMaxima;
	}
	public void setPotenciaMaxima(double potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
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
		
	}
	@Override
	public void desliga() {
		setEstado(false);
		setPotenciaAtual(0.0);

	}


	
	public static Aparelho novoAparelho(JSONObject jason) {
		Aparelho apar=	null;
		String tAparelho=(String)(jason.get("tipo"));
        switch (tAparelho) {
            case "frigorifico":
            	apar= new Frigorifico(jason);
                break;
            case "maqLavarRoupa":
            	 apar= new MaquinaLavar(jason);
                break;
            case "microOndas":
            	apar= new MicroOndas(jason);
                break;
            case "lampadaVariavel":
            	apar= new lampadaVariavel(jason);
                break;
            case "computador":
            	apar= new Computador(jason);
                break;
            case "torradeira":
            	apar= new Torradeira(jason);
                break;
             case "lampada":
            	apar= new Lampada(jason);
                break;
            default:
                 System.out.println("O aparelho nao existe!");
         }

		
		return apar;
	}

	
}









