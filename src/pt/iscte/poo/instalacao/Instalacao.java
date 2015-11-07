package pt.iscte.poo.instalacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.PriorityQueue;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.eventos.Evento;
import pt.iscte.poo.graficos.Chart;
import pt.iscte.poo.instalacao.aparelhos.AparelhoPotenciaFixa;
import pt.iscte.poo.instalacao.aparelhos.AparelhoPotenciaVariavel;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;
import pt.iscte.poo.instalacao.aparelhos.Tripla;

public class Instalacao extends Observable {

	private static Instalacao instance = new Instalacao();

	private ArrayList<Linha> linhas = new ArrayList<>();
	private PriorityQueue<Evento> eventos = new PriorityQueue<Evento>();

	private Tripla tripla;

	public static Instalacao getInstanciaUnica(){
		return instance;
	}

	public void removeTodasAsLinhas() {
		linhas.clear();
	}

	public void novaLinha(String divisao, int nTomadas) {	
		linhas.add(new Linha(divisao, nTomadas));
	}

	public Tomada getTomadaLivre(String divisao) {
		for (Linha l : linhas)
			if (l.getNome().equals(divisao))
				return l.getTomadaLivre();
		return null;
	}

	public void ligaAparelhoATomadaLivre(String divisao, Ligavel apar) {
		Tomada tlivre = new Tomada();
		for (Linha l : linhas)
			if (l.getNome().equals(divisao)){
				if (l.isTomadaLivre()){
					tlivre = l.getTomadaLivre();
					if(apar.getId().equals("tripla")){
						tripla=(Tripla) apar;
						tripla.adicionarTomadasALinha(l);
						tlivre.setLigavel(tripla);
						tlivre.setEstado(true);
					}else{
						tlivre.setLigavel(apar);
						tlivre.setEstado(true);
						//apar.liga();
					}
				}
			}
	}

		public double potenciaNaLinha(String divisao) {
			double potenciaL=0.0;
			for (Linha l : linhas)
				if (l.getNome().equals(divisao))
					for (Tomada t : l.getTomadas())
						if (t.getEstado())
							potenciaL += t.getLigavel().potenciaAtual();

			return potenciaL;
		}


		public Ligavel getAparelho(String nome) {
			for (Linha l : linhas)
				for (Tomada t : l.getTomadas())
					if (t.getEstado())
						if (t.getLigavel().getId().equals(nome))
							return (Aparelho)t.getLigavel();

			return null;

		}
		@Override
		public String toString() {
			return  "T:" + Relogio.getInstanciaUnica().getTempoAtual() +"\n"+
					"Cozinha: " +potenciaNaLinha("cozinha") +"W" +"\n"+
					"Quartos:" + potenciaNaLinha("quartos") + "W" + "\n"+
					"Sala:" + potenciaNaLinha("sala") + "W\n";

		}
		
		public void init(JSONArray objectos) {


			for(int n = 0; n < objectos.size(); n++)
			{
				JSONObject jason=  (JSONObject) objectos.get(n);
				String nome  = (String)jason.get("nome");
				Long tmd=(Long)jason.get("tomadas");
				Integer tomada =  Integer.valueOf(tmd.intValue());
				novaLinha(nome,tomada);


			}

		}

		public List<Ligavel> lerAparelhos(JSONArray listaAparelhos) {
			Ligavel ligavel;
			List<Ligavel> lAp= new LinkedList<>();
			Ligavel aparTeste;
			for(int n=0; n<listaAparelhos.size(); n++ ){
				JSONObject jason = (JSONObject) listaAparelhos.get(n);
				String tAparelho=(String)(jason.get("tipo"));
				if(tAparelho.equals("tripla")){
					aparTeste=Tripla.novoAparelho(jason);
					lAp.add(aparTeste);
				}else{
					aparTeste=Aparelho.novoAparelho(jason);
					lAp.add(aparTeste);
				}
			}
			return lAp;
		}



		public void lerLigacoes(JSONArray listaLigacoes, List<Ligavel> aparelhos) {

			for(int n = 0; n < listaLigacoes.size(); n++){
				JSONObject jason=  (JSONObject) listaLigacoes.get(n);
				String nome  = (String)jason.get("aparelho");

				Aparelho apar=(Aparelho)getAparelho(nome);

				String divisao= (String)jason.get("ligadoA");
				for(int i=0; i<aparelhos.size(); i++){
					if(nome.equals(aparelhos.get(i).getId())){
						ligaAparelhoATomadaLivre(divisao,aparelhos.get(i));
				
					}
				}


			}
		}

		public void lerEventos(JSONArray listaEventos) {
			JSONObject e ;
			Ligavel ligavel = null ;
			for(int i =0;i< listaEventos.size();i++ ){
				e = (JSONObject) listaEventos.get(i);

				ligavel = getAparelho((String) (e.get("idAparelho")));

				eventos.add(Evento.novoEvento(e, ligavel));

			}

					for( Evento ev: eventos){
						Ligavel l= ev.getLigavel();
						System.out.println("Ligavel:" +l+ " tempo" +ev.getTempo()+ "accao" +ev.getAccao());
					}


		}

		public void simula(long fim) {
			HashMap<String, Double> potencias = new HashMap<String, Double>() ;
			while(Relogio.getInstanciaUnica().getTempoAtual()!=fim){
				while(eventos.peek()!=null  &&  Relogio.getInstanciaUnica().getTempoAtual()==eventos.peek().getTempo()){
					
					eventos.poll().execute(); 
				} 

				for(Linha linha : linhas){
					potencias.put(linha.getNome(), potenciaNaLinha(linha.getNome()));
				}
				setChanged();
				notifyObservers(potencias);
				Relogio.getInstanciaUnica().tique();
				potencias.clear();
			}
		}

		
	}
