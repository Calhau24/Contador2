package pt.iscte.poo.eventos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;

public abstract class Evento implements Comparable<Evento>{

		public abstract long getTempo();

		public abstract String getAccao();
		
		public abstract Ligavel getLigavel();
		
		public abstract void execute();
		
		public static Evento novoEvento(JSONObject evento, Ligavel ligavel){
			String a = (String) evento.get("accao");
			Evento event = null;
			switch(a){
			case "LIGA":
				event=new EventoLigar(evento, ligavel);
				break;
				
			case "DESLIGA":
				event= new EventoDesligar(evento, ligavel);
				break;
			case "AUMENTA":
				event= new EventoAumentar(evento, ligavel);
				break;
			case "PROGRAMA":
				event= new EventoPrograma(evento, ligavel);
				break;
			case "DIMINUICAO":
				event= new EventoDiminuir(evento, ligavel);
				break;
			 default:
	             System.out.println("O Evento nao existe!");
	             break;
			}
			return event;
		}

		@Override
		public int compareTo(Evento o) {
			int ct = (int) o.getTempo(); 
			 
			return  (int) (this.getTempo() - ct);

		}
	}