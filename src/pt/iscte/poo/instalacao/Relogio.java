package pt.iscte.poo.instalacao;

/**
 * Esta class implementa o relogio usado para controlar
 * o tempo de utilizacao dos aparelhos.
 * @author People
 *
 * @version 0.01
 */
public class Relogio {
	
	private static Relogio instance = new Relogio();
	private int tempo=0;
	
	/**
	 * Retorna a instancia em que o relogio se encontra
	 * @return
	 */
	public static Relogio getInstanciaUnica() {
		return instance;
	}
	
	/**
	 * Adiciona 1 valor ao tique do relogio.
	 */
	public void tique() {
		setTempo(getTempoAtual()+1);
	}
	
	/**
	 * Define o tempo atual.
	 * @param tempo tempo atual
	 */
	private void setTempo(int tempo) {
		this.tempo=tempo;
	}

	/**
	 * Retorna qual o tempo em que nos encontramos.
	 * @return tempo atual
	 */
	public int getTempoAtual() {
		return tempo;
	}

}
