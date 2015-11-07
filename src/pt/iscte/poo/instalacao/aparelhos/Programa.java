package pt.iscte.poo.instalacao.aparelhos;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Programa {



	private String id;
	private ArrayList<Ciclo> ciclos = new ArrayList<Ciclo>();
	private Ciclo cicloAtual;


	public Programa(JSONObject jason ){
	
		this.id=(String)jason.get("id");
	
		JSONArray ja= (JSONArray) jason.get("ciclos");
		for(int i=0; i<ja.size();i++){	
	

		Ciclo c= new Ciclo((JSONObject)ja.get(i));
		System.out.println("Programa:" +this.id+ "Duracao" +c.getDuracao()+"Potencia"+c.getPotencia());
		ciclos.add(c);
		}
		cicloAtual = getCiclos().get(0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Ciclo> getCiclos() {		
		return ciclos;
	}



	public Ciclo getCicloActual( ){
		return cicloAtual;
		
	}
	
	



}
