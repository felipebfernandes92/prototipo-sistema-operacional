package EscalonadorDeProcessos;

public class Processo {

	private Integer burst;
	private Integer chegada;
	private Integer prioridade;
	private Integer tempoEspera;
	private Integer tempoResposta;
	private Integer turnAround;
	
	public Integer getBurst() {
		return burst;
	}
	public void setBurst(Integer burst) {
		this.burst = burst;
	}
	public Integer getChegada() {
		return chegada;
	}
	public void setChegada(Integer chegada) {
		this.chegada = chegada;
	}
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	public Integer getTempoEspera() {
		return tempoEspera;
	}
	public Integer setTempoEspera(Integer tempoEspera) {
		return this.tempoEspera = tempoEspera;
	}
	public Integer getTempoResposta() {
		return tempoResposta;
	}
	public Integer setTempoResposta(Integer tempoResposta) {
		return this.tempoResposta = tempoResposta;
	}
	public Integer getTurnAround() {
		return turnAround;
	}
	public Integer setTurnAround(Integer turnAround) {
		return this.turnAround = turnAround;
	}
	
}
