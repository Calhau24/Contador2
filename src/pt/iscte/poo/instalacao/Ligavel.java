package pt.iscte.poo.instalacao;

import org.json.simple.JSONObject;

public interface Ligavel {
		
	
		public void liga();
		public void desliga();
		public boolean estaLigado();
		public String getId();
		public double potenciaAtual();
		public double potenciaMaxima();
		
}
